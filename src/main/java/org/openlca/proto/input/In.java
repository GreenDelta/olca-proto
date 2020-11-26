package org.openlca.proto.input;

import org.openlca.core.model.AllocationMethod;
import org.openlca.core.model.FlowType;
import org.openlca.core.model.Uncertainty;
import org.openlca.proto.Proto;

/**
 * Utility methods for converting incoming proto-objects to openLCA model
 * objects.
 */
public final class In {

  private In() {
  }

  static Uncertainty uncertainty(Proto.Uncertainty proto) {
    if (proto == null || proto.getDistributionType() == null)
      return null;
    switch (proto.getDistributionType()) {
      case LOG_NORMAL_DISTRIBUTION:
        return Uncertainty.logNormal(
          proto.getGeomMean(), proto.getGeomSd());
      case NORMAL_DISTRIBUTION:
        return Uncertainty.normal(
          proto.getMean(), proto.getSd());
      case TRIANGLE_DISTRIBUTION:
        return Uncertainty.triangle(
          proto.getMinimum(), proto.getMode(), proto.getMaximum());
      case UNIFORM_DISTRIBUTION:
        return Uncertainty.uniform(
          proto.getMinimum(), proto.getMaximum());
      default:
        return null;
    }
  }

  static AllocationMethod allocationMethod(Proto.AllocationType proto) {
    if (proto == null)
      return null;
    switch (proto) {
      case CAUSAL_ALLOCATION:
        return AllocationMethod.CAUSAL;
      case ECONOMIC_ALLOCATION:
        return AllocationMethod.ECONOMIC;
      case PHYSICAL_ALLOCATION:
        return AllocationMethod.PHYSICAL;
      case USE_DEFAULT_ALLOCATION:
        return AllocationMethod.USE_DEFAULT;
      default:
        return AllocationMethod.NONE;
    }
  }

  public static FlowType flowTypeOf(Proto.FlowType proto) {
    if (proto == null)
      return null;
    switch (proto) {
      case ELEMENTARY_FLOW:
        return FlowType.ELEMENTARY_FLOW;
      case PRODUCT_FLOW:
        return FlowType.PRODUCT_FLOW;
      case WASTE_FLOW:
        return FlowType.WASTE_FLOW;
      default:
        return null;
    }
  }

  public static 

}
