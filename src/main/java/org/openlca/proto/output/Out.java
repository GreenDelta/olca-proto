package org.openlca.proto.output;

import java.time.Instant;

import org.openlca.core.model.CategorizedEntity;
import org.openlca.core.model.Flow;
import org.openlca.core.model.ImpactCategory;
import org.openlca.core.model.RootEntity;
import org.openlca.core.model.Version;
import org.openlca.core.model.descriptors.Descriptor;
import org.openlca.core.model.descriptors.FlowDescriptor;
import org.openlca.core.model.descriptors.ProcessDescriptor;
import org.openlca.proto.Proto;
import org.openlca.util.Categories;
import org.openlca.util.Strings;

public final class Out {

  private Out() {
  }

  public static Proto.Ref toRef(RootEntity e) {
    var proto = Proto.Ref.newBuilder();
    if (e == null)
      return proto.build();
    proto.setId(Strings.orEmpty(e.refId));
    proto.setName(Strings.orEmpty(e.name));
    proto.setDescription(Strings.orEmpty(e.description));
    proto.setVersion(Version.asString(e.version));
    proto.setType(e.getClass().getSimpleName());
    proto.setLastChange(toDateTime(e.lastChange));

    // add a the category path
    if (e instanceof CategorizedEntity) {
      var ce = (CategorizedEntity) e;
      if (ce.category != null) {
        var path = Categories.path(ce.category);
        if (!path.isEmpty()) {
          proto.addAllCategoryPath(path);
        }
      }
    }
    return proto.build();
  }

  public static Proto.Ref toRef(Descriptor d) {
    var proto = Proto.Ref.newBuilder();
    if (d == null)
      return proto.build();
    proto.setId(Strings.orEmpty(d.refId));
    proto.setName(Strings.orEmpty(d.name));
    proto.setDescription(Strings.orEmpty(d.description));
    proto.setVersion(Version.asString(d.version));
    proto.setLastChange(toDateTime(d.lastChange));

    // entity type
    if (d.type != null) {
      var type = d.type.getModelClass();
      if (type != null) {
        proto.setType(type.getSimpleName());
      }
    }

    return proto.build();
  }

  public static Proto.FlowRef toFlowRef(FlowDescriptor d) {
    var proto = Proto.FlowRef.newBuilder();
    if (d == null)
      return proto.build();
    proto.setId(Strings.orEmpty(d.refId));
    proto.setName(Strings.orEmpty(d.name));
    proto.setDescription(Strings.orEmpty(d.description));
    proto.setVersion(Version.asString(d.version));
    proto.setType("Flow");
    proto.setLastChange(toDateTime(d.lastChange));
    return proto.build();
  }

  private static String toDateTime(long time) {
    return time == 0
      ? ""
      : Instant.ofEpochMilli(time).toString();
  }

  public static Proto.ProcessRef toProcessRef(ProcessDescriptor d) {
    var proto = Proto.ProcessRef.newBuilder();
    if (d == null)
      return proto.build();
    proto.setId(Strings.orEmpty(d.refId));
    proto.setName(Strings.orEmpty(d.name));
    proto.setDescription(Strings.orEmpty(d.description));
    proto.setVersion(Version.asString(d.version));
    proto.setType("Process");
    proto.setLastChange(toDateTime(d.lastChange));
    return proto.build();
  }

  static Proto.Ref toRef(RootEntity e, WriterConfig config) {
    var proto = toRef(e);
    if (e == null)
      return proto;

    // push the dependency
    if (config != null && config.dependencies != null) {
      config.dependencies.push(e);
    }
    return proto;
  }

  static Proto.FlowRef toFlowRef(Flow flow, WriterConfig config) {

    var proto = Proto.FlowRef.newBuilder();
    if (flow == null)
      return proto.build();

    // push the dependency
    if (config != null && config.dependencies != null) {
      config.dependencies.push(flow);
    }

    proto.setId(Strings.orEmpty(flow.refId));
    proto.setName(Strings.orEmpty(flow.name));
    proto.setDescription(Strings.orEmpty(flow.description));
    proto.setVersion(Version.asString(flow.version));
    proto.setType("Flow");
    proto.setLastChange(toDateTime(flow.lastChange));

    // add a the category path
    if (flow.category != null) {
      var path = Categories.path(flow.category);
      if (!path.isEmpty()) {
        proto.addAllCategoryPath(path);
      }
    }

    // FlowRef specific fields
    if (flow.location != null) {
      proto.setLocation(Strings.orEmpty(flow.location.code));
    }
    var refUnit = flow.getReferenceUnit();
    if (refUnit != null) {
      proto.setRefUnit(Strings.orEmpty(refUnit.name));
    }
    proto.setFlowType(Util.flowTypeOf(flow));

    return proto.build();
  }

  static Proto.ImpactCategoryRef toImpactRef(
    ImpactCategory impact, WriterConfig config) {

    var proto = Proto.ImpactCategoryRef.newBuilder();
    if (impact == null)
      return proto.build();

    // push the dependency
    if (config != null && config.dependencies != null) {
      config.dependencies.push(impact);
    }

    proto.setId(Strings.orEmpty(impact.refId));
    proto.setName(Strings.orEmpty(impact.name));
    proto.setDescription(Strings.orEmpty(impact.description));
    proto.setVersion(Version.asString(impact.version));
    proto.setType("ImpactCategory");
    proto.setLastChange(toDateTime(impact.lastChange));

    // add a the category path
    if (impact.category != null) {
      var path = Categories.path(impact.category);
      if (!path.isEmpty()) {
        proto.addAllCategoryPath(path);
      }
    }

    // ImpactCategoryRef specific fields
    proto.setRefUnit(Strings.orEmpty(impact.referenceUnit));

    return proto.build();
  }
}
