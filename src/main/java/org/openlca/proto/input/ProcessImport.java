package org.openlca.proto.input;

import org.openlca.core.database.ProcessDao;
import org.openlca.core.model.Actor;
import org.openlca.core.model.Process;
import org.openlca.core.model.ProcessDocumentation;
import org.openlca.core.model.ProcessType;
import org.openlca.core.model.Source;
import org.openlca.jsonld.Json;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class ProcessImport {

  private final ProtoImport imp;

  public ProcessImport(ProtoImport imp) {
    this.imp = imp;
  }

  public Process of(String id) {
    if (id == null)
      return null;
    var process = imp.get(Process.class, id);

    // check if we are in update mode
    var update = false;
    if (process != null) {
      if (imp.isHandled(process)
        || imp.noUpdates())
        return process;
      update = true;
    }

    // check the proto object
    var proto = imp.store.getProcess(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
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
    process = update
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
}
