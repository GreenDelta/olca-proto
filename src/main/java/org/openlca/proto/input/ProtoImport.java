package org.openlca.proto.input;

import java.util.HashMap;
import java.util.Map;

import org.openlca.core.database.Daos;
import org.openlca.core.database.IDatabase;
import org.openlca.core.model.ModelType;
import org.openlca.core.model.RootEntity;
import org.openlca.core.model.Version;
import org.openlca.jsonld.Json;
import org.openlca.jsonld.input.UpdateMode;
import org.openlca.proto.ProtoStore;
import org.openlca.util.Strings;

public class ProtoImport implements Runnable {

  final ProtoStore store;
  final IDatabase db;
  UpdateMode updateMode = UpdateMode.NEVER;

  /**
   * Contains mapped category IDs. When inserting or updating a
   * category into an openLCA database using the CategoryDao,
   * the ID is calculated from the path. This ID is then maybe
   * different than the ID that is used in the external data
   * store. We hold the mapping `store ID -> db ID` in this map.
   */
  final Map<String, String> mappedCategories = new HashMap<>();

  /**
   * Cache the database IDs of the inserted and updated entities. This
   * is used to avoid updating the same thing again and again and to
   * cache the database IDs for a bit faster retrieval from the database.
   */
  private final Map<Class<?>, Map<String, Long>> handled = new HashMap<>();

  public ProtoImport(ProtoStore store, IDatabase db) {
    this.store = store;
    this.db = db;
  }

  public ProtoImport withUpdateMode(UpdateMode mode) {
    this.updateMode = mode;
    return this;
  }

  boolean noUpdates() {
    return updateMode == null
      || updateMode == UpdateMode.NEVER;
  }

  boolean shouldUpdate(RootEntity e, ProtoWrap wrap) {
    if (e == null)
      return false;
    if (noUpdates())
      return false;
    if (updateMode == UpdateMode.ALWAYS)
      return true;

    // check if
    long v = Strings.notEmpty(wrap.version())
      ? Version.fromString(wrap.version()).getValue()
      : 0;
    if (v < e.version)
      return false;
    var date = Strings.notEmpty(wrap.lastChange())
      ? Json.parseDate(wrap.lastChange())
      : null;
    var time = date != null
      ? date.getTime()
      : 0;
    return v != e.version || time > e.lastChange;
  }

  void putHandled(RootEntity e) {
    if (e == null || e.refId == null)
      return;
    var map = handled.computeIfAbsent(
      e.getClass(), c -> new HashMap<>());
    map.put(e.refId, e.id);
  }

  boolean isHandled(RootEntity e) {
    if (e == null || e.refId == null)
      return false;
    var map = handled.get(e.getClass());
    if (map == null)
      return false;
    var id = map.get(e.refId);
    return id != null;
  }

  /**
   * Get the entity with the given type and ID from the database
   * if it exists. It first checks the cache of imported (handled)
   * data sets if we have a fast ID for that entity. If not, it
   * does not update this cache and searches the database for
   * a matching ref. ID.
   */
  @SuppressWarnings("unchecked")
  <T extends RootEntity> T get(Class<T> type, String refID) {

    // try to use a cached ID first
    var map = handled.get(type);
    var id = map != null
      ? map.get(refID)
      : null;
    if (id != null)
      return Daos.base(db, type).getForId(id);

    // try to load it with the refID
    var dao = Daos.root(db, ModelType.forModelClass(type));
    return (T) dao.getForRefId(refID);
  }

  @Override
  public void run() {
    for (String id : store.getIDs("categories")) {
      new CategoryImport(this).of(id);
    }
    for (String id : store.getIDs("actors")) {
      new ActorImport(this).of(id);
    }
    for (String id : store.getIDs("sources")) {
      new SourceImport(this).of(id);
    }
    for (String id : store.getIDs("locations")) {
      new LocationImport(this).of(id);
    }
    for (String id : store.getIDs("unit_groups")) {
      new UnitGroupImport(this).of(id);
    }
    for (String id : store.getIDs("flow_properties")) {
      new FlowPropertyImport(this).of(id);
    }
    for (String id : store.getIDs("flows")) {
      new FlowImport(this).of(id);
    }
    for (String id : store.getIDs("social_indicators")) {
      new SocialIndicatorImport(this).of(id);
    }
    for (String id : store.getIDs("currencies")) {
      new CurrencyImport(this).of(id);
    }
    for (String id : store.getIDs("parameters")) {
      new ParameterImport(this).of(id);
    }
    for (String id : store.getIDs("dq_systems")) {
      new DqSystemImport(this).of(id);
    }
    for (String id : store.getIDs("processes")) {
      new ProcessImport(this).of(id);
    }
    for (String id : store.getIDs("lcia_categories")) {
      new ImpactCategoryImport(this).of(id);
    }
    for (String id : store.getIDs("lcia_methods")) {
      new ImpactMethodImport(this).of(id);
    }
    for (String id : store.getIDs("product_systems")) {
      new ProductSystemImport(this).of(id);
    }
    for (String id : store.getIDs("projects")) {
      new ProjectImport(this).of(id);
    }
  }
}
