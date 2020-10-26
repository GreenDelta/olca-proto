package org.openlca.proto.output;

import java.time.Instant;

import org.openlca.core.model.CategorizedEntity;
import org.openlca.core.model.RootEntity;
import org.openlca.core.model.Version;
import org.openlca.proto.Proto;
import org.openlca.util.Categories;
import org.openlca.util.Strings;

class Out {

  static Proto.Ref toRef(RootEntity e, WriterConfig config) {
    var proto = Proto.Ref.newBuilder();
    if (e == null)
      return proto.build();
    if (config != null && config.dependencies != null) {
      config.dependencies.push(e);
    }

    proto.setId(Strings.orEmpty(e.refId));
    proto.setName(Strings.orEmpty(e.name));
    proto.setDescription(Strings.orEmpty(e.description));
    proto.setVersion(Version.asString(e.version));
    proto.setType(e.getClass().getSimpleName());
    if (e.lastChange != 0L) {
      var instant = Instant.ofEpochMilli(e.lastChange);
      proto.setLastChange(instant.toString());
    }

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
}
