@echo off


rem Generate the Java model
protoc olca.proto --java_out=src\main\java
protoc services.proto --java_out=src\main\java
rem Generate the gRPC services
protoc --plugin=protoc-gen-grpc-java.exe --grpc-java_out=src\main\java --proto_path=. services.proto

rem Go
rem protoc olca.proto --go_out=go\protolca
