package org.openlca.proto.input;

import org.openlca.core.database.ProcessDao;
import org.openlca.core.model.Process;
import org.openlca.proto.Proto;

public class ProcessImport {

  private final ProtoImport config;

  public ProcessImport(ProtoImport config) {
    this.config = config;
  }

  public Process of(String id) {
    if (id == null)
      return null;
    var process = config.get(Process.class, id);

    // check if we are in update mode
    var update = false;
    if (process != null) {
      if (config.isHandled(process)
        || config.noUpdates())
        return process;
      update = true;
    }

    // check the proto object
    var proto = config.store.getProcess(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(process, wrap))
        return process;
    }

    // map the data
    if (process == null) {
      process = new Process();
      process.refId = id;
    }
    wrap.mapTo(process, config);
    map(proto, process);

    // insert it
    var dao = new ProcessDao(config.db);
    process = update
      ? dao.update(process)
      : dao.insert(process);
    config.putHandled(process);
    return process;
  }

  private void map(Proto.Process proto, Process process) {
  }
}
