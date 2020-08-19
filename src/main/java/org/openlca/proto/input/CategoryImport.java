package org.openlca.proto.input;

import org.openlca.core.database.CategoryDao;
import org.openlca.core.model.Category;
import org.openlca.core.model.ModelType;
import org.openlca.core.model.Version;
import org.openlca.jsonld.Enums;
import org.openlca.jsonld.Json;
import org.openlca.proto.Proto;
import org.openlca.util.Categories;
import org.openlca.util.Strings;

public class CategoryImport {

  private final ImportConfig config;

  public CategoryImport(ImportConfig config) {
    this.config = config;
  }

  public Category of(String id) {
    if (id == null)
      return null;
    var mappedID = config.mappedCategories.get(id);
    var category = mappedID != null
      ? config.get(Category.class, mappedID)
      : config.get(Category.class, id);

    var update = false;
    if (category != null) {
      if (config.isHandled(category)
        || config.noUpdates())
        return category;
      update = true;
    }

    var proto = config.store.getCategory(id);
    if (proto == null)
      return null;
    if (update) {
      if (!config.shouldUpdate(
        category, proto.getVersion(), proto.getLastChange()))
        return category;
    }

    if (category == null) {
      category = new Category();
      category.refId = id;
    }
    map(proto, category);

    // update a possible parent
    var dao = new CategoryDao(config.db);
    var parent = category.category;
    if (parent == null) {
      category = update
        ? dao.update(category)
        : dao.insert(category);
    } else {
      var refID = Categories.createRefId(category);
      category.refId = refID;
      var existing = parent.childCategories.stream()
        .filter(child -> Strings.nullOrEqual(child.refId, refID))
        .findAny()
        .orElse(null);
      if (existing == null) {
        parent.childCategories.add(category);
      } else {
        existing.name = category.name;
        existing.description = category.description;
        existing.version = category.version;
        existing.lastChange = category.lastChange;
        existing.tags = category.tags;
        existing.library = category.library;
        existing.modelType = category.modelType;
      }
      parent = dao.update(parent);
      category = parent.childCategories.stream()
        .filter(child -> Strings.nullOrEqual(child.refId, refID))
        .findAny()
        .orElse(null);
      if (category == null)
        return null;
    }

    if (!Strings.nullOrEqual(id, category.refId)) {
      config.mappedCategories.put(id, category.refId);
    }
    config.putHandled(category);
    return category;
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
    category.library = Strings.notEmpty(proto.getLibrary())
      ? proto.getLibrary()
      : null;

    // specific fields
    category.modelType = Enums.getValue(
      proto.getModelType().name(), ModelType.class);
  }

}
