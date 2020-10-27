package org.openlca.proto.output;

import java.time.Instant;
import java.util.Arrays;

import org.openlca.core.model.ImpactMethod;
import org.openlca.core.model.Version;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class ImpactMethodWriter {

  private final WriterConfig config;

  public ImpactMethodWriter(WriterConfig config) {
    this.config = config;
  }

  public Proto.ImpactMethod write(ImpactMethod method) {
    var proto = Proto.ImpactMethod.newBuilder();
    if (method == null)
      return proto.build();

    // root entitiy fields
    proto.setId(Strings.orEmpty(method.refId));
    proto.setName(Strings.orEmpty(method.name));
    proto.setDescription(Strings.orEmpty(method.description));
    proto.setVersion(Version.asString(method.version));
    if (method.lastChange != 0L) {
      var instant = Instant.ofEpochMilli(method.lastChange);
      proto.setLastChange(instant.toString());
    }

    // categorized entity fields
    if (Strings.notEmpty(method.tags)) {
      Arrays.stream(method.tags.split(","))
        .filter(Strings::notEmpty)
        .forEach(proto::addTags);
    }
    if (method.category != null) {
      proto.setCategory(Out.toRef(method.category, config));
    }

    // model specific fields
    // TODO

    return proto.build();
  }
}