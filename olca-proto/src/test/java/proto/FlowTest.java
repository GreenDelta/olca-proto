package proto;

import org.junit.Assert;
import org.junit.Test;
import org.openlca.proto.ProtoFlow;
import org.openlca.proto.ProtoFlowType;

public class FlowTest {

  @Test
  public void testWriteRead() throws Exception {
    var flow = ProtoFlow.newBuilder()
      .setName("CO2")
      .setFlowType(ProtoFlowType.ELEMENTARY_FLOW)
      .build();
    var data = flow.toByteArray();
    var clone = ProtoFlow.parseFrom(data);
    Assert.assertEquals("CO2", clone.getName());
    Assert.assertEquals(ProtoFlowType.ELEMENTARY_FLOW, clone.getFlowType());
  }
}
