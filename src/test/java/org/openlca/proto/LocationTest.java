package org.openlca.proto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import com.google.protobuf.util.JsonFormat;
import org.junit.Test;

public class LocationTest {

  @Test
  public void testReadJsonGeometry() throws Exception {
    try (var stream = getClass().getResourceAsStream("location.json");
         var reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
         var buffer = new BufferedReader(reader)) {
      var builder = Proto.Location.newBuilder();
      JsonFormat.parser()
        .ignoringUnknownFields()
        .merge(buffer, builder);
      var proto = builder.build();


    }
  }
}
