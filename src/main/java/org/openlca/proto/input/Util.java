package org.openlca.proto.input;

import org.openlca.core.model.Uncertainty;
import org.openlca.proto.Proto;

class Util {

  private Util() {
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
}
