package org.openlca.proto.input;

import org.openlca.core.database.CategoryDao;
import org.openlca.core.model.Category;
import org.openlca.core.model.Version;
import org.openlca.jsonld.Json;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class CategoryImport {

  private final ImportConfig config;

  public CategoryImport(ImportConfig config) {
    this.config = config;
  }

  public Category of(String id) {
    if (id == null)
      return null;
    var dao = new CategoryDao(config.db);
    var mappedID = config.mappedCategories.get(id);
    var category = mappedID != null
      ? dao.getForRefId(mappedID)
      : dao.getForRefId(id);

    if (category == null) {
      var proto = config.store.getCategory(id);
      if (proto == null)
        return null;
      category = new Category();
      category.refId = id;
      map(proto, category);
    }

    return null;
  }

  private void map(Proto.Category proto, Category category) {

    // root entity fields
    category.name = proto.getName();
    category.description = proto.getDescription();
    var version = proto.getVersion();
    if (Strings.notEmpty(version)) {
      category.version = Version.fromString(version).getValue();
    }
    var lastChange = proto.getLastChange();
    if (Strings.notEmpty(lastChange)) {
      var date = Json.parseDate(lastChange);
      category.lastChange = date != null
        ? date.getTime()
        : 0;
    }

    // categorized entity fields
    var catID = proto.getCategory().getId();
    if (Strings.notEmpty(catID)) {
      category.category = of(catID);
    }
    category.tags = proto.getTagsList()
      .stream()
      .reduce((tag, tags) -> tags + "," + tag)
      .orElse(null);

    //

    var id = proto.getId();
    // var mappedID = config.mappedCategories.get()

  }

}
