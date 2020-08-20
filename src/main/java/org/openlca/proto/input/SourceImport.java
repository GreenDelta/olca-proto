package org.openlca.proto.input;

import org.openlca.core.database.SourceDao;
import org.openlca.core.model.Source;
import org.openlca.proto.Proto;

public class SourceImport {

  private final ProtoImport config;

  public SourceImport(ProtoImport config) {
    this.config = config;
  }

  public Source of(String id) {
    if (id == null)
      return null;
    var source = config.get(Source.class, id);

    // check if we are in update mode
    var update = false;
    if (source != null) {
      if (config.isHandled(source)
        || config.noUpdates())
        return source;
      update = true;
    }

    // check the proto object
    var proto = config.store.getSource(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(source, wrap))
        return source;
    }

    // map the data
    if (source == null) {
      source = new Source();
    }
    wrap.mapTo(source, config);
    map(proto, source);

    // insert it
    var dao = new SourceDao(config.db);
    source = update
      ? dao.update(source)
      : dao.insert(source);
    config.putHandled(source);
    return source;
  }

  private void map(Proto.Source proto, Source source) {
    source.url = proto.getUrl();
    source.externalFile = proto.getExternalFile();
    source.textReference = proto.getTextReference();
    source.year = (short) proto.getYear();
  }
}

