package org.openlca.proto.output;

import java.time.Instant;

import org.openlca.core.model.CategorizedEntity;
import org.openlca.core.model.Category;
import org.openlca.core.model.RootEntity;
import org.openlca.core.model.Version;
import org.openlca.proto.Proto;
import org.openlca.util.Categories;
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


    if (c.category != null) {
      proto.setCategory(Out.toRef(c.category, config));
    }

    return proto.build();
  }



}
