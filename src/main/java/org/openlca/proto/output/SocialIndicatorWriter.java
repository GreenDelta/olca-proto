package org.openlca.proto.output;

import java.time.Instant;
import java.util.Arrays;

import org.openlca.core.model.SocialIndicator;
import org.openlca.core.model.Version;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class SocialIndicatorWriter {

  private final WriterConfig config;

  public SocialIndicatorWriter(WriterConfig config) {
    this.config = config;
  }

  public Proto.SocialIndicator write(SocialIndicator indicator) {
    var proto = Proto.SocialIndicator.newBuilder();
    if (indicator == null)
      return proto.build();

    // root entity fields
    proto.setType("SocialIndicator");
    proto.setId(Strings.orEmpty(indicator.refId));
    proto.setName(Strings.orEmpty(indicator.name));
    proto.setDescription(Strings.orEmpty(indicator.description));
    proto.setVersion(Version.asString(indicator.version));
    if (indicator.lastChange != 0L) {
      var instant = Instant.ofEpochMilli(indicator.lastChange);
      proto.setLastChange(instant.toString());
    }

    // categorized entity fields
    if (Strings.notEmpty(indicator.tags)) {
      Arrays.stream(indicator.tags.split(","))
        .filter(Strings::notEmpty)
        .forEach(proto::addTags);
    }
    if (indicator.category != null) {
      proto.setCategory(Refs.toRef(indicator.category, config));
    }

    // model specific fields
    // TODO

    return proto.build();
  }
}
