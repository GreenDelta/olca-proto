package org.openlca.proto.input;

import org.openlca.core.database.SocialIndicatorDao;
import org.openlca.core.model.SocialIndicator;
import org.openlca.proto.Proto;

public class SocialIndicatorImport {

  private final ProtoImport config;

  public SocialIndicatorImport(ProtoImport config) {
    this.config = config;
  }

  public SocialIndicator of(String id) {
    if (id == null)
      return null;
    var socialIndicator = config.get(SocialIndicator.class, id);

    // check if we are in update mode
    var update = false;
    if (socialIndicator != null) {
      if (config.isHandled(socialIndicator)
        || config.noUpdates())
        return socialIndicator;
      update = true;
    }

    // check the proto object
    var proto = config.store.getSocialIndicator(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(socialIndicator, wrap))
        return socialIndicator;
    }

    // map the data
    if (socialIndicator == null) {
      socialIndicator = new SocialIndicator();
      socialIndicator.refId = id;
    }
    wrap.mapTo(socialIndicator, config);
    map(proto, socialIndicator);

    // insert it
    var dao = new SocialIndicatorDao(config.db);
    socialIndicator = update
      ? dao.update(socialIndicator)
      : dao.insert(socialIndicator);
    config.putHandled(socialIndicator);
    return socialIndicator;
  }

  private void map(Proto.SocialIndicator proto, SocialIndicator socialIndicator) {
  }
}
