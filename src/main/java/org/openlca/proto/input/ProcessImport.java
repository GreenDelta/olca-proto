package org.openlca.proto.input;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.openlca.core.database.ProcessDao;
import org.openlca.core.model.Actor;
import org.openlca.core.model.DQSystem;
import org.openlca.core.model.Exchange;
import org.openlca.core.model.Parameter;
import org.openlca.core.model.Process;
import org.openlca.core.model.ProcessDocumentation;
import org.openlca.core.model.ProcessType;
import org.openlca.core.model.Source;
import org.openlca.jsonld.Json;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class ProcessImport {

  private final ProtoImport imp;
  private boolean inUpdateMode;

  public ProcessImport(ProtoImport imp) {
    this.imp = imp;
  }

  public Process of(String id) {
    if (id == null)
      return null;
    var process = imp.get(Process.class, id);

    // check if we are in update mode
    inUpdateMode = false;
    if (process != null) {
      if (imp.isHandled(process)
        || imp.noUpdates())
        return process;
      inUpdateMode = true;
    }

    // check the proto object
    var proto = imp.store.getProcess(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (inUpdateMode) {
      if (!imp.shouldUpdate(process, wrap))
        return process;
    }

    // map the data
    if (process == null) {
      process = new Process();
      process.refId = id;
    }
    wrap.mapTo(process, imp);
    map(proto, process);

    // insert it
    var dao = new ProcessDao(imp.db);
    process = inUpdateMode
      ? dao.update(process)
      : dao.insert(process);
    imp.putHandled(process);
    return process;
  }

  private void map(Proto.Process proto, Process p) {

    p.processType = proto.getProcessType() == Proto.ProcessType.LCI_RESULT
      ? ProcessType.LCI_RESULT
      : ProcessType.UNIT_PROCESS;
    p.infrastructureProcess = proto.getInfrastructureProcess();
    p.defaultAllocationMethod = Util.allocationMethod(
      proto.getDefaultAllocationMethod());
    p.documentation = doc(proto.getProcessDocumentation());

    // DQ systems
    p.dqEntry = proto.getDqEntry();
    p.dqSystem = dqSystem(proto.getDqSystem());
    p.exchangeDqSystem = dqSystem(proto.getExchangeDqSystem());
    p.socialDqSystem = dqSystem(proto.getSocialDqSystem());

    // parameters
    p.parameters.clear();
    for (var protoParam : proto.getParametersList()) {
      var param = new Parameter();
      ProtoWrap.of(protoParam).mapTo(param, imp);
      ParameterImport.map(protoParam, param);
      p.parameters.add(param);
    }

    // when we are in update mode, we want to keep the
    // IDs of existing exchanges because they are may
    // linked in product systems
    Map<Integer, Exchange> oldExchanges = null;
    if (inUpdateMode) {
      var m = new HashMap<Integer, Exchange>();
      p.exchanges.forEach(e -> {
        if (e.internalId != 0) {
          m.put(e.internalId, e);
        }
      });
      oldExchanges = m;
      p.exchanges.clear();
      p.quantitativeReference = null;
    }

    p.lastInternalId = proto.getLastInternalId();
    for (var protoEx : proto.getExchangesList()) {
      Exchange e = null;
      if (oldExchanges != null) {
        e = oldExchanges.get(protoEx.getInternalId());
      }
      if (e == null) {
        e = new Exchange();
        e.internalId = protoEx.getInternalId();
        if (e.internalId == 0) {
          p.lastInternalId++;
          e.internalId = p.lastInternalId;
        }
      }

      mapExchange(protoEx, e);
      if (protoEx.getQuantitativeReference()) {
        p.quantitativeReference = e;
      }
    }
  }

  private ProcessDocumentation doc(Proto.ProcessDocumentation proto) {
    var doc = new ProcessDocumentation();

    // simple string fields
    doc.completeness = proto.getCompletenessDescription();
    doc.dataCollectionPeriod = proto.getDataCollectionDescription();
    doc.dataSelection = proto.getDataSelectionDescription();
    doc.dataTreatment = proto.getDataTreatmentDescription();
    doc.geography = proto.getGeographyDescription();
    doc.intendedApplication = proto.getIntendedApplication();
    doc.inventoryMethod = proto.getInventoryMethodDescription();
    doc.modelingConstants = proto.getModelingConstantsDescription();
    doc.project = proto.getProjectDescription();
    doc.restrictions = proto.getRestrictionsDescription();
    doc.reviewDetails = proto.getReviewDetails();
    doc.sampling = proto.getSamplingDescription();
    doc.technology = proto.getTechnologyDescription();
    doc.time = proto.getTimeDescription();

    // references
    doc.dataDocumentor = actor(proto.getDataDocumentor());
    doc.dataGenerator = actor(proto.getDataGenerator());
    doc.dataSetOwner = actor(proto.getDataSetOwner());
    doc.publication = source(proto.getPublication());
    doc.reviewer = actor(proto.getReviewer());
    for (var ref : proto.getSourcesList()) {
      var source = source(ref);
      if (source != null) {
        doc.sources.add(source);
      }
    }

    doc.copyright = proto.getCopyright();
    doc.creationDate = Json.parseDate(proto.getCreationDate());
    doc.validFrom = Json.parseDate(proto.getValidFrom());
    doc.validUntil = Json.parseDate(proto.getValidUntil());
    return doc;
  }

  private Actor actor(Proto.Ref ref) {
    if (ref == null || Strings.nullOrEmpty(ref.getId()))
      return null;
    return new ActorImport(imp).of(ref.getId());
  }

  private Source source(Proto.Ref ref) {
    if (ref == null || Strings.nullOrEmpty(ref.getId()))
      return null;
    return new SourceImport(imp).of(ref.getId());
  }

  private DQSystem dqSystem(Proto.Ref ref) {
    if (ref == null || Strings.nullOrEmpty(ref.getId()))
      return null;
    return new DqSystemImport(imp).of(ref.getId());
  }

  private void mapExchange(Proto.Exchange proto, Exchange e) {
    e.isAvoided = proto.getAvoidedProduct();
    e.isInput = proto.getInput();
    e.baseUncertainty = proto.getBaseUncertainty() == 0
      ? null
      : proto.getBaseUncertainty();
    e.amount = proto.getAmount();
    e.formula = Strings.nullIfEmpty(proto.getAmountFormula());
    e.dqEntry = Strings.nullIfEmpty(proto.getDqEntry());
    e.description = Strings.nullIfEmpty(proto.getDescription());
    e.uncertainty = Util.uncertainty(proto.getUncertainty());

    // costs
    e.costFormula = Strings.nullIfEmpty(proto.getCostFormula());
    e.costs = proto.getCostValue() == 0
      ? null
      : proto.getCostValue();
    var currencyID = proto.getCurrency().getId();
    if (Strings.notEmpty(currencyID)) {
      e.currency = new CurrencyImport(imp).of(currencyID);
    }

    // flow references
    var flowID = proto.getFlow().getId();
    e.flow = new FlowImport(imp).of(flowID);
    if (e.flow == null)
      return;

    var propID = proto.getFlowProperty().getId();
    if (Strings.nullOrEmpty(propID)) {
      e.flowPropertyFactor = e.flow.getReferenceFactor();
    } else {
      e.flowPropertyFactor = e.flow.flowPropertyFactors.stream()
        .filter(f -> f.flowProperty != null
          && Objects.equals(f.flowProperty.refId, propID))
        .findAny()
        .orElse(null);
    }

    if (e.flowPropertyFactor == null)
      return;
    var prop = e.flowPropertyFactor.flowProperty;
    if (prop == null || prop.unitGroup == null)
      return;
    var unitID = proto.getUnit().getId();
    if (Strings.nullOrEmpty(unitID)) {
      e.unit = prop.unitGroup.referenceUnit;
    } else {
      e.unit = prop.unitGroup.units.stream()
        .filter(u -> Objects.equals(u.refId, unitID))
        .findAny()
        .orElse(null);
    }
  }
}
