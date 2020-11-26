package org.openlca.proto.server;

import com.google.protobuf.ProtocolStringList;
import io.grpc.stub.StreamObserver;
import org.openlca.core.database.IDatabase;
import org.openlca.core.database.MappingFileDao;
import org.openlca.core.model.MappingFile;
import org.openlca.io.maps.FlowMap;
import org.openlca.io.maps.FlowMapEntry;
import org.openlca.io.maps.FlowRef;
import org.openlca.proto.Messages;
import org.openlca.proto.Proto;
import org.openlca.proto.input.In;
import org.openlca.proto.services.FlowMapServiceGrpc;
import org.openlca.proto.services.Services;
import org.openlca.util.Strings;

class FlowMapService extends FlowMapServiceGrpc.FlowMapServiceImplBase {

  private final IDatabase db;

  FlowMapService(IDatabase db) {
    this.db = db;
  }

  @Override
  public void getAll(Services.Empty req, StreamObserver<Services.FlowMapInfo> resp) {
    new MappingFileDao(db).getNames()
      .stream()
      .sorted(Strings::compare)
      .map(name -> Services.FlowMapInfo
        .newBuilder()
        .setName(name)
        .build())
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void get(Services.FlowMapInfo req,
                  StreamObserver<Services.FlowMapStatus> resp) {
    var mapping = getOrError(req, resp);

  }

  @Override
  public void delete(Services.FlowMapInfo req,
                     StreamObserver<Services.Status> resp) {
    var mapping = getOrError(req, resp);
    if (mapping == null)
      return;
    try {
      new MappingFileDao(db).delete(mapping);
      Response.ok(resp);
    } catch (Exception e) {
      Response.error(resp, "Failed to delete mapping with name='"
        + req.getName() + "' from database");
    }
  }

  private MappingFile getOrError(
    Services.FlowMapInfo req, StreamObserver<Services.Status> resp) {

    if (Strings.nullOrEmpty(req.getName())) {
      Response.error(resp, "No name of the flow map" +
        " that should be deleted was given.");
      return null;
    }

    // find the existing mapping with this name
    var dao = new MappingFileDao(db);
    var name = req.getName().trim();
    var existing = dao.getNames()
      .stream()
      .filter(name::equalsIgnoreCase)
      .findAny()
      .orElse(null);
    if (existing == null) {
      Response.error(resp, "A flow mapping with name='"
        + name + "' does not exist");
      return null;
    }

    // load the mapping
    var mapping = dao.getForName(existing);
    if (mapping == null) {
      Response.error(resp, "Failed to load mapping with name='"
        + name + "' from database");
      return null;
    }
    return mapping;
  }

  @Override
  public void put(Proto.FlowMap proto, StreamObserver<Services.Status> resp) {
    var model = toModel(proto);
    if (Strings.nullOrEmpty(model.name)) {
      Response.error(resp, "A name of the flow map is required");
      return;
    }

    var dao = new MappingFileDao(db);
    var name = model.name.trim();

    // check if we should update an existing map
    var existing = dao.getNames()
      .stream()
      .filter(name::equalsIgnoreCase)
      .findAny()
      .orElse(null);
    if (existing != null) {
      var mapping = dao.getForName(existing);
      if (mapping != null) {
        try {
          model.updateContentOf(mapping);
          dao.update(mapping);
          Response.ok(resp);
        } catch (Exception e) {
          Response.error(resp, "Failed to update existing" +
            " flow map " + existing + ": " + e.getMessage());
        }
        return;
      }
    }

    // save it as new flow map
    var mapping = model.toMappingFile();
    try {
      dao.insert(mapping);
      Response.ok(resp);
    } catch (Exception e) {
      Response.error(resp, "Failed to save mapping "
        + model.name + ": " + e.getMessage());
    }
  }

  private FlowMap toModel(Proto.FlowMap proto) {
    if (proto == null)
      return FlowMap.empty();
    var flowMap = new FlowMap();
    flowMap.name = proto.getName();
    flowMap.description = proto.getDescription();
    flowMap.refId = proto.getId();
    for (var protoEntry : proto.getMappingsList()) {
      var entry = new FlowMapEntry();
      entry.factor = protoEntry.getConversionFactor();
      entry.sourceFlow = toModelRef(protoEntry.getFrom());
      entry.targetFlow = toModelRef(protoEntry.getTo());
      flowMap.entries.add(entry);
    }
    return flowMap;
  }

  private FlowRef toModelRef(Proto.FlowMapRef protoRef) {
    var flowRef = new FlowRef();
    if (Messages.isEmpty(protoRef))
      return flowRef;

    // flow information
    flowRef.flow = In.descriptorOf(protoRef.getFlow());
    flowRef.flowCategory = categoryPathOf(
      protoRef.getFlow().getCategoryPathList());
    flowRef.flowLocation = Strings.orNull(
      protoRef.getFlow().getLocation());

    // flow property
    var property = protoRef.getFlowProperty();
    if (Messages.isNotEmpty(property)) {
      flowRef.property = In.descriptorOf(property);
    }

    // unit
    var unit = protoRef.getUnit();
    if (Messages.isNotEmpty(unit)) {
      flowRef.unit = In.descriptorOf(unit);
    }

    // provider
    var provider = protoRef.getProvider();
    if (Messages.isNotEmpty(provider)) {
      flowRef.provider = In.descriptorOf(provider);
      flowRef.providerCategory = categoryPathOf(
        provider.getCategoryPathList());
      flowRef.providerLocation = Strings.orNull(
        provider.getLocation());
    }

    return flowRef;
  }

  private String categoryPathOf(ProtocolStringList categories) {
    if (categories == null || categories.isEmpty())
      return null;
    return categories.stream()
      .reduce(null, (path, elem) ->
        Strings.nullOrEmpty(path)
          ? elem
          : path + "/" + elem);
  }

}













