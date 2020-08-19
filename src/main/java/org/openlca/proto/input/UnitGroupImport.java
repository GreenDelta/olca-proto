package org.openlca.proto.input;

import org.openlca.core.database.UnitGroupDao;
import org.openlca.core.model.Unit;
import org.openlca.core.model.UnitGroup;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class UnitGroupImport {

  private final ImportConfig config;

  public UnitGroupImport(ImportConfig config) {
    this.config = config;
  }

  public UnitGroup of(String id) {
    if (id == null)
      return null;
    var group = config.get(UnitGroup.class, id);

    // check if we are in update mode
    var update = false;
    if (group != null) {
      if (config.isHandled(group)
        || config.noUpdates())
        return group;
      update = true;
    }

    // check the proto object
    var proto = config.store.getUnitGroup(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(group, wrap))
        return group;
    }

    // map the data
    if (group == null) {
      group = new UnitGroup();
      group.refId = id;
    }
    wrap.mapTo(group, config);
    map(proto, group);

    // insert it
    var dao = new UnitGroupDao(config.db);
    group = update
      ? dao.update(group)
      : dao.insert(group);
    config.putHandled(group);

    // set a possible default flow property after
    // the unit group was saved to avoid endless
    // import cycles
    var propID = proto.getDefaultFlowProperty().getId();
    if (Strings.notEmpty(propID)) {
      group.defaultFlowProperty = new FlowPropertyImport(config)
        .of(propID);
      group = dao.update(group);
    }

    return group;
  }

  private void map(Proto.UnitGroup proto, UnitGroup group) {
    for (var u : proto.getUnitsList()) {
      var unit = new Unit();
      unit.refId = u.getId();
      unit.name = u.getName();
      unit.description = u.getDescription();
      unit.conversionFactor = u.getConversionFactor();
      unit.synonyms = u.getSynonymsList().stream()
        .reduce((syn, acc) -> syn + ";" + acc)
        .orElse(null);
      if (u.getReferenceUnit()) {
        group.referenceUnit = unit;
      }
      group.units.add(unit);
    }
  }
}

