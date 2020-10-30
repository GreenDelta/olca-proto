package org.openlca.proto.output;

import org.openlca.core.model.Flow;
import org.openlca.core.model.Uncertainty;
import org.openlca.core.model.UncertaintyType;
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

  static Proto.Uncertainty uncertainty(Uncertainty u) {
    var proto = Proto.Uncertainty.newBuilder();
    if (u == null || u.distributionType == null)
      return proto.build();

    // normal distribution
    if (u.distributionType == UncertaintyType.NORMAL) {
      proto.setDistributionType(
        Proto.UncertaintyType.NORMAL_DISTRIBUTION);

      if (u.parameter1 != null) {
        proto.setMean(u.parameter1);
      }
      if (u.formula1 != null) {
        proto.setMeanFormula(u.formula1);
      }

      if (u.parameter2 != null) {
        proto.setSd(u.parameter2);
      }
      if (u.formula2 != null) {
        proto.setSdFormula(u.formula2);
      }
    }

    // log-normal distribution
    if (u.distributionType == UncertaintyType.LOG_NORMAL) {
      proto.setDistributionType(
        Proto.UncertaintyType.LOG_NORMAL_DISTRIBUTION);

      if (u.parameter1 != null) {
        proto.setGeomMean(u.parameter1);
      }
      if (u.formula1 != null) {
        proto.setGeomMeanFormula(u.formula1);
      }

      if (u.parameter2 != null) {
        proto.setGeomSd(u.parameter2);
      }
      if (u.formula2 != null) {
        proto.setGeomSdFormula(u.formula2);
      }
    }

    // uniform distribution
    if (u.distributionType == UncertaintyType.UNIFORM) {
      proto.setDistributionType(
        Proto.UncertaintyType.UNIFORM_DISTRIBUTION);

      if (u.parameter1 != null) {
        proto.setMinimum(u.parameter1);
      }
      if (u.formula1 != null) {
        proto.setMinimumFormula(u.formula1);
      }

      if (u.parameter2 != null) {
        proto.setMaximum(u.parameter2);
      }
      if (u.formula2 != null) {
        proto.setMaximumFormula(u.formula2);
      }
    }

    // triangle distribution
    if (u.distributionType == UncertaintyType.TRIANGLE) {
      proto.setDistributionType(
        Proto.UncertaintyType.TRIANGLE_DISTRIBUTION);

      if (u.parameter1 != null) {
        proto.setMinimum(u.parameter1);
      }
      if (u.formula1 != null) {
        proto.setMinimumFormula(u.formula1);
      }

      if (u.parameter2 != null) {
        proto.setMode(u.parameter2);
      }
      if (u.formula2 != null) {
        proto.setModeFormula(u.formula2);
      }

      if (u.parameter3 != null) {
        proto.setMaximum(u.parameter3);
      }
      if (u.formula3 != null) {
        proto.setMaximumFormula(u.formula3);
      }
    }
    return proto.build();
  }
}
