package org.openlca.proto;

import java.util.UUID;

import com.google.protobuf.util.JsonFormat;

public class Main {

  public static void main(String[] args) throws Exception {
    var p = Proto.Ref.newBuilder()
        .setType("Process")
        .setId(UUID.randomUUID().toString())
        .setName("steel")
        .setDescription("some steel process")
        .addCategoryPath("materials")
        .addCategoryPath("metals")
        .build();
    var json = JsonFormat.printer().print(p);
    var clone = Proto.Ref.newBuilder();
    JsonFormat.parser().merge(json, clone);
    json = JsonFormat.printer().print(clone.build());
    System.out.println(json);
  }
}
