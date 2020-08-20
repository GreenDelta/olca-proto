package org.openlca.proto.input;

import org.openlca.core.database.ParameterDao;
import org.openlca.core.model.Parameter;
import org.openlca.proto.Proto;

public class ParameterImport {

  private final ProtoImport config;

  public ParameterImport(ProtoImport config) {
    this.config = config;
  }

  public Parameter of(String id) {
    if (id == null)
      return null;
    var parameter = config.get(Parameter.class, id);

    // check if we are in update mode
    var update = false;
    if (parameter != null) {
      if (config.isHandled(parameter)
        || config.noUpdates())
        return parameter;
      update = true;
    }

    // check the proto object
    var proto = config.store.getParameter(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(parameter, wrap))
        return parameter;
    }

    // map the data
    if (parameter == null) {
      parameter = new Parameter();
      parameter.refId = id;
    }
    wrap.mapTo(parameter, config);
    map(proto, parameter);

    // insert it
    var dao = new ParameterDao(config.db);
    parameter = update
      ? dao.update(parameter)
      : dao.insert(parameter);
    config.putHandled(parameter);
    return parameter;
  }

  private void map(Proto.Parameter proto, Parameter parameter) {
  }
}
