package org.openlca.proto.server;

import javax.persistence.EntityNotFoundException;

import io.grpc.stub.StreamObserver;
import org.openlca.core.database.IDatabase;
import org.openlca.core.model.Flow;
import org.openlca.proto.Proto;
import org.openlca.proto.services.DataServiceGrpc;
import org.openlca.util.Strings;

class DataService extends DataServiceGrpc.DataServiceImplBase {

  private final IDatabase db;

  DataService(IDatabase db) {
    this.db = db;
  }

  @Override
  public void flow(Proto.Ref req, StreamObserver<Proto.Flow> resp) {
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
