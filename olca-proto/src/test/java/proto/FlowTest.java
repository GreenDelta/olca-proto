package proto;

import org.junit.Assert;
import org.junit.Test;
import org.openlca.proto.Proto;

public class FlowTest {

  @Test
  public void testWriteRead() throws Exception {
    var flow = Proto.Flow.newBuilder()
      .setName("CO2")
      .setFlowType(Proto.FlowType.ELEMENTARY_FLOW)
      .build();
    var data = flow.toByteArray();
    var clone = Proto.Flow.parseFrom(data);
    Assert.assertEquals("CO2", clone.getName());
    Assert.assertEquals(Proto.FlowType.ELEMENTARY_FLOW, clone.getFlowType());
  }
}
