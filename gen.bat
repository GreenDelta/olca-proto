@echo off

rem Java
protoc olca.proto --java_out=java\src\main\java

rem Python
protoc olca.proto --python_out=python/protolca --mypy_out=python/protolca
xcopy /y python\protolca\olca_pb2.py python\protolca\__init__.py
xcopy /y python\protolca\olca_pb2.pyi python\protolca\__init__.pyi
del python\protolca\olca_pb2.py
del python\protolca\olca_pb2.pyi

rem Go
protoc olca.proto --go_out=go\protolca
