package org.openlca.proto;

import java.util.Arrays;
import java.util.Objects;

import org.openlca.core.model.ModelType;

public class Gen {

  public static void main(String[] args) {
    Arrays.stream(ModelType.values())
      .map(ModelType::getModelClass)
      .filter(Objects::nonNull)
      .map(Class::getSimpleName)
      .sorted()
      .forEach(System.out::println);
  }

}
