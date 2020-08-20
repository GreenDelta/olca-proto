package org.openlca.proto.input;

import org.openlca.core.database.ImpactCategoryDao;
import org.openlca.core.model.ImpactCategory;
import org.openlca.proto.Proto;

public class ImpactCategoryImport {

  private final ProtoImport config;

  public ImpactCategoryImport(ProtoImport config) {
    this.config = config;
  }

  public ImpactCategory of(String id) {
    if (id == null)
      return null;
    var impactCategory = config.get(ImpactCategory.class, id);

    // check if we are in update mode
    var update = false;
    if (impactCategory != null) {
      if (config.isHandled(impactCategory)
        || config.noUpdates())
        return impactCategory;
      update = true;
    }

    // check the proto object
    var proto = config.store.getImpactCategory(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(impactCategory, wrap))
        return impactCategory;
    }

    // map the data
    if (impactCategory == null) {
      impactCategory = new ImpactCategory();
      impactCategory.refId = id;
    }
    wrap.mapTo(impactCategory, config);
    map(proto, impactCategory);

    // insert it
    var dao = new ImpactCategoryDao(config.db);
    impactCategory = update
      ? dao.update(impactCategory)
      : dao.insert(impactCategory);
    config.putHandled(impactCategory);
    return impactCategory;
  }

  private void map(Proto.ImpactCategory proto, ImpactCategory impactCategory) {
  }
}
