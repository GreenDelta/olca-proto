package org.openlca.proto.input;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.openlca.core.database.FlowDao;
import org.openlca.core.database.ProcessDao;
import org.openlca.core.database.ProductSystemDao;
import org.openlca.core.model.FlowType;
import org.openlca.core.model.ProductSystem;
import org.openlca.core.model.descriptors.Descriptor;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class ProductSystemImport {

  private final ProtoImport imp;

  public ProductSystemImport(ProtoImport imp) {
    this.imp = imp;
  }

  public ProductSystem of(String id) {
    if (id == null)
      return null;
    var sys = imp.get(ProductSystem.class, id);

    // check if we are in update mode
    var update = false;
    if (sys != null) {
      update = imp.shouldUpdate(sys);
      if(!update) {
        return sys;
      }
    }

    // check the proto object
    var proto = imp.store.getProductSystem(id);
    if (proto == null)
      return null;
    var wrap = ProtoWrap.of(proto);
    if (update) {
      if (imp.skipUpdate(sys, wrap))
        return sys;
    }

    // map the data
    if (sys == null) {
      sys = new ProductSystem();
    }
    wrap.mapTo(sys, imp);
    map(proto, sys);

    // insert it
    var dao = new ProductSystemDao(imp.db);
    sys = update
      ? dao.update(sys)
      : dao.insert(sys);
    imp.putHandled(sys);
    return sys;
  }

  private void map(Proto.ProductSystem proto, ProductSystem sys) {

    // sync processes
    var processes = syncProcesses(proto);
    sys.processes.clear();
    processes.values().forEach(d -> sys.processes.add(d.id));

    // collecting the flows
    var flows = new FlowDao(imp.db)
      .getDescriptors()
      .stream()
      .filter(f -> f.flowType != FlowType.ELEMENTARY_FLOW)
      .collect(Collectors.toMap(
        d -> d.refId,
        d -> d
      ));


    for (var protoLink : proto.getProcessLinksList()) {

    }

  }

  private Map<String, Descriptor> syncProcesses(Proto.ProductSystem proto) {
    var map = new HashMap<String, Descriptor>();

    // handles a process (or product system) reference
    BiConsumer<String, Boolean> handleRef = (refID, checkForSystem)  -> {
      if (Strings.nullOrEmpty(refID))
        return;

      var process = new ProcessImport(imp).of(refID);
      if (process != null) {
        map.put(refID, Descriptor.of(process));
        return;
      }

      // providers of links can also be product systems
      if (checkForSystem) {
        var sys = new ProductSystemImport(imp).of(refID);
        if (sys != null) {
          map.put(refID, Descriptor.of(sys));
        }
      }
    };

    handleRef.accept(proto.getReferenceProcess().getId(), false);
    for (var ref : proto.getProcessesList()) {
      handleRef.accept(ref.getId(), true);
    }
    for (var link : proto.getProcessLinksList()) {
      handleRef.accept(link.getProvider().getId(), true);
      handleRef.accept(link.getProcess().getId(), false);
    }
    return map;
  }
}
