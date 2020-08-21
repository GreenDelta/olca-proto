package org.openlca.proto.input;

import org.openlca.core.database.FlowDao;
import org.openlca.core.model.Flow;
import org.openlca.core.model.FlowPropertyFactor;
import org.openlca.core.model.FlowType;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class FlowImport {

  private final ProtoImport imp;

  public FlowImport(ProtoImport imp) {
    this.imp = imp;
  }

  public Flow of(String id) {
    if (id == null)
      return null;
    var flow = imp.get(Flow.class, id);

    // check if we are in update mode
    var update = false;
    if (flow != null) {
      if (imp.isHandled(flow)
        || imp.noUpdates())
        return flow;
      update = true;
    }

    // check the proto object
    var proto = imp.store.getFlow(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!imp.shouldUpdate(flow, wrap))
        return flow;
    }

    // map the data
    if (flow == null) {
      flow = new Flow();
      flow.refId = id;
    }
    wrap.mapTo(flow, imp);
    map(proto, flow);

    // insert it
    var dao = new FlowDao(imp.db);
    flow = update
      ? dao.update(flow)
      : dao.insert(flow);
    imp.putHandled(flow);
    return flow;
  }

  private void map(Proto.Flow proto, Flow flow) {

    flow.flowType = typeOf(proto);
    flow.casNumber = proto.getCas();
    flow.synonyms = proto.getSynonyms();
    flow.synonyms = proto.getFormula();
    flow.infrastructureFlow = proto.getInfrastructureFlow();
    var locID = proto.getLocation().getId();
    if (Strings.notEmpty(locID)) {
      flow.location = new LocationImport(imp).of(locID);
    }

    // flow property factors
    for (var prop : proto.getFlowPropertiesList()) {
      var f = new FlowPropertyFactor();
      var propID = prop.getFlowProperty().getId();
      if (Strings.notEmpty(propID)) {
        f.flowProperty = new FlowPropertyImport(imp).of(propID);
      }
      f.conversionFactor = prop.getConversionFactor();
      flow.flowPropertyFactors.add(f);
      if (prop.getReferenceFlowProperty()) {
        flow.referenceFlowProperty = f.flowProperty;
      }
    }
  }

  private FlowType typeOf(Proto.Flow proto) {
    switch (proto.getFlowType()) {
      case ELEMENTARY_FLOW:
        return FlowType.ELEMENTARY_FLOW;
      case PRODUCT_FLOW:
        return FlowType.PRODUCT_FLOW;
      case WASTE_FLOW:
        return FlowType.WASTE_FLOW;
      default:
        return null;
    }
  }
}
