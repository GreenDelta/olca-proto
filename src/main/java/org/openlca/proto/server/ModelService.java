package org.openlca.proto.server;

import javax.persistence.EntityNotFoundException;

import io.grpc.stub.StreamObserver;
import org.openlca.core.database.IDatabase;
import org.openlca.core.model.Flow;
import org.openlca.proto.Proto;
import org.openlca.proto.services.ModelServiceGrpc;
import org.openlca.util.Strings;

class ModelService extends ModelServiceGrpc.ModelServiceImplBase {

  private final IDatabase db;

  ModelService(IDatabase db) {
    this.db = db;
  }

  @Override
  public void getFlow(Proto.Ref req, StreamObserver<Proto.Flow> resp) {
    var flow = db.get(Flow.class, req.getId());
    if (flow == null) {
      resp.onError(new EntityNotFoundException());
    } else {
      var proto = Proto.Flow.newBuilder()
        .setId(flow.refId)
        .setName(Strings.orEmpty(flow.name))
        .setDescription(Strings.orEmpty(flow.description))
        .build();
      resp.onNext(proto);
    }
    resp.onCompleted();
  }
}
