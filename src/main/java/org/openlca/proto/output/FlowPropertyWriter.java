package org.openlca.proto.output;

import java.time.Instant;
import java.util.Arrays;

import org.openlca.core.model.FlowProperty;
import org.openlca.core.model.Version;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class FlowPropertyWriter {

  private final WriterConfig config;

  public FlowPropertyWriter(WriterConfig config) {
    this.config = config;
  }

  public Proto.FlowProperty write(FlowProperty property) {
    var proto = Proto.FlowProperty.newBuilder();
    if (property == null)
      return proto.build();

    // root entitiy fields
    proto.setId(Strings.orEmpty(property.refId));
    proto.setName(Strings.orEmpty(property.name));
    proto.setDescription(Strings.orEmpty(property.description));
    proto.setVersion(Version.asString(property.version));
    if (property.lastChange != 0L) {
      var instant = Instant.ofEpochMilli(property.lastChange);
      proto.setLastChange(instant.toString());
    }

    // categorized entity fields
    if (Strings.notEmpty(property.tags)) {
      Arrays.stream(property.tags.split(","))
        .filter(Strings::notEmpty)
        .forEach(proto::addTags);
    }
    if (property.category != null) {
      proto.setCategory(Out.toRef(property.category, config));
    }

    // model specific fields
    // TODO

    return proto.build();
  }
}