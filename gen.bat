@echo off

rem Java version
protoc olca.proto --java_out=src\main\java

rem Python version
protoc olca.proto --python_out=python/protolca --mypy_out=python/protolca
xcopy /y python\protolca\olca_pb2.py python\protolca\__init__.py
xcopy /y python\protolca\olca_pb2.pyi python\protolca\__init__.pyi
del python\protolca\olca_pb2.py
del python\protolca\olca_pb2.pyi
