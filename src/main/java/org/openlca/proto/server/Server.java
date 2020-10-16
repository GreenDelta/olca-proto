package org.openlca.proto.server;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.grpc.ServerBuilder;
import org.openlca.core.database.IDatabase;
import org.openlca.core.database.derby.DerbyDatabase;

public class Server {

  private final io.grpc.Server server;

  public Server(IDatabase db, int port) {
    this.server = ServerBuilder.forPort(port)
      .addService(new DataService(db))
      .build();
  }

  public void start() {
    try {
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
    var dbDir = "C:/Users/Win10/openLCA-data-1.4/databases/ei2";
    var db = new DerbyDatabase(new File(dbDir));
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
