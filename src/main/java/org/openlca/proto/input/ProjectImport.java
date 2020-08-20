package org.openlca.proto.input;

import org.openlca.core.database.ProjectDao;
import org.openlca.core.model.Project;
import org.openlca.proto.Proto;

public class ProjectImport {

  private final ImportConfig config;

  public ProjectImport(ImportConfig config) {
    this.config = config;
  }

  public Project of(String id) {
    if (id == null)
      return null;
    var project = config.get(Project.class, id);

    // check if we are in update mode
    var update = false;
    if (project != null) {
      if (config.isHandled(project)
        || config.noUpdates())
        return project;
      update = true;
    }

    // check the proto object
    var proto = config.store.getProject(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(project, wrap))
        return project;
    }

    // map the data
    if (project == null) {
      project = new Project();
      project.refId = id;
    }
    wrap.mapTo(project, config);
    map(proto, project);

    // insert it
    var dao = new ProjectDao(config.db);
    project = update
      ? dao.update(project)
      : dao.insert(project);
    config.putHandled(project);
    return project;
  }

  private void map(Proto.Project proto, Project project) {
  }
}
