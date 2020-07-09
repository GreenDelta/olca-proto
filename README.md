# olca-proto
`olca-proto` is an implementation of the
[olca-schema](https://github.com/GreenDelta/olca-schema)
format that supports serialization in JSON-LD and
[protocol buffers](https://developers.google.com/protocol-buffers). The
[genproto](./scripts/genproto/main.go) tool directly generates the
[olca.proto](olca.proto) definition from the YAML files of the `olca-schema`
project:

```
$ genproto path/to/olca-schema path/to/olca.proto
```

From the `olca.proto` definition we then generate the APIs with the `gen`
script:

```
$ gen
```

__Java__

For Java, a single class `Proto` is generated:

```java
import org.openlca.proto;
import com.google.protobuf.util.JsonFormat;

var flow = Proto.Flow.newBuilder()
    .setType("Flow")
    .setId(UUID.randomUUID().toString())
    .setName("Steel")
    .setFlowType(Proto.FlowType.PRODUCT_FLOW)
    .build();
var json = JsonFormat.printer().print(flow);
System.out.println(json);
```

This will generate the following output:

```json
{
  "@type": "Flow",
  "@id": "481682dd-c2a2-4646-9760-b0fe3e242676",
  "name": "Steel",
  "flowType": "PRODUCT_FLOW"
}
```

__Python__
For the Python version we use the
[mypy-protobuf](https://github.com/dropbox/mypy-protobuf) plugin to generate
type hints. Everything is written into a `protolca` module:

```python
import protolca as proto
import google.protobuf.json_format as json

flow = proto.Flow()
flow.type = 'Flow'
flow.id = str(uuid.uuid4())
flow.name = 'Steel'
flow.flowType = proto.FlowType.PRODUCT_FLOW
print(json.MessageToJson(flow))
```

This will generate the same output as for the Java version above.
