package org.openlca.proto.output;

import java.time.Instant;

import org.openlca.core.model.Category;
import org.openlca.core.model.Version;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class CategoryWriter {

  private final WriterConfig config;

  public CategoryWriter(WriterConfig config) {
    this.config = config;
  }

  public Proto.Category write(Category c) {
    var proto = Proto.Category.newBuilder();
    if (c == null)
      return proto.build();

    proto.setId(Strings.orEmpty(c.refId));
    proto.setName(Strings.orEmpty(c.name));
    proto.setDescription(Strings.orEmpty(c.description));
    proto.setVersion(Version.asString(c.version));
    if (c.lastChange != 0L) {
      var instant = Instant.ofEpochMilli(c.lastChange);
      proto.setLastChange(instant.toString());
    }
    proto.setModelType(type(c));

    if (c.category != null) {
      proto.setCategory(Out.toRef(c.category, config));
    }

    return proto.build();
  }

  private Proto.ModelType type(Category c) {
    if (c == null || c.modelType == null)
      return Proto.ModelType.UNDEFINED_MODEL_TYPE;

    switch (c.modelType) {
      case ACTOR:
        return Proto.ModelType.ACTOR;
      case CATEGORY:
        return Proto.ModelType.CATEGORY;
      case CURRENCY:
        return Proto.ModelType.CURRENCY;
      case DQ_SYSTEM:
        return Proto.ModelType.DQ_SYSTEM;
      case FLOW:
        return Proto.ModelType.FLOW;
      case FLOW_PROPERTY:
        return Proto.ModelType.FLOW_PROPERTY;
      case IMPACT_CATEGORY:
        return Proto.ModelType.IMPACT_CATEGORY;
      case IMPACT_METHOD:
        return Proto.ModelType.IMPACT_METHOD;
      case LOCATION:
        return Proto.ModelType.LOCATION;
      case NW_SET:
        return Proto.ModelType.NW_SET;
      case PARAMETER:
        return Proto.ModelType.PARAMETER;
      case PROCESS:
        return Proto.ModelType.PROCESS;
      case PRODUCT_SYSTEM:
        return Proto.ModelType.PRODUCT_SYSTEM;
      case PROJECT:
        return Proto.ModelType.PROJECT;
      case SOCIAL_INDICATOR:
        return Proto.ModelType.SOCIAL_INDICATOR;
      case SOURCE:
        return Proto.ModelType.SOURCE;
      case UNIT:
        return Proto.ModelType.UNIT;
      case UNIT_GROUP:
        return Proto.ModelType.UNIT_GROUP;
      default:
        return Proto.ModelType.UNDEFINED_MODEL_TYPE;
    }
  }

}
