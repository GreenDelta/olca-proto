@echo off

rem Java version
protoc olca.proto --java_out=src\main\java

rem Python version
protoc olca.proto --python_out=python\protolca
xcopy /y python\protolca\olca_pb2.py python\protolca\__init__.py
del python\protolca\olca_pb2.py
