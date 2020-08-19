package org.openlca.proto;

public interface ProtoStore {

  Proto.Category getCategory(String id);

  Proto.Actor getActor(String id);

  Proto.Source getSource(String id);

  Proto.Currency getCurrency(String id);

}
