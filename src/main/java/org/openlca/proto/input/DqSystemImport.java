package org.openlca.proto.input;

import org.openlca.core.database.DQSystemDao;
import org.openlca.core.model.DQSystem;
import org.openlca.proto.Proto;

public class DqSystemImport {

  private final ProtoImport config;

  public DqSystemImport(ProtoImport config) {
    this.config = config;
  }

  public DQSystem of(String id) {
    if (id == null)
      return null;
    var dqSystem = config.get(DQSystem.class, id);

    // check if we are in update mode
    var update = false;
    if (dqSystem != null) {
      if (config.isHandled(dqSystem)
        || config.noUpdates())
        return dqSystem;
      update = true;
    }

    // check the proto object
    var proto = config.store.getDQSystem(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(dqSystem, wrap))
        return dqSystem;
    }

    // map the data
    if (dqSystem == null) {
      dqSystem = new DQSystem();
      dqSystem.refId = id;
    }
    wrap.mapTo(dqSystem, config);
    map(proto, dqSystem);

    // insert it
    var dao = new DQSystemDao(config.db);
    dqSystem = update
      ? dao.update(dqSystem)
      : dao.insert(dqSystem);
    config.putHandled(dqSystem);
    return dqSystem;
  }

  private void map(Proto.DqSystem proto, DQSystem dqSystem) {
  }
}
