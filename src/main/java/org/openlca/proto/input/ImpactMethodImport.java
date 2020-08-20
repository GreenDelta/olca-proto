package org.openlca.proto.input;

import org.openlca.core.database.ImpactMethodDao;
import org.openlca.core.model.ImpactMethod;
import org.openlca.proto.Proto;

public class ImpactMethodImport {

  private final ProtoImport config;

  public ImpactMethodImport(ProtoImport config) {
    this.config = config;
  }

  public ImpactMethod of(String id) {
    if (id == null)
      return null;
    var impactMethod = config.get(ImpactMethod.class, id);

    // check if we are in update mode
    var update = false;
    if (impactMethod != null) {
      if (config.isHandled(impactMethod)
        || config.noUpdates())
        return impactMethod;
      update = true;
    }

    // check the proto object
    var proto = config.store.getImpactMethod(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(impactMethod, wrap))
        return impactMethod;
    }

    // map the data
    if (impactMethod == null) {
      impactMethod = new ImpactMethod();
      impactMethod.refId = id;
    }
    wrap.mapTo(impactMethod, config);
    map(proto, impactMethod);

    // insert it
    var dao = new ImpactMethodDao(config.db);
    impactMethod = update
      ? dao.update(impactMethod)
      : dao.insert(impactMethod);
    config.putHandled(impactMethod);
    return impactMethod;
  }

  private void map(Proto.ImpactMethod proto, ImpactMethod impactMethod) {
  }
}
