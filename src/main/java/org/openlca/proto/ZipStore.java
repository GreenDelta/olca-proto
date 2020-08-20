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

  private FileSystem zip;

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
  public Proto.Actor getActor(String id) {
    return null;
  }

  @Override
  public Proto.Source getSource(String id) {
    return null;
  }

  @Override
  public Proto.Currency getCurrency(String id) {
    return null;
  }

  @Override
  public Proto.UnitGroup getUnitGroup(String id) {
    return null;
  }

  @Override
  public Proto.FlowProperty getFlowProperty(String id) {
    return null;
  }

  @Override
  public Proto.DqSystem getDQSystem(String id) {
    return null;
  }

  @Override
  public Proto.Flow getFlow(String id) {
    return null;
  }

  @Override
  public Proto.ImpactMethod getImpactMethod(String id) {
    return null;
  }

  @Override
  public Proto.Location getLocation(String id) {
    return null;
  }

  @Override
  public Proto.Parameter getParameter(String id) {
    return null;
  }

  @Override
  public Proto.ImpactCategory getImpactCategory(String id) {
    return null;
  }

  @Override
  public Proto.Process getProcess(String id) {
    return null;
  }

  @Override
  public Proto.Project getProject(String id) {
    return null;
  }

  @Override
  public Proto.SocialIndicator getSocialIndicator(String id) {
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
