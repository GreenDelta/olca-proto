package proto;

import static org.junit.Assert.*;

import com.google.protobuf.util.JsonFormat;
import org.junit.Assert;
import org.junit.Test;
import org.openlca.proto.ProtoFlow;
import org.openlca.proto.ProtoFlowType;
import org.openlca.proto.ProtoType;

public class FlowTest {

  @Test
  public void testWriteReadBin() throws Exception {
    var flow = ProtoFlow.newBuilder()
      .setType(ProtoType.Flow)
      .setName("CO2")
      .setFlowType(ProtoFlowType.ELEMENTARY_FLOW)
      .build();
    var data = flow.toByteArray();
    var clone = ProtoFlow.parseFrom(data);
    Assert.assertEquals("CO2", clone.getName());
    Assert.assertEquals(ProtoFlowType.ELEMENTARY_FLOW, clone.getFlowType());
  }

  @Test
  public void testReadJson() throws Exception {
    var json = "{\"@type\": \"Flow\", \"@id\": \"123\", \"name\": \"CO2\"}";
    var flow = ProtoFlow.newBuilder();
    JsonFormat.parser().merge(json, flow);
    assertEquals(ProtoType.Flow, flow.getType());
    assertEquals("123", flow.getId());
    assertEquals("CO2", flow.getName());
  }
}
