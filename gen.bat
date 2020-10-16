@echo off


rem Generate the Java model
protoc olca.proto --java_out=src\main\java
protoc services.proto --java_out=src\main\java
rem Generate the gRPC services
protoc --plugin=protoc-gen-grpc-java.exe --grpc-java_out=src\main\java --proto_path=. services.proto


rem Python
rem protoc olca.proto --python_out=python/protolca --mypy_out=python/protolca
rem xcopy /y python\protolca\olca_pb2.py python\protolca\__init__.py
rem xcopy /y python\protolca\olca_pb2.pyi python\protolca\__init__.pyi
rem del python\protolca\olca_pb2.py
rem del python\protolca\olca_pb2.pyi

rem Go
rem protoc olca.proto --go_out=go\protolca
