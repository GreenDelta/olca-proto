package org.openlca.proto.output;

import java.time.Instant;
import java.util.Arrays;

import org.openlca.core.model.Parameter;
import org.openlca.core.model.Version;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class ParameterWriter {

  private final WriterConfig config;

  public ParameterWriter(WriterConfig config) {
    this.config = config;
  }

  public Proto.Parameter write(Parameter parameter) {
    var proto = Proto.Parameter.newBuilder();
    if (parameter == null)
      return proto.build();

    // root entity fields
    proto.setType("Parameter");
    proto.setId(Strings.orEmpty(parameter.refId));
    proto.setName(Strings.orEmpty(parameter.name));
    proto.setDescription(Strings.orEmpty(parameter.description));
    proto.setVersion(Version.asString(parameter.version));
    if (parameter.lastChange != 0L) {
      var instant = Instant.ofEpochMilli(parameter.lastChange);
      proto.setLastChange(instant.toString());
    }

    // categorized entity fields
    if (Strings.notEmpty(parameter.tags)) {
      Arrays.stream(parameter.tags.split(","))
        .filter(Strings::notEmpty)
        .forEach(proto::addTags);
    }
    if (parameter.category != null) {
      proto.setCategory(Refs.toRef(parameter.category, config));
    }

    // model specific fields
    // TODO

    return proto.build();
  }
}
