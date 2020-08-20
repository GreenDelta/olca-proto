package org.openlca.proto;

public interface ProtoStore {

  Proto.Category getCategory(String id);

  Proto.Actor getActor(String id);

  Proto.Source getSource(String id);

  Proto.Currency getCurrency(String id);

  Proto.UnitGroup getUnitGroup(String id);

  Proto.FlowProperty getFlowProperty(String id);

  Proto.DqSystem getDQSystem(String id);

  Proto.Flow getFlow(String id);

  Proto.ImpactMethod getImpactMethod(String id);

  Proto.Location getLocation(String id);

  Proto.Parameter getParameter(String id);

  Proto.ImpactCategory getImpactCategory(String id);

  Proto.Process getProcess(String id);

  Proto.Project getProject(String id);

  Proto.SocialIndicator getSocialIndicator(String id);

}
