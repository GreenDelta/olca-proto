package proto;

import com.google.protobuf.util.JsonFormat;
import org.junit.Test;
import org.openlca.proto.ProtoCategory;
import org.openlca.proto.ProtoCategoryType;
import org.openlca.proto.ProtoType;

import static org.junit.Assert.*;

public class CategoryTest {

  @Test
  public void testReadModelType() throws Exception {
    var json = "{\n" +
      "  \"@type\": \"Category\",\n" +
      "  \"name\": \"emissions\",\n" +
      "  \"modelType\": \"FLOW\" }\"";

    var category = ProtoCategory.newBuilder();
    JsonFormat.parser().merge(json, category);

    assertEquals(ProtoType.Category, category.getType());
    assertEquals(ProtoCategoryType.FLOW, category.getModelType());
    assertEquals("emissions", category.getName());
  }
}
