package org.openlca.proto.input;

import org.openlca.core.database.FlowDao;
import org.openlca.core.model.Flow;
import org.openlca.proto.Proto;

public class FlowImport {

  private final ProtoImport config;

  public FlowImport(ProtoImport config) {
    this.config = config;
  }

  public Flow of(String id) {
    if (id == null)
      return null;
    var flow = config.get(Flow.class, id);

    // check if we are in update mode
    var update = false;
    if (flow != null) {
      if (config.isHandled(flow)
        || config.noUpdates())
        return flow;
      update = true;
    }

    // check the proto object
    var proto = config.store.getFlow(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(flow, wrap))
        return flow;
    }

    // map the data
    if (flow == null) {
      flow = new Flow();
      flow.refId = id;
    }
    wrap.mapTo(flow, config);
    map(proto, flow);

    // insert it
    var dao = new FlowDao(config.db);
    flow = update
      ? dao.update(flow)
      : dao.insert(flow);
    config.putHandled(flow);
    return flow;
  }

  private void map(Proto.Flow proto, Flow flow) {
  }
}
