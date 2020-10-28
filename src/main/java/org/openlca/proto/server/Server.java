package org.openlca.proto.server;

import java.util.concurrent.TimeUnit;

import io.grpc.ServerBuilder;
import org.openlca.core.database.IDatabase;
import org.openlca.core.database.derby.DerbyDatabase;
import org.slf4j.LoggerFactory;

public class Server {

  private final int port;
  private final io.grpc.Server server;

  public Server(IDatabase db, int port) {
    this.port = port;
    this.server = ServerBuilder.forPort(port)
      .addService(new DataService(db))
      .build();
  }

  public void start() {
    try {
      var log = LoggerFactory.getLogger(getClass());
      log.info("start server: localhost:{}", port);
      server.start();
      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        System.out.println("shut down server");
        try {
          Server.this.stop();
        } catch (Exception e) {
          e.printStackTrace(System.err);
        }
        System.out.println("server shut down");
      }));
      log.info("server waiting for connections");
      server.awaitTermination();
    } catch (Exception e) {
      throw new RuntimeException("failed to start server", e);
    }
  }

  public void stop() {
    if (server == null)
      return;
    try {
      server.shutdown().awaitTermination(5, TimeUnit.MINUTES);
    } catch (Exception e) {
      throw new RuntimeException("failed to stop server", e);
    }
  }

  public static void main(String[] args) {

    var db = DerbyDatabase.fromDataDir("proto");
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      try {
        System.out.println("close database...");
        db.close();
        System.out.println("database closed.");
      } catch (Exception e) {
        System.out.println("failed to close database");
      }
    }));
    new Server(db, 8080).start();
  }
}
