package org.openlca.proto.input;

import java.util.Objects;

import org.openlca.core.database.ImpactMethodDao;
import org.openlca.core.model.ImpactMethod;
import org.openlca.core.model.NwFactor;
import org.openlca.core.model.NwSet;
import org.openlca.proto.Proto;

public class ImpactMethodImport {

  private final ProtoImport config;

  public ImpactMethodImport(ProtoImport config) {
    this.config = config;
  }

  public ImpactMethod of(String id) {
    if (id == null)
      return null;
    var method = config.get(ImpactMethod.class, id);

    // check if we are in update mode
    var update = false;
    if (method != null) {
      if (config.isHandled(method)
        || config.noUpdates())
        return method;
      update = true;
    }

    // check the proto object
    var proto = config.store.getImpactMethod(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (!config.shouldUpdate(method, wrap))
        return method;
    }

    // map the data
    if (method == null) {
      method = new ImpactMethod();
      method.refId = id;
    }
    wrap.mapTo(method, config);
    map(proto, method);

    // insert it
    var dao = new ImpactMethodDao(config.db);
    method = update
      ? dao.update(method)
      : dao.insert(method);
    config.putHandled(method);
    return method;
  }

  private void map(Proto.ImpactMethod proto, ImpactMethod method) {

    for (var protoImp : proto.getImpactCategoriesList()) {
      var impactID = protoImp.getId();
      var impact = new ImpactCategoryImport(config).of(impactID);
      if (impact != null) {
        method.impactCategories.add(impact);
      }
    }

    for (var protoNw : proto.getNwSetsList()) {
      var nw = new NwSet();
      method.nwSets.add(nw);
      nw.refId = protoNw.getId();
      nw.name = protoNw.getName();
      nw.description = protoNw.getDescription();
      nw.weightedScoreUnit = protoNw.getWeightedScoreUnit();
      protoNw.getFactorsList()
        .stream()
        .map(protoFactor -> nwFactor(protoFactor, method))
        .forEach(nw.factors::add);
    }
  }

  private NwFactor nwFactor(Proto.NwFactor proto, ImpactMethod method) {
    var f = new NwFactor();
    var impactID = proto.getImpactCategory().getId();
    f.impactCategory = method.impactCategories.stream()
      .filter(i -> Objects.equals(i.refId, impactID))
      .findAny()
      .orElse(null);
    f.normalisationFactor = proto.getNormalisationFactor() == 0
      ? null
      : proto.getNormalisationFactor();
    f.weightingFactor = proto.getWeightingFactor() == 0
      ? null
      : proto.getWeightingFactor();
    return f;
  }
}
