package org.openlca.proto.input;

import org.openlca.core.database.ActorDao;
import org.openlca.core.model.Actor;
import org.openlca.core.model.Version;
import org.openlca.jsonld.Json;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class ActorImport {

  private final ImportConfig config;

  public ActorImport(ImportConfig config) {
    this.config = config;
  }

  public Actor of(String id) {
    if (id == null)
      return null;
    var actor = config.get(Actor.class, id);

    // check if we are in update mode
    var update = false;
    if (actor != null) {
      if (config.isHandled(actor)
        || config.noUpdates())
        return actor;
      update = true;
    }

    // check the proto object
    var proto = config.store.getActor(id);
    if (proto == null)
      return null;
    if (update) {
      if (!config.shouldUpdate(
        actor, proto.getVersion(), proto.getLastChange()))
        return actor;
    }

    // map the data
    if (actor == null) {
      actor = new Actor();
      actor.refId = id;
    }
    map(proto, actor);

    // insert it
    var dao = new ActorDao(config.db);
    actor = update
      ? dao.update(actor)
      : dao.insert(actor);
    config.putHandled(actor);
    return actor;
  }

  private void map(Proto.Actor proto, Actor actor) {

    // root entity fields
    actor.name = proto.getName();
    actor.description = proto.getDescription();
    var version = proto.getVersion();
    if (Strings.notEmpty(version)) {
      actor.version = Version.fromString(version).getValue();
    }
    var lastChange = proto.getLastChange();
    if (Strings.notEmpty(lastChange)) {
      var date = Json.parseDate(lastChange);
      actor.lastChange = date != null
        ? date.getTime()
        : 0;
    }

    // categorized entity fields
    var catID = proto.getCategory().getId();
    if (Strings.notEmpty(catID)) {
      actor.category = new CategoryImport(config).of(catID);
    }
    actor.tags = proto.getTagsList()
      .stream()
      .reduce((tag, tags) -> tags + "," + tag)
      .orElse(null);
    actor.library = Strings.notEmpty(proto.getLibrary())
      ? proto.getLibrary()
      : null;

    // specific fields
  }
}
