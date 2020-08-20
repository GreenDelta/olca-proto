package org.openlca.proto.input;

import org.openlca.core.database.LocationDao;
import org.openlca.core.model.Location;
import org.openlca.proto.Proto;

public class LocationImport {

  private final ImportConfig config;

  public LocationImport(ImportConfig config) {
    this.config = config;
  }

  public Location of(String id) {
    if (id == null)
      return null;
    var location = config.get(Location.class, id);

    // check if we are in update mode
    var update = false;
    if (location != null) {
      if (config.isHandled(location)
        || config.noUpdates())
        return location;
      update = true;
    }

    // check the proto object
    var proto = config.store.getLocation(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(location, wrap))
        return location;
    }

    // map the data
    if (location == null) {
      location = new Location();
      location.refId = id;
    }
    wrap.mapTo(location, config);
    map(proto, location);

    // insert it
    var dao = new LocationDao(config.db);
    location = update
      ? dao.update(location)
      : dao.insert(location);
    config.putHandled(location);
    return location;
  }

  private void map(Proto.Location proto, Location location) {
  }
}
