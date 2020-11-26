package org.openlca.proto.server;

import com.google.protobuf.Message;
import io.grpc.stub.StreamObserver;
import org.openlca.core.database.IDatabase;
import org.openlca.core.database.MappingFileDao;
import org.openlca.core.model.descriptors.FlowDescriptor;
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
  public void put(Proto.FlowMap flowMap, StreamObserver<Services.Status> resp) {


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

      // source flow
      entry.sourceFlow = new FlowRef();
      entry.sourceFlow.flow = new FlowDescriptor();
      var protoFrom = protoEntry.getFrom();

      flowMap.entries.add(entry);



      //protoEntry.getFrom()
    }

    return flowMap;
  }

  private FlowRef toModelRef(Proto.FlowMapRef protoRef) {
    var flowRef = new FlowRef();
    if (protoRef == null)
      return flowRef;


    flowRef.flow = In.descriptorOf(protoRef.getFlow());
    var categories = protoRef.getFlow().getCategoryPathList();
    if (!categories.isEmpty()) {
      flowRef.flowCategory = categories.stream()
        .reduce("", (path, elem) ->
          Strings.nullOrEmpty(path)
            ? elem
            : path + "/" + elem);
    }

    flowRef.flowLocation = Strings.orNull(
      protoRef.getFlow().getLocation());

    var prop = protoRef.getFlowProperty();
    if (Messages.isNotEmpty(prop)) {
      //flddowRef.property = protoRef.getFlowProperty().is
    }


    return flowRef;
  }

}













