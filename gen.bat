@echo off

rem Java version
protoc olca.proto --java_out=src\main\java

rem Python version
rem protoc olca.proto --python_out=python\protolca
rem xcopy /y python\protolca\olca_pb2.py python\protolca\__init__.py
rem del python\protolca\olca_pb2.py

protoc -I . --python_betterproto_out=python\protolca olca.proto
