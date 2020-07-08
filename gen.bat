@echo off

rem Java version
protoc olca.proto --java_out=src\main\java

rem Python version
protoc olca.proto --python_out=python\olca
xcopy /y python\olca\olca_pb2.py python\olca\proto.py
del python\olca\olca_pb2.py
