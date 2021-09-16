# olca-proto
`olca-proto` is a [Protocol Buffers](https://developers.google.com/protocol-buffers)
implementation of the [olca-schema format](https://github.com/GreenDelta/olca-schema)
with some extensions. It also defines a [gRPC](https://grpc.io/) service
interface for calling [openLCA](https://www.openlca.org) functions.

## Usage
If you use Maven, just add the following dependency:

```xml
<dependency>
  <groupId>org.openlca</groupId>
  <artifactId>olca-proto</artifactId>
  <version>1.0.0</version>
</dependency>
```

For the gRPC service interface, add this:

```xml
<dependency>
  <groupId>org.openlca</groupId>
  <artifactId>olca-grpc</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Generating the model

The [genproto](./genproto/main.go) tool directly generates the
[olca.proto](./proto/olca.proto) definition from the YAML files of the
`olca-schema` project. It takes the path to the `olca-schema` folder as first
argument and the path to the output file of the proto3 definitions as second
argument:

```bash
cd genproto
# go build    # to build the tool
genproto ../../olca-schema ../proto/olca.proto
cd ..
```

To generate the Java source code, we use the
[protobuf-maven-plugin](https://github.com/xolstice/protobuf-maven-plugin):

```
mvn compile
```

## Examples

A single class `Proto` is generated:

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
