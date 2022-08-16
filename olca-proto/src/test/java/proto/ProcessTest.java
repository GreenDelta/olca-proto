package proto;

import static org.junit.Assert.*;

import com.google.protobuf.util.JsonFormat;
import org.junit.Test;
import org.openlca.proto.ProtoProcess;
import org.openlca.proto.ProtoProcessType;
import org.openlca.proto.ProtoType;

public class ProcessTest {

  @Test
  public void testReadModelType() throws Exception {
    var json = "{\n" +
      "  \"@type\": \"Process\",\n" +
      "  \"name\": \"steel production\",\n" +
      "  \"processType\": \"UNIT_PROCESS\" }\"";

    var p = ProtoProcess.newBuilder();
    JsonFormat.parser().merge(json, p);

    assertEquals(ProtoType.Process, p.getType());
    assertEquals(ProtoProcessType.UNIT_PROCESS, p.getProcessType());
    assertEquals("steel production", p.getName());
  }
}
