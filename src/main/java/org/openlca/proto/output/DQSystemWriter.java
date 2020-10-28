package org.openlca.proto.output;

import java.time.Instant;
import java.util.Arrays;

import org.openlca.core.model.DQSystem;
import org.openlca.core.model.Version;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class DQSystemWriter {

  private final WriterConfig config;

  public DQSystemWriter(WriterConfig config) {
    this.config = config;
  }

  public Proto.DqSystem write(DQSystem dqSystem) {
    var proto = Proto.DqSystem.newBuilder();
    if (dqSystem == null)
      return proto.build();

    // root entitiy fields
    proto.setId(Strings.orEmpty(dqSystem.refId));
    proto.setName(Strings.orEmpty(dqSystem.name));
    proto.setDescription(Strings.orEmpty(dqSystem.description));
    proto.setVersion(Version.asString(dqSystem.version));
    if (dqSystem.lastChange != 0L) {
      var instant = Instant.ofEpochMilli(dqSystem.lastChange);
      proto.setLastChange(instant.toString());
    }

    // categorized entity fields
    if (Strings.notEmpty(dqSystem.tags)) {
      Arrays.stream(dqSystem.tags.split(","))
        .filter(Strings::notEmpty)
        .forEach(proto::addTags);
    }
    if (dqSystem.category != null) {
      proto.setCategory(Refs.toRef(dqSystem.category, config));
    }

    // model specific fields
    // TODO

    return proto.build();
  }
}
