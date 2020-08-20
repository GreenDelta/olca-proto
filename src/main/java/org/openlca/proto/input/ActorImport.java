package org.openlca.proto.input;

import org.openlca.core.database.ActorDao;
import org.openlca.core.model.Actor;
import org.openlca.proto.Proto;

public class ActorImport {

  private final ProtoImport config;

  public ActorImport(ProtoImport config) {
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
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(actor, wrap))
        return actor;
    }

    // map the data
    if (actor == null) {
      actor = new Actor();
    }
    wrap.mapTo(actor, config);
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
    actor.address = proto.getAddress();
    actor.city = proto.getCity();
    actor.country = proto.getCountry();
    actor.email = proto.getEmail();
    actor.telefax = proto.getTelefax();
    actor.telephone = proto.getTelephone();
    actor.website = proto.getWebsite();
    actor.zipCode = proto.getZipCode();
  }
}
