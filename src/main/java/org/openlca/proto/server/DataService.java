package org.openlca.proto.server;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

import io.grpc.stub.StreamObserver;
import org.openlca.core.database.ActorDao;
import org.openlca.core.database.CategoryDao;
import org.openlca.core.database.CurrencyDao;
import org.openlca.core.database.DQSystemDao;
import org.openlca.core.database.FlowDao;
import org.openlca.core.database.FlowPropertyDao;
import org.openlca.core.database.IDatabase;
import org.openlca.core.database.ImpactCategoryDao;
import org.openlca.core.database.ImpactMethodDao;
import org.openlca.core.database.LocationDao;
import org.openlca.core.database.ParameterDao;
import org.openlca.core.database.ProcessDao;
import org.openlca.core.database.ProductSystemDao;
import org.openlca.core.database.ProjectDao;
import org.openlca.core.database.SocialIndicatorDao;
import org.openlca.core.database.SourceDao;
import org.openlca.core.database.UnitGroupDao;
import org.openlca.core.model.Actor;
import org.openlca.core.model.CategorizedEntity;
import org.openlca.core.model.Flow;
import org.openlca.core.model.ModelType;
import org.openlca.core.model.RootEntity;
import org.openlca.jsonld.input.UpdateMode;
import org.openlca.proto.MemStore;
import org.openlca.proto.Proto;
import org.openlca.proto.input.ProtoImport;
import org.openlca.proto.output.ActorWriter;
import org.openlca.proto.output.CategoryWriter;
import org.openlca.proto.output.CurrencyWriter;
import org.openlca.proto.output.DQSystemWriter;
import org.openlca.proto.output.FlowPropertyWriter;
import org.openlca.proto.output.FlowWriter;
import org.openlca.proto.output.ImpactCategoryWriter;
import org.openlca.proto.output.ImpactMethodWriter;
import org.openlca.proto.output.LocationWriter;
import org.openlca.proto.output.ParameterWriter;
import org.openlca.proto.output.ProcessWriter;
import org.openlca.proto.output.ProductSystemWriter;
import org.openlca.proto.output.ProjectWriter;
import org.openlca.proto.output.Refs;
import org.openlca.proto.output.SocialIndicatorWriter;
import org.openlca.proto.output.SourceWriter;
import org.openlca.proto.output.UnitGroupWriter;
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
  public void delete(Proto.Ref req, StreamObserver<Services.Status> resp) {
    var type = Arrays.stream(ModelType.values())
      .map(ModelType::getModelClass)
      .filter(Objects::nonNull)
      .filter(clazz -> clazz.getSimpleName().equals(req.getType()))
      .findAny()
      .orElse(null);

    Consumer<String> error = msg -> {
      var status = Services.Status.newBuilder()
        .setOk(false)
        .setError(msg)
        .build();
      resp.onNext(status);
      resp.onCompleted();
    };

    if (type == null) {
      error.accept("Unknown model type: " + req.getType());
      return;
    }

    if (!CategorizedEntity.class.isAssignableFrom(type)) {
      error.accept(req.getType() + " is not a standalone entity");
      return;
    }

    var entity = db.get(type, req.getId());
    if (entity == null) {
      error.accept(
        "A " + req.getType() + " with id="
        + req.getId() + " does not exist");
      return;
    }

    db.delete(entity);
    var status = Services.Status.newBuilder()
      .setOk(true)
      .build();
    resp.onNext(status);
    resp.onCompleted();
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
  public void actor(Proto.Ref req, StreamObserver<Services.ActorStatus> resp) {
    var status = Services.ActorStatus.newBuilder();
    var actor = db.get(Actor.class, req.getId());
    if (actor == null) {
      status.setError("No Actor with id='" + req.getId() + "' exists");
    } else {
      var proto = new ActorWriter(WriterConfig.of(db))
        .write(actor);
      status.setActor(proto);
    }
    resp.onNext(status.build());
    resp.onCompleted();
  }

  @Override
  public void categories(Services.Empty _req, StreamObserver<Proto.Category> resp) {
    var writer = new CategoryWriter(WriterConfig.of(db));
    var dao = new CategoryDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void currencies(Services.Empty _req, StreamObserver<Proto.Currency> resp) {
    var writer = new CurrencyWriter(WriterConfig.of(db));
    var dao = new CurrencyDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void dqSystems(Services.Empty _req, StreamObserver<Proto.DqSystem> resp) {
    var writer = new DQSystemWriter(WriterConfig.of(db));
    var dao = new DQSystemDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void flows(Services.Empty _req, StreamObserver<Proto.Flow> resp) {
    var writer = new FlowWriter(WriterConfig.of(db));
    var dao = new FlowDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void flow(Proto.Ref req, StreamObserver<Services.FlowStatus> resp) {
    var status = Services.FlowStatus.newBuilder();
    Flow flow = null;

    var id = req.getId();
    if (Strings.notEmpty(id)) {
      // try to find it by ID
      flow = db.get(Flow.class, id);
      if (flow == null) {
        status.setError("A Flow with id='" + id + "' does not exist");
      }

    } else {
      // try to find it by name
      var name = req.getName();
      if (Strings.nullOrEmpty(name)) {
        status.setError("An id or name is required");
      } else {
        flow = db.forName(Flow.class, name);
        if (flow == null) {
          status.setError("A Flow with name='" + name + "' does not exist");
        }
      }
    }

    if (flow != null) {
      var proto = new FlowWriter(WriterConfig.of(db))
        .write(flow);
      status.setFlow(proto);
      status.setOk(true);
    }

    resp.onNext(status.build());
    resp.onCompleted();
  }

  @Override
  public void putFlow(Proto.Flow req, StreamObserver<Services.RefStatus> resp) {
    var store = new MemStore();
    store.putFlow(req);
    new ProtoImport(store, db)
      .withUpdateMode(UpdateMode.IF_NEWER)
      .run();
    resp.onNext(importStatusOf(Flow.class, req.getId()));
    resp.onCompleted();
  }

  @Override
  public void flowProperties(Services.Empty _req, StreamObserver<Proto.FlowProperty> resp) {
    var writer = new FlowPropertyWriter(WriterConfig.of(db));
    var dao = new FlowPropertyDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void impactCategories(Services.Empty _req, StreamObserver<Proto.ImpactCategory> resp) {
    var writer = new ImpactCategoryWriter(WriterConfig.of(db));
    var dao = new ImpactCategoryDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void impactMethods(Services.Empty _req, StreamObserver<Proto.ImpactMethod> resp) {
    var writer = new ImpactMethodWriter(WriterConfig.of(db));
    var dao = new ImpactMethodDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void locations(Services.Empty _req, StreamObserver<Proto.Location> resp) {
    var writer = new LocationWriter(WriterConfig.of(db));
    var dao = new LocationDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void parameters(Services.Empty _req, StreamObserver<Proto.Parameter> resp) {
    var writer = new ParameterWriter(WriterConfig.of(db));
    var dao = new ParameterDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void processes(Services.Empty _req, StreamObserver<Proto.Process> resp) {
    var writer = new ProcessWriter(WriterConfig.of(db));
    var dao = new ProcessDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void productSystems(Services.Empty _req, StreamObserver<Proto.ProductSystem> resp) {
    var writer = new ProductSystemWriter(WriterConfig.of(db));
    var dao = new ProductSystemDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void projects(Services.Empty _req, StreamObserver<Proto.Project> resp) {
    var writer = new ProjectWriter(WriterConfig.of(db));
    var dao = new ProjectDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void socialIndicators(Services.Empty _req, StreamObserver<Proto.SocialIndicator> resp) {
    var writer = new SocialIndicatorWriter(WriterConfig.of(db));
    var dao = new SocialIndicatorDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void sources(Services.Empty _req, StreamObserver<Proto.Source> resp) {
    var writer = new SourceWriter(WriterConfig.of(db));
    var dao = new SourceDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  @Override
  public void unitGroups(Services.Empty _req, StreamObserver<Proto.UnitGroup> resp) {
    var writer = new UnitGroupWriter(WriterConfig.of(db));
    var dao = new UnitGroupDao(db);
    dao.getDescriptors()
      .stream()
      .map(d -> dao.getForId(d.id))
      .map(writer::write)
      .forEach(resp::onNext);
    resp.onCompleted();
  }

  private Services.RefStatus importStatusOf(
    Class<? extends RootEntity> type, String id) {
    var e = db.get(type, id);
    if (e == null) {
      return Services.RefStatus.newBuilder()
        .setOk(false)
        .setError("Import of " + type.getSimpleName() + " " + id + " failed")
        .build();
    }
    return Services.RefStatus.newBuilder()
      .setOk(true)
      .setRef(Refs.toRef(e))
      .build();
  }
}
