# olca-proto
`olca-proto` is a [Protocol Buffers](https://developers.google.com/protocol-buffers)
implementation of the [olca-schema format](https://github.com/GreenDelta/olca-schema).
It also defines a [gRPC](https://grpc.io/) service interface for calling
[openLCA](https://www.openlca.org) functions.

## Usage
If you use Maven, just add the following dependency:

```xml
<dependency>
  <groupId>org.openlca</groupId>
  <artifactId>olca-proto</artifactId>
  <version>2.0.0</version>
</dependency>
```

For the gRPC service interface, add this:

```xml
<dependency>
  <groupId>org.openlca</groupId>
  <artifactId>olca-grpc</artifactId>
  <version>2.0.0</version>
</dependency>
```

## Building from source

The Java source code is generated from proto3 files in the `proto` folder of
this project. The `olca.proto` file contains the definition of the openLCA
schema format and is generated via the `osch` tool of the [olca-schema project](
https://github.com/GreenDelta/olca-schema).

To generate the Java source code, we use the
[protobuf-maven-plugin](https://github.com/xolstice/protobuf-maven-plugin):

```bash
mvn compile
```

You need to have the `protoc` compiler with the gRPC plugin for Java installed.
One way to install it, is to just put the binaries of these tools into your
system path. The `protoc` binary can be downloaded from its GitHub release page:
https://github.com/protocolbuffers/protobuf/releases. The gRPC Java plugin
can be downloaded from the Maven Central Repository:
https://repo1.maven.org/maven2/io/grpc/protoc-gen-grpc-java/. You may need to
rename the plugin to `protoc-gen-grpc-java` and set the executable flags:

```bash
chmod +x protoc-gen-grpc-java
```
