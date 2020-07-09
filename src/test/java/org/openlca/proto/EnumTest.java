package org.openlca.proto;

import com.google.protobuf.util.JsonFormat;

import org.junit.Assert;
import org.junit.Test;

public class EnumTest {

	@Test
	public void test() throws Exception {
    var flow = Proto.Flow.newBuilder();
    flow.setName("CO2");
    flow.setFlowType(Proto.FlowType.ELEMENTARY_FLOW);
		System.out.println(JsonFormat.printer().print(flow));
	}
}
