package org.openlca.proto;

import java.io.File;

import org.openlca.core.database.derby.DerbyDatabase;
import org.openlca.proto.input.ProtoImport;

public class ImportExample {

  public static void main(String[] args) {
    var zipPath = "C:/Users/Win10/Downloads/USLCI.zip";
    var dbPath = "C:/Users/Win10/openLCA-data-1.4/databases/uslci_proto";
    try (var store = ZipStore.open(new File(zipPath));
        var db = new DerbyDatabase(new File(dbPath))) {
        var imp = new ProtoImport(store, db);
        imp.run();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
