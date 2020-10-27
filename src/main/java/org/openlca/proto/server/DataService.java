package org.openlca.proto.server;

import javax.persistence.EntityNotFoundException;

import io.grpc.stub.StreamObserver;
import org.openlca.core.database.ActorDao;
import org.openlca.core.database.IDatabase;
import org.openlca.core.model.Actor;
import org.openlca.core.model.Flow;
import org.openlca.proto.Proto;
import org.openlca.proto.output.ActorWriter;
import org.openlca.proto.output.WriterConfig;
import org.openlca.proto.services.DataServiceGrpc;
import org.openlca.proto.services.Services;
import org.openlca.util.Strings;

class DataService extends DataServiceGrpc.DataServiceImplBase {

  private final IDatabase db;

  DataService(IDatabase db) {
    this.db = db;
  }

  @Override
  public void actors(Services.Empty req, StreamObserver<Proto.Actor> resp) {
    var writer = new ActorWriter(WriterConfig.of(db));
    var dao = new ActorDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void actor(Proto.Ref req, StreamObserver<Proto.Actor> resp) {
    var actor = db.get(Actor.class, req.getId());
    if (actor == null) {
      resp.onError(new EntityNotFoundException());
    } else {
      var proto = new ActorWriter(WriterConfig.of(db))
        .write(actor);
      resp.onNext(proto);
    }
    resp.onCompleted();
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
