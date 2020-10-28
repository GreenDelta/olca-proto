package org.openlca.proto.output;

import java.time.Instant;
import java.util.Arrays;

import org.openlca.core.model.Flow;
import org.openlca.core.model.Version;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class FlowWriter {

  private final WriterConfig config;

  public FlowWriter(WriterConfig config) {
    this.config = config;
  }

  public Proto.Flow write(Flow flow) {
    var proto = Proto.Flow.newBuilder();
    if (flow == null)
      return proto.build();

    // root entitiy fields
    proto.setType("Flow");
    proto.setId(Strings.orEmpty(flow.refId));
    proto.setName(Strings.orEmpty(flow.name));
    proto.setDescription(Strings.orEmpty(flow.description));
    proto.setVersion(Version.asString(flow.version));
    if (flow.lastChange != 0L) {
      var instant = Instant.ofEpochMilli(flow.lastChange);
      proto.setLastChange(instant.toString());
    }

    // categorized entity fields
    if (Strings.notEmpty(flow.tags)) {
      Arrays.stream(flow.tags.split(","))
        .filter(Strings::notEmpty)
        .forEach(proto::addTags);
    }
    if (flow.category != null) {
      proto.setCategory(Refs.toRef(flow.category, config));
    }

    // model specific fields
    // TODO

    return proto.build();
  }
}
