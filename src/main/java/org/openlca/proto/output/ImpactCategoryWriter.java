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
    proto.setReferenceUnitName(
      Strings.orEmpty(impact.referenceUnit));
    writeFactors(impact, proto);

    return proto.build();
  }

  private void writeFactors(
    ImpactCategory impact, Proto.ImpactCategory.Builder proto) {
    for (var factor : impact.impactFactors) {
      var protoFac = Proto.ImpactFactor.newBuilder();
      if (factor.flow != null) {
        protoFac.setFlow(Refs.toFlowRef(factor.flow, config));
      }
// ? proto.protoFac.setFlowPropertyFactor(flow.flowPropertyFactor)
      protoFac.setFormula(Strings.orEmpty(factor.formula));
      if (factor.location != null) {
        protoFac.setLocation(Refs.toRef(factor.location, config));
      }
// ? proto.protoFac.setUncertainty(flow.uncertainty)
      if (factor.unit != null) {
        protoFac.setUnit(Refs.toRef(factor.unit, config));
      }
      protoFac.setValue(factor.value);
      proto.addImpactFactors(protoFac.build());
    }
  }
}
