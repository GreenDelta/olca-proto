package org.openlca.proto.input;

import org.openlca.core.database.ProductSystemDao;
import org.openlca.core.model.ProductSystem;
import org.openlca.proto.Proto;

public class ProductSystemImport {

  private final ProtoImport config;

  public ProductSystemImport(ProtoImport config) {
    this.config = config;
  }

  public ProductSystem of(String id) {
    if (id == null)
      return null;
    var sys = config.get(ProductSystem.class, id);

    // check if we are in update mode
    var update = false;
    if (sys != null) {
      if (config.isHandled(sys)
        || config.noUpdates())
        return sys;
      update = true;
    }

    // check the proto object
    var proto = config.store.getProductSystem(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(sys, wrap))
        return sys;
    }

    // map the data
    if (sys == null) {
      sys = new ProductSystem();
    }
    wrap.mapTo(sys, config);
    map(proto, sys);

    // insert it
    var dao = new ProductSystemDao(config.db);
    sys = update
      ? dao.update(sys)
      : dao.insert(sys);
    config.putHandled(sys);
    return sys;
  }

  private void map(Proto.ProductSystem proto, ProductSystem sys) {
  }
}
