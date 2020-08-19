package org.openlca.proto.input;

import org.openlca.core.database.FlowPropertyDao;
import org.openlca.core.model.FlowProperty;
import org.openlca.core.model.FlowPropertyType;
import org.openlca.jsonld.Enums;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class FlowPropertyImport {

  private final ImportConfig config;

  public FlowPropertyImport(ImportConfig config) {
    this.config = config;
  }

  public FlowProperty of(String id) {
    if (id == null)
      return null;
    var flowProperty = config.get(FlowProperty.class, id);

    // check if we are in update mode
    var update = false;
    if (flowProperty != null) {
      if (config.isHandled(flowProperty)
        || config.noUpdates())
        return flowProperty;
      update = true;
    }

    // check the proto object
    var proto = config.store.getFlowProperty(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(flowProperty, wrap))
        return flowProperty;
    }

    // map the data
    if (flowProperty == null) {
      flowProperty = new FlowProperty();
      flowProperty.refId = id;
    }
    wrap.mapTo(flowProperty, config);
    map(proto, flowProperty);

    // insert it
    var dao = new FlowPropertyDao(config.db);
    flowProperty = update
      ? dao.update(flowProperty)
      : dao.insert(flowProperty);
    config.putHandled(flowProperty);
    return flowProperty;
  }

  private void map(Proto.FlowProperty proto, FlowProperty flowProperty) {
    var type = proto.getFlowPropertyType().name();
    if (Strings.notEmpty(type)) {
      flowProperty.flowPropertyType = Enums.getValue(
        type, FlowPropertyType.class);
    }
    var unitGroupID = proto.getUnitGroup().getId();
    if (Strings.notEmpty(unitGroupID)) {
      flowProperty.unitGroup = new UnitGroupImport(config)
        .of(unitGroupID);
    }
  }
}

