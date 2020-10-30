package org.openlca.proto.output;

import org.openlca.core.model.Flow;
import org.openlca.proto.Proto;

class Util {

  private Util() {
  }

  static Proto.FlowType flowTypeOf(Flow flow) {
    if (flow == null || flow.flowType == null)
      return Proto.FlowType.UNDEFINED_FLOW_TYPE;
    switch (flow.flowType) {
      case ELEMENTARY_FLOW:
        return Proto.FlowType.ELEMENTARY_FLOW;
      case PRODUCT_FLOW:
        return Proto.FlowType.PRODUCT_FLOW;
      case WASTE_FLOW:
        return Proto.FlowType.WASTE_FLOW;
      default:
        return Proto.FlowType.UNDEFINED_FLOW_TYPE;
    }
  }
}
