package org.openlca.proto.output;

import java.time.Instant;
import java.util.Arrays;

import org.openlca.core.model.Process;
import org.openlca.core.model.ProcessType;
import org.openlca.core.model.Version;
import org.openlca.proto.Proto;
import org.openlca.util.Strings;

public class ProcessWriter {

  private final WriterConfig config;

  public ProcessWriter(WriterConfig config) {
    this.config = config;
  }

  public Proto.Process write(Process process) {
    var proto = Proto.Process.newBuilder();
    if (process == null)
      return proto.build();

    // root entity fields
    proto.setType("Process");
    proto.setId(Strings.orEmpty(process.refId));
    proto.setName(Strings.orEmpty(process.name));
    proto.setDescription(Strings.orEmpty(process.description));
    proto.setVersion(Version.asString(process.version));
    if (process.lastChange != 0L) {
      var instant = Instant.ofEpochMilli(process.lastChange);
      proto.setLastChange(instant.toString());
    }

    // categorized entity fields
    if (Strings.notEmpty(process.tags)) {
      Arrays.stream(process.tags.split(","))
        .filter(Strings::notEmpty)
        .forEach(proto::addTags);
    }
    if (process.category != null) {
      proto.setCategory(Refs.toRef(process.category, config));
    }

    // model specific fields
    proto.setProcessType(processType(process));
    proto.setDefaultAllocationMethod(allocationType(process));
    proto.setInfrastructureProcess(process.infrastructureProcess);

    if (process.location != null) {
    }

    return proto.build();
  }

  private Proto.ProcessType processType(Process p) {
    if (p == null || p.processType == null)
      return Proto.ProcessType.UNDEFINED_PROCESS_TYPE;
    return p.processType == ProcessType.LCI_RESULT
      ? Proto.ProcessType.LCI_RESULT
      : Proto.ProcessType.UNIT_PROCESS;
  }

  private Proto.AllocationType allocationType(Process p) {
    if (p == null || p.defaultAllocationMethod == null)
      return Proto.AllocationType.UNDEFINED_ALLOCATION_TYPE;
    switch (p.defaultAllocationMethod) {
      case CAUSAL:
        return Proto.AllocationType.CAUSAL_ALLOCATION;
      case ECONOMIC:
        return Proto.AllocationType.ECONOMIC_ALLOCATION;
      case PHYSICAL:
        return Proto.AllocationType.PHYSICAL_ALLOCATION;
      default:
        return Proto.AllocationType.UNDEFINED_ALLOCATION_TYPE;
    }
  }

}
