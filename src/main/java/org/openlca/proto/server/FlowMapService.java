package org.openlca.proto.server;

import java.util.function.Consumer;

import com.google.protobuf.ProtocolStringList;
import io.grpc.stub.StreamObserver;
import org.openlca.core.database.IDatabase;
import org.openlca.core.database.MappingFileDao;
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
  public void put(Proto.FlowMap proto, StreamObserver<Services.Status> resp) {
    Consumer<String> onError = error -> {
      var status = Services.Status.newBuilder()
        .setOk(false)
        .setError(error)
        .build();
      resp.onNext(status);
      resp.onCompleted();
    };

    Runnable onOk = () -> {
      var status = Services.Status.newBuilder()
        .setOk(true)
        .build();
      resp.onNext(status);
      resp.onCompleted();
    };

    var model = toModel(proto);
    if (Strings.nullOrEmpty(model.name)) {
      onError.accept("A name of the flow map is required");
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
          onOk.run();
        } catch (Exception e) {
          onError.accept("Failed to update existing flow map "
            + existing + ": " + e.getMessage());
        }
        return;
      }
    }

    // save it as new flow map
    var mapping = model.toMappingFile();
    try {
      dao.insert(mapping);
      onOk.run();
    } catch (Exception e) {
      onError.accept("Failed to save mapping "
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













