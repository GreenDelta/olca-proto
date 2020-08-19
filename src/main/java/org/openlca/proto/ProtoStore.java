package org.openlca.proto;

public interface ProtoStore {

  Proto.Category getCategory(String id);

  Proto.Actor getActor(String id);

}
