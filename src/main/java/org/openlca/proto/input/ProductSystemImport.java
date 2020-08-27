package org.openlca.proto.input;

import org.openlca.core.database.ProductSystemDao;
import org.openlca.core.model.ProductSystem;
import org.openlca.proto.Proto;

public class ProductSystemImport {

  private final ProtoImport imp;

  public ProductSystemImport(ProtoImport imp) {
    this.imp = imp;
  }

  public ProductSystem of(String id) {
    if (id == null)
      return null;
    var sys = imp.get(ProductSystem.class, id);

    // check if we are in update mode
    var update = false;
    if (sys != null) {
      update = imp.shouldUpdate(sys);
      if(!update) {
        return sys;
      }
    }

    // check the proto object
    var proto = imp.store.getProductSystem(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (imp.skipUpdate(sys, wrap))
        return sys;
    }

    // map the data
    if (sys == null) {
      sys = new ProductSystem();
    }
    wrap.mapTo(sys, imp);
    map(proto, sys);

    // insert it
    var dao = new ProductSystemDao(imp.db);
    sys = update
      ? dao.update(sys)
      : dao.insert(sys);
    imp.putHandled(sys);
    return sys;
  }

  private void map(Proto.ProductSystem proto, ProductSystem sys) {
  }
}
