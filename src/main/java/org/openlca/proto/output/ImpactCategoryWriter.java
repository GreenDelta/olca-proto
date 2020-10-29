package org.openlca.proto.output;

import java.time.Instant;
import java.util.Arrays;

import org.openlca.core.model.ImpactCategory;
import org.openlca.core.model.Version;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class ImpactCategoryWriter {

  private final WriterConfig config;

  public ImpactCategoryWriter(WriterConfig config) {
    this.config = config;
  }

  public Proto.ImpactCategory write(ImpactCategory impact) {
    var proto = Proto.ImpactCategory.newBuilder();
    if (impact == null)
      return proto.build();

    // root entity fields
    proto.setType("ImpactCategory");
    proto.setId(Strings.orEmpty(impact.refId));
    proto.setName(Strings.orEmpty(impact.name));
    proto.setDescription(Strings.orEmpty(impact.description));
    proto.setVersion(Version.asString(impact.version));
    if (impact.lastChange != 0L) {
      var instant = Instant.ofEpochMilli(impact.lastChange);
      proto.setLastChange(instant.toString());
    }

    // categorized entity fields
    if (Strings.notEmpty(impact.tags)) {
      Arrays.stream(impact.tags.split(","))
        .filter(Strings::notEmpty)
        .forEach(proto::addTags);
    }
    if (impact.category != null) {
      proto.setCategory(Refs.toRef(impact.category, config));
    }

    // model specific fields
    // TODO

    return proto.build();
  }
}
