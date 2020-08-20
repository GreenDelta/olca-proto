package org.openlca.proto;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.util.JsonFormat;
import org.slf4j.LoggerFactory;

public class ZipStore implements ProtoStore {

  private final FileSystem zip;

  public static ZipStore open(File zipFile) throws IOException {
    return new ZipStore(zipFile);
  }

  private ZipStore(File zipFile) throws IOException {
    var uriStr = zipFile.toURI().toASCIIString();
    var uri = URI.create("jar:" + uriStr);
    var options = new HashMap<String, String>();
    if (!zipFile.exists()) {
      options.put("create", "true");
    }
    zip = FileSystems.newFileSystem(uri, options);
  }

  @Override
  public void close() throws IOException {
    zip.close();
  }

  @Override
  public Proto.Category getCategory(String id) {
    var proto = readBin("categories", id, Proto.Category.parser());
    if (proto != null)
      return proto;
    var builder = Proto.Category.newBuilder();
    if (readJson("categories", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.Project getProject(String id) {
    var proto = readBin("projects", id, Proto.Project.parser());
    if (proto != null)
      return proto;
    var builder = Proto.Project.newBuilder();
    if (readJson("projects", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.ImpactMethod getImpactMethod(String id) {
    var proto = readBin("lcia_methods", id, Proto.ImpactMethod.parser());
    if (proto != null)
      return proto;
    var builder = Proto.ImpactMethod.newBuilder();
    if (readJson("lcia_methods", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.ImpactCategory getImpactCategory(String id) {
    var proto = readBin("lcia_categories", id, Proto.ImpactCategory.parser());
    if (proto != null)
      return proto;
    var builder = Proto.ImpactCategory.newBuilder();
    if (readJson("lcia_categories", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.ProductSystem getProductSystem(String id) {
    var proto = readBin("product_systems", id, Proto.ProductSystem.parser());
    if (proto != null)
      return proto;
    var builder = Proto.ProductSystem.newBuilder();
    if (readJson("product_systems", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.Process getProcess(String id) {
    var proto = readBin("processes", id, Proto.Process.parser());
    if (proto != null)
      return proto;
    var builder = Proto.Process.newBuilder();
    if (readJson("processes", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.Flow getFlow(String id) {
    var proto = readBin("flows", id, Proto.Flow.parser());
    if (proto != null)
      return proto;
    var builder = Proto.Flow.newBuilder();
    if (readJson("flows", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.FlowProperty getFlowProperty(String id) {
    var proto = readBin("flow_properties", id, Proto.FlowProperty.parser());
    if (proto != null)
      return proto;
    var builder = Proto.FlowProperty.newBuilder();
    if (readJson("flow_properties", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.UnitGroup getUnitGroup(String id) {
    var proto = readBin("unit_groups", id, Proto.UnitGroup.parser());
    if (proto != null)
      return proto;
    var builder = Proto.UnitGroup.newBuilder();
    if (readJson("unit_groups", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.Actor getActor(String id) {
    var proto = readBin("actors", id, Proto.Actor.parser());
    if (proto != null)
      return proto;
    var builder = Proto.Actor.newBuilder();
    if (readJson("actors", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.Source getSource(String id) {
    var proto = readBin("sources", id, Proto.Source.parser());
    if (proto != null)
      return proto;
    var builder = Proto.Source.newBuilder();
    if (readJson("sources", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.Location getLocation(String id) {
    var proto = readBin("locations", id, Proto.Location.parser());
    if (proto != null)
      return proto;
    var builder = Proto.Location.newBuilder();
    if (readJson("locations", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.NwSet getNwSet(String id) {
    var proto = readBin("nw_sets", id, Proto.NwSet.parser());
    if (proto != null)
      return proto;
    var builder = Proto.NwSet.newBuilder();
    if (readJson("nw_sets", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.SocialIndicator getSocialIndicator(String id) {
    var proto = readBin("social_indicators", id, Proto.SocialIndicator.parser());
    if (proto != null)
      return proto;
    var builder = Proto.SocialIndicator.newBuilder();
    if (readJson("social_indicators", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.Currency getCurrency(String id) {
    var proto = readBin("currencies", id, Proto.Currency.parser());
    if (proto != null)
      return proto;
    var builder = Proto.Currency.newBuilder();
    if (readJson("currencies", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.Parameter getParameter(String id) {
    var proto = readBin("parameters", id, Proto.Parameter.parser());
    if (proto != null)
      return proto;
    var builder = Proto.Parameter.newBuilder();
    if (readJson("parameters", id, builder)) {
      return builder.build();
    }
    return null;
  }

  @Override
  public Proto.DqSystem getDQSystem(String id) {
    var proto = readBin("dq_systems", id, Proto.DqSystem.parser());
    if (proto != null)
      return proto;
    var builder = Proto.DqSystem.newBuilder();
    if (readJson("dq_systems", id, builder)) {
      return builder.build();
    }
    return null;
  }

  private <T> T readBin(String folder, String id, Parser<T> binParser) {
    var path = folder + "/" + id + ".bin";
    try {
      var data = get(path);
      return data != null
        ? binParser.parseFrom(data)
        : null;
    } catch (Exception e) {
      var log = LoggerFactory.getLogger(getClass());
      log.error("failed to parse " + path, e);
      return null;
    }
  }

  private boolean readJson(String folder, String id, Message.Builder builder) {
    var path = folder + "/" + id + ".json";
    try {
      var data = get(path);
      if (data == null)
        return false;
      var json = new String(data, StandardCharsets.UTF_8);
      JsonFormat.parser().merge(json, builder);
      return true;
    } catch (Exception e) {
      var log = LoggerFactory.getLogger(getClass());
      log.error("failed to parse " + path, e);
      return false;
    }
  }

  private byte[] get(String path) {
    try {
      Path file = zip.getPath(path);
      if (!Files.exists(file))
        return null;
      return Files.readAllBytes(file);
    } catch (Exception e) {
      var log = LoggerFactory.getLogger(getClass());
      log.error("failed to get file " + path, e);
      return null;
    }
  }
}
