package org.openlca.proto.output;

import java.time.Instant;
import java.util.Arrays;

import org.openlca.core.model.Process;
import org.openlca.core.model.Version;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class ProcessWriter {

  private final WriterConfig config;

  public ProcessWriter(WriterConfig config) {
    this.config = config;
  }

  public Proto.Process write(Process process) {
    var proto = Proto.Process.newBuilder();
    if (process == null)
      return proto.build();

    // root entitiy fields
    proto.setId(Strings.orEmpty(process.refId));
    proto.setName(Strings.orEmpty(process.name));
    proto.setDescription(Strings.orEmpty(process.description));
    proto.setVersion(Version.asString(process.version));
    if (process.lastChange != 0L) {
      var instant = Instant.ofEpochMilli(process.lastChange);
      proto.setLastChange(instant.toString());
    }

    // categorized entity fields
    if (Strings.notEmpty(process.tags)) {
      Arrays.stream(process.tags.split(","))
        .filter(Strings::notEmpty)
        .forEach(proto::addTags);
    }
    if (process.category != null) {
      proto.setCategory(Out.toRef(process.category, config));
    }

    // model specific fields
    // TODO

    return proto.build();
  }
}