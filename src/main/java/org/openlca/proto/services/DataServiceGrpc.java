package org.openlca.proto.services;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.33.0)",
    comments = "Source: services.proto")
public final class DataServiceGrpc {

  private DataServiceGrpc() {}

  public static final String SERVICE_NAME = "protolca.services.DataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Actor> getActorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "actors",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.Actor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Actor> getActorsMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Actor> getActorsMethod;
    if ((getActorsMethod = DataServiceGrpc.getActorsMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getActorsMethod = DataServiceGrpc.getActorsMethod) == null) {
          DataServiceGrpc.getActorsMethod = getActorsMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Actor>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "actors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Actor.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("actors"))
              .build();
        }
      }
    }
    return getActorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Actor> getActorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "actor",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.Actor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Actor> getActorMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Actor> getActorMethod;
    if ((getActorMethod = DataServiceGrpc.getActorMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getActorMethod = DataServiceGrpc.getActorMethod) == null) {
          DataServiceGrpc.getActorMethod = getActorMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Actor>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "actor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Actor.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("actor"))
              .build();
        }
      }
    }
    return getActorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Actor,
      org.openlca.proto.Proto.Ref> getPutActorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_actor",
      requestType = org.openlca.proto.Proto.Actor.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Actor,
      org.openlca.proto.Proto.Ref> getPutActorMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Actor, org.openlca.proto.Proto.Ref> getPutActorMethod;
    if ((getPutActorMethod = DataServiceGrpc.getPutActorMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutActorMethod = DataServiceGrpc.getPutActorMethod) == null) {
          DataServiceGrpc.getPutActorMethod = getPutActorMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Actor, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_actor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Actor.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_actor"))
              .build();
        }
      }
    }
    return getPutActorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Category> getCategorysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "categorys",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.Category.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Category> getCategorysMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Category> getCategorysMethod;
    if ((getCategorysMethod = DataServiceGrpc.getCategorysMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getCategorysMethod = DataServiceGrpc.getCategorysMethod) == null) {
          DataServiceGrpc.getCategorysMethod = getCategorysMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Category>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "categorys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Category.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("categorys"))
              .build();
        }
      }
    }
    return getCategorysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Category> getCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "category",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.Category.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Category> getCategoryMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Category> getCategoryMethod;
    if ((getCategoryMethod = DataServiceGrpc.getCategoryMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getCategoryMethod = DataServiceGrpc.getCategoryMethod) == null) {
          DataServiceGrpc.getCategoryMethod = getCategoryMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Category>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "category"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Category.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("category"))
              .build();
        }
      }
    }
    return getCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Category,
      org.openlca.proto.Proto.Ref> getPutCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_category",
      requestType = org.openlca.proto.Proto.Category.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Category,
      org.openlca.proto.Proto.Ref> getPutCategoryMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Category, org.openlca.proto.Proto.Ref> getPutCategoryMethod;
    if ((getPutCategoryMethod = DataServiceGrpc.getPutCategoryMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutCategoryMethod = DataServiceGrpc.getPutCategoryMethod) == null) {
          DataServiceGrpc.getPutCategoryMethod = getPutCategoryMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Category, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_category"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Category.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_category"))
              .build();
        }
      }
    }
    return getPutCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Currency> getCurrenciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "currencies",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.Currency.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Currency> getCurrenciesMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Currency> getCurrenciesMethod;
    if ((getCurrenciesMethod = DataServiceGrpc.getCurrenciesMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getCurrenciesMethod = DataServiceGrpc.getCurrenciesMethod) == null) {
          DataServiceGrpc.getCurrenciesMethod = getCurrenciesMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Currency>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "currencies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Currency.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("currencies"))
              .build();
        }
      }
    }
    return getCurrenciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Currency> getCurrencyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "currency",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.Currency.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Currency> getCurrencyMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Currency> getCurrencyMethod;
    if ((getCurrencyMethod = DataServiceGrpc.getCurrencyMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getCurrencyMethod = DataServiceGrpc.getCurrencyMethod) == null) {
          DataServiceGrpc.getCurrencyMethod = getCurrencyMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Currency>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "currency"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Currency.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("currency"))
              .build();
        }
      }
    }
    return getCurrencyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Currency,
      org.openlca.proto.Proto.Ref> getPutCurrencyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_currency",
      requestType = org.openlca.proto.Proto.Currency.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Currency,
      org.openlca.proto.Proto.Ref> getPutCurrencyMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Currency, org.openlca.proto.Proto.Ref> getPutCurrencyMethod;
    if ((getPutCurrencyMethod = DataServiceGrpc.getPutCurrencyMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutCurrencyMethod = DataServiceGrpc.getPutCurrencyMethod) == null) {
          DataServiceGrpc.getPutCurrencyMethod = getPutCurrencyMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Currency, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_currency"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Currency.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_currency"))
              .build();
        }
      }
    }
    return getPutCurrencyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.DqSystem> getDqSystemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "dq_systems",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.DqSystem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.DqSystem> getDqSystemsMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.DqSystem> getDqSystemsMethod;
    if ((getDqSystemsMethod = DataServiceGrpc.getDqSystemsMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getDqSystemsMethod = DataServiceGrpc.getDqSystemsMethod) == null) {
          DataServiceGrpc.getDqSystemsMethod = getDqSystemsMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.DqSystem>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "dq_systems"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.DqSystem.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("dq_systems"))
              .build();
        }
      }
    }
    return getDqSystemsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.DqSystem> getDqSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "dq_system",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.DqSystem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.DqSystem> getDqSystemMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.DqSystem> getDqSystemMethod;
    if ((getDqSystemMethod = DataServiceGrpc.getDqSystemMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getDqSystemMethod = DataServiceGrpc.getDqSystemMethod) == null) {
          DataServiceGrpc.getDqSystemMethod = getDqSystemMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.DqSystem>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "dq_system"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.DqSystem.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("dq_system"))
              .build();
        }
      }
    }
    return getDqSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.DqSystem,
      org.openlca.proto.Proto.Ref> getPutDqSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_dq_system",
      requestType = org.openlca.proto.Proto.DqSystem.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.DqSystem,
      org.openlca.proto.Proto.Ref> getPutDqSystemMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.DqSystem, org.openlca.proto.Proto.Ref> getPutDqSystemMethod;
    if ((getPutDqSystemMethod = DataServiceGrpc.getPutDqSystemMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutDqSystemMethod = DataServiceGrpc.getPutDqSystemMethod) == null) {
          DataServiceGrpc.getPutDqSystemMethod = getPutDqSystemMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.DqSystem, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_dq_system"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.DqSystem.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_dq_system"))
              .build();
        }
      }
    }
    return getPutDqSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Flow> getFlowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "flows",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.Flow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Flow> getFlowsMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Flow> getFlowsMethod;
    if ((getFlowsMethod = DataServiceGrpc.getFlowsMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getFlowsMethod = DataServiceGrpc.getFlowsMethod) == null) {
          DataServiceGrpc.getFlowsMethod = getFlowsMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Flow>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "flows"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Flow.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("flows"))
              .build();
        }
      }
    }
    return getFlowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Flow> getFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "flow",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.Flow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Flow> getFlowMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Flow> getFlowMethod;
    if ((getFlowMethod = DataServiceGrpc.getFlowMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getFlowMethod = DataServiceGrpc.getFlowMethod) == null) {
          DataServiceGrpc.getFlowMethod = getFlowMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Flow>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "flow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Flow.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("flow"))
              .build();
        }
      }
    }
    return getFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Flow,
      org.openlca.proto.Proto.Ref> getPutFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_flow",
      requestType = org.openlca.proto.Proto.Flow.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Flow,
      org.openlca.proto.Proto.Ref> getPutFlowMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Flow, org.openlca.proto.Proto.Ref> getPutFlowMethod;
    if ((getPutFlowMethod = DataServiceGrpc.getPutFlowMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutFlowMethod = DataServiceGrpc.getPutFlowMethod) == null) {
          DataServiceGrpc.getPutFlowMethod = getPutFlowMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Flow, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_flow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Flow.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_flow"))
              .build();
        }
      }
    }
    return getPutFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.FlowProperty> getFlowPropertiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "flow_properties",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.FlowProperty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.FlowProperty> getFlowPropertiesMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.FlowProperty> getFlowPropertiesMethod;
    if ((getFlowPropertiesMethod = DataServiceGrpc.getFlowPropertiesMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getFlowPropertiesMethod = DataServiceGrpc.getFlowPropertiesMethod) == null) {
          DataServiceGrpc.getFlowPropertiesMethod = getFlowPropertiesMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.FlowProperty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "flow_properties"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.FlowProperty.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("flow_properties"))
              .build();
        }
      }
    }
    return getFlowPropertiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.FlowProperty> getFlowPropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "flow_property",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.FlowProperty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.FlowProperty> getFlowPropertyMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.FlowProperty> getFlowPropertyMethod;
    if ((getFlowPropertyMethod = DataServiceGrpc.getFlowPropertyMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getFlowPropertyMethod = DataServiceGrpc.getFlowPropertyMethod) == null) {
          DataServiceGrpc.getFlowPropertyMethod = getFlowPropertyMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.FlowProperty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "flow_property"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.FlowProperty.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("flow_property"))
              .build();
        }
      }
    }
    return getFlowPropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.FlowProperty,
      org.openlca.proto.Proto.Ref> getPutFlowPropertyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_flow_property",
      requestType = org.openlca.proto.Proto.FlowProperty.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.FlowProperty,
      org.openlca.proto.Proto.Ref> getPutFlowPropertyMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.FlowProperty, org.openlca.proto.Proto.Ref> getPutFlowPropertyMethod;
    if ((getPutFlowPropertyMethod = DataServiceGrpc.getPutFlowPropertyMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutFlowPropertyMethod = DataServiceGrpc.getPutFlowPropertyMethod) == null) {
          DataServiceGrpc.getPutFlowPropertyMethod = getPutFlowPropertyMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.FlowProperty, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_flow_property"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.FlowProperty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_flow_property"))
              .build();
        }
      }
    }
    return getPutFlowPropertyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.ImpactCategory> getImpactCategoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "impact_categories",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.ImpactCategory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.ImpactCategory> getImpactCategoriesMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.ImpactCategory> getImpactCategoriesMethod;
    if ((getImpactCategoriesMethod = DataServiceGrpc.getImpactCategoriesMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getImpactCategoriesMethod = DataServiceGrpc.getImpactCategoriesMethod) == null) {
          DataServiceGrpc.getImpactCategoriesMethod = getImpactCategoriesMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.ImpactCategory>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "impact_categories"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.ImpactCategory.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("impact_categories"))
              .build();
        }
      }
    }
    return getImpactCategoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.ImpactCategory> getImpactCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "impact_category",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.ImpactCategory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.ImpactCategory> getImpactCategoryMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.ImpactCategory> getImpactCategoryMethod;
    if ((getImpactCategoryMethod = DataServiceGrpc.getImpactCategoryMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getImpactCategoryMethod = DataServiceGrpc.getImpactCategoryMethod) == null) {
          DataServiceGrpc.getImpactCategoryMethod = getImpactCategoryMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.ImpactCategory>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "impact_category"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.ImpactCategory.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("impact_category"))
              .build();
        }
      }
    }
    return getImpactCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.ImpactCategory,
      org.openlca.proto.Proto.Ref> getPutImpactCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_impact_category",
      requestType = org.openlca.proto.Proto.ImpactCategory.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.ImpactCategory,
      org.openlca.proto.Proto.Ref> getPutImpactCategoryMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.ImpactCategory, org.openlca.proto.Proto.Ref> getPutImpactCategoryMethod;
    if ((getPutImpactCategoryMethod = DataServiceGrpc.getPutImpactCategoryMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutImpactCategoryMethod = DataServiceGrpc.getPutImpactCategoryMethod) == null) {
          DataServiceGrpc.getPutImpactCategoryMethod = getPutImpactCategoryMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.ImpactCategory, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_impact_category"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.ImpactCategory.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_impact_category"))
              .build();
        }
      }
    }
    return getPutImpactCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.ImpactMethod> getImpactMethodsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "impact_methods",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.ImpactMethod.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.ImpactMethod> getImpactMethodsMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.ImpactMethod> getImpactMethodsMethod;
    if ((getImpactMethodsMethod = DataServiceGrpc.getImpactMethodsMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getImpactMethodsMethod = DataServiceGrpc.getImpactMethodsMethod) == null) {
          DataServiceGrpc.getImpactMethodsMethod = getImpactMethodsMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.ImpactMethod>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "impact_methods"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.ImpactMethod.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("impact_methods"))
              .build();
        }
      }
    }
    return getImpactMethodsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.ImpactMethod> getImpactMethodMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "impact_method",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.ImpactMethod.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.ImpactMethod> getImpactMethodMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.ImpactMethod> getImpactMethodMethod;
    if ((getImpactMethodMethod = DataServiceGrpc.getImpactMethodMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getImpactMethodMethod = DataServiceGrpc.getImpactMethodMethod) == null) {
          DataServiceGrpc.getImpactMethodMethod = getImpactMethodMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.ImpactMethod>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "impact_method"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.ImpactMethod.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("impact_method"))
              .build();
        }
      }
    }
    return getImpactMethodMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.ImpactMethod,
      org.openlca.proto.Proto.Ref> getPutImpactMethodMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_impact_method",
      requestType = org.openlca.proto.Proto.ImpactMethod.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.ImpactMethod,
      org.openlca.proto.Proto.Ref> getPutImpactMethodMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.ImpactMethod, org.openlca.proto.Proto.Ref> getPutImpactMethodMethod;
    if ((getPutImpactMethodMethod = DataServiceGrpc.getPutImpactMethodMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutImpactMethodMethod = DataServiceGrpc.getPutImpactMethodMethod) == null) {
          DataServiceGrpc.getPutImpactMethodMethod = getPutImpactMethodMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.ImpactMethod, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_impact_method"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.ImpactMethod.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_impact_method"))
              .build();
        }
      }
    }
    return getPutImpactMethodMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Location> getLocationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "locations",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.Location.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Location> getLocationsMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Location> getLocationsMethod;
    if ((getLocationsMethod = DataServiceGrpc.getLocationsMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getLocationsMethod = DataServiceGrpc.getLocationsMethod) == null) {
          DataServiceGrpc.getLocationsMethod = getLocationsMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Location>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "locations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Location.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("locations"))
              .build();
        }
      }
    }
    return getLocationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Location> getLocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "location",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.Location.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Location> getLocationMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Location> getLocationMethod;
    if ((getLocationMethod = DataServiceGrpc.getLocationMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getLocationMethod = DataServiceGrpc.getLocationMethod) == null) {
          DataServiceGrpc.getLocationMethod = getLocationMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Location>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "location"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Location.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("location"))
              .build();
        }
      }
    }
    return getLocationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Location,
      org.openlca.proto.Proto.Ref> getPutLocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_location",
      requestType = org.openlca.proto.Proto.Location.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Location,
      org.openlca.proto.Proto.Ref> getPutLocationMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Location, org.openlca.proto.Proto.Ref> getPutLocationMethod;
    if ((getPutLocationMethod = DataServiceGrpc.getPutLocationMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutLocationMethod = DataServiceGrpc.getPutLocationMethod) == null) {
          DataServiceGrpc.getPutLocationMethod = getPutLocationMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Location, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_location"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Location.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_location"))
              .build();
        }
      }
    }
    return getPutLocationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Parameter> getParametersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "parameters",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.Parameter.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Parameter> getParametersMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Parameter> getParametersMethod;
    if ((getParametersMethod = DataServiceGrpc.getParametersMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getParametersMethod = DataServiceGrpc.getParametersMethod) == null) {
          DataServiceGrpc.getParametersMethod = getParametersMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Parameter>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "parameters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Parameter.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("parameters"))
              .build();
        }
      }
    }
    return getParametersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Parameter> getParameterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "parameter",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.Parameter.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Parameter> getParameterMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Parameter> getParameterMethod;
    if ((getParameterMethod = DataServiceGrpc.getParameterMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getParameterMethod = DataServiceGrpc.getParameterMethod) == null) {
          DataServiceGrpc.getParameterMethod = getParameterMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Parameter>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "parameter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Parameter.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("parameter"))
              .build();
        }
      }
    }
    return getParameterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Parameter,
      org.openlca.proto.Proto.Ref> getPutParameterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_parameter",
      requestType = org.openlca.proto.Proto.Parameter.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Parameter,
      org.openlca.proto.Proto.Ref> getPutParameterMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Parameter, org.openlca.proto.Proto.Ref> getPutParameterMethod;
    if ((getPutParameterMethod = DataServiceGrpc.getPutParameterMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutParameterMethod = DataServiceGrpc.getPutParameterMethod) == null) {
          DataServiceGrpc.getPutParameterMethod = getPutParameterMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Parameter, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_parameter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Parameter.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_parameter"))
              .build();
        }
      }
    }
    return getPutParameterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Process> getProcessesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processes",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.Process.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Process> getProcessesMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Process> getProcessesMethod;
    if ((getProcessesMethod = DataServiceGrpc.getProcessesMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getProcessesMethod = DataServiceGrpc.getProcessesMethod) == null) {
          DataServiceGrpc.getProcessesMethod = getProcessesMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Process>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "processes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Process.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("processes"))
              .build();
        }
      }
    }
    return getProcessesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Process> getProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "process",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.Process.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Process> getProcessMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Process> getProcessMethod;
    if ((getProcessMethod = DataServiceGrpc.getProcessMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getProcessMethod = DataServiceGrpc.getProcessMethod) == null) {
          DataServiceGrpc.getProcessMethod = getProcessMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Process>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "process"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Process.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("process"))
              .build();
        }
      }
    }
    return getProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Process,
      org.openlca.proto.Proto.Ref> getPutProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_process",
      requestType = org.openlca.proto.Proto.Process.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Process,
      org.openlca.proto.Proto.Ref> getPutProcessMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Process, org.openlca.proto.Proto.Ref> getPutProcessMethod;
    if ((getPutProcessMethod = DataServiceGrpc.getPutProcessMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutProcessMethod = DataServiceGrpc.getPutProcessMethod) == null) {
          DataServiceGrpc.getPutProcessMethod = getPutProcessMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Process, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_process"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Process.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_process"))
              .build();
        }
      }
    }
    return getPutProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.ProductSystem> getProductSystemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "product_systems",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.ProductSystem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.ProductSystem> getProductSystemsMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.ProductSystem> getProductSystemsMethod;
    if ((getProductSystemsMethod = DataServiceGrpc.getProductSystemsMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getProductSystemsMethod = DataServiceGrpc.getProductSystemsMethod) == null) {
          DataServiceGrpc.getProductSystemsMethod = getProductSystemsMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.ProductSystem>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "product_systems"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.ProductSystem.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("product_systems"))
              .build();
        }
      }
    }
    return getProductSystemsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.ProductSystem> getProductSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "product_system",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.ProductSystem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.ProductSystem> getProductSystemMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.ProductSystem> getProductSystemMethod;
    if ((getProductSystemMethod = DataServiceGrpc.getProductSystemMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getProductSystemMethod = DataServiceGrpc.getProductSystemMethod) == null) {
          DataServiceGrpc.getProductSystemMethod = getProductSystemMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.ProductSystem>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "product_system"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.ProductSystem.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("product_system"))
              .build();
        }
      }
    }
    return getProductSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.ProductSystem,
      org.openlca.proto.Proto.Ref> getPutProductSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_product_system",
      requestType = org.openlca.proto.Proto.ProductSystem.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.ProductSystem,
      org.openlca.proto.Proto.Ref> getPutProductSystemMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.ProductSystem, org.openlca.proto.Proto.Ref> getPutProductSystemMethod;
    if ((getPutProductSystemMethod = DataServiceGrpc.getPutProductSystemMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutProductSystemMethod = DataServiceGrpc.getPutProductSystemMethod) == null) {
          DataServiceGrpc.getPutProductSystemMethod = getPutProductSystemMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.ProductSystem, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_product_system"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.ProductSystem.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_product_system"))
              .build();
        }
      }
    }
    return getPutProductSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Project> getProjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "projects",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.Project.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Project> getProjectsMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Project> getProjectsMethod;
    if ((getProjectsMethod = DataServiceGrpc.getProjectsMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getProjectsMethod = DataServiceGrpc.getProjectsMethod) == null) {
          DataServiceGrpc.getProjectsMethod = getProjectsMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Project>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "projects"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Project.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("projects"))
              .build();
        }
      }
    }
    return getProjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Project> getProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "project",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.Project.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Project> getProjectMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Project> getProjectMethod;
    if ((getProjectMethod = DataServiceGrpc.getProjectMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getProjectMethod = DataServiceGrpc.getProjectMethod) == null) {
          DataServiceGrpc.getProjectMethod = getProjectMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Project>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "project"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Project.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("project"))
              .build();
        }
      }
    }
    return getProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Project,
      org.openlca.proto.Proto.Ref> getPutProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_project",
      requestType = org.openlca.proto.Proto.Project.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Project,
      org.openlca.proto.Proto.Ref> getPutProjectMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Project, org.openlca.proto.Proto.Ref> getPutProjectMethod;
    if ((getPutProjectMethod = DataServiceGrpc.getPutProjectMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutProjectMethod = DataServiceGrpc.getPutProjectMethod) == null) {
          DataServiceGrpc.getPutProjectMethod = getPutProjectMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Project, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_project"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Project.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_project"))
              .build();
        }
      }
    }
    return getPutProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.SocialIndicator> getSocialIndicatorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "social_indicators",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.SocialIndicator.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.SocialIndicator> getSocialIndicatorsMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.SocialIndicator> getSocialIndicatorsMethod;
    if ((getSocialIndicatorsMethod = DataServiceGrpc.getSocialIndicatorsMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getSocialIndicatorsMethod = DataServiceGrpc.getSocialIndicatorsMethod) == null) {
          DataServiceGrpc.getSocialIndicatorsMethod = getSocialIndicatorsMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.SocialIndicator>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "social_indicators"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.SocialIndicator.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("social_indicators"))
              .build();
        }
      }
    }
    return getSocialIndicatorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.SocialIndicator> getSocialIndicatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "social_indicator",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.SocialIndicator.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.SocialIndicator> getSocialIndicatorMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.SocialIndicator> getSocialIndicatorMethod;
    if ((getSocialIndicatorMethod = DataServiceGrpc.getSocialIndicatorMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getSocialIndicatorMethod = DataServiceGrpc.getSocialIndicatorMethod) == null) {
          DataServiceGrpc.getSocialIndicatorMethod = getSocialIndicatorMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.SocialIndicator>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "social_indicator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.SocialIndicator.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("social_indicator"))
              .build();
        }
      }
    }
    return getSocialIndicatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.SocialIndicator,
      org.openlca.proto.Proto.Ref> getPutSocialIndicatorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_social_indicator",
      requestType = org.openlca.proto.Proto.SocialIndicator.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.SocialIndicator,
      org.openlca.proto.Proto.Ref> getPutSocialIndicatorMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.SocialIndicator, org.openlca.proto.Proto.Ref> getPutSocialIndicatorMethod;
    if ((getPutSocialIndicatorMethod = DataServiceGrpc.getPutSocialIndicatorMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutSocialIndicatorMethod = DataServiceGrpc.getPutSocialIndicatorMethod) == null) {
          DataServiceGrpc.getPutSocialIndicatorMethod = getPutSocialIndicatorMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.SocialIndicator, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_social_indicator"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.SocialIndicator.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_social_indicator"))
              .build();
        }
      }
    }
    return getPutSocialIndicatorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Source> getSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sources",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.Source> getSourcesMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Source> getSourcesMethod;
    if ((getSourcesMethod = DataServiceGrpc.getSourcesMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getSourcesMethod = DataServiceGrpc.getSourcesMethod) == null) {
          DataServiceGrpc.getSourcesMethod = getSourcesMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.Source>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sources"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Source.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("sources"))
              .build();
        }
      }
    }
    return getSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Source> getSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "source",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.Source> getSourceMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Source> getSourceMethod;
    if ((getSourceMethod = DataServiceGrpc.getSourceMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getSourceMethod = DataServiceGrpc.getSourceMethod) == null) {
          DataServiceGrpc.getSourceMethod = getSourceMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.Source>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "source"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Source.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("source"))
              .build();
        }
      }
    }
    return getSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Source,
      org.openlca.proto.Proto.Ref> getPutSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_source",
      requestType = org.openlca.proto.Proto.Source.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Source,
      org.openlca.proto.Proto.Ref> getPutSourceMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Source, org.openlca.proto.Proto.Ref> getPutSourceMethod;
    if ((getPutSourceMethod = DataServiceGrpc.getPutSourceMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutSourceMethod = DataServiceGrpc.getPutSourceMethod) == null) {
          DataServiceGrpc.getPutSourceMethod = getPutSourceMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Source, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_source"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Source.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_source"))
              .build();
        }
      }
    }
    return getPutSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.UnitGroup> getUnitGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "unit_groups",
      requestType = org.openlca.proto.services.Services.Empty.class,
      responseType = org.openlca.proto.Proto.UnitGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty,
      org.openlca.proto.Proto.UnitGroup> getUnitGroupsMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.UnitGroup> getUnitGroupsMethod;
    if ((getUnitGroupsMethod = DataServiceGrpc.getUnitGroupsMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getUnitGroupsMethod = DataServiceGrpc.getUnitGroupsMethod) == null) {
          DataServiceGrpc.getUnitGroupsMethod = getUnitGroupsMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.services.Services.Empty, org.openlca.proto.Proto.UnitGroup>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "unit_groups"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.services.Services.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.UnitGroup.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("unit_groups"))
              .build();
        }
      }
    }
    return getUnitGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.UnitGroup> getUnitGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "unit_group",
      requestType = org.openlca.proto.Proto.Ref.class,
      responseType = org.openlca.proto.Proto.UnitGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref,
      org.openlca.proto.Proto.UnitGroup> getUnitGroupMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.UnitGroup> getUnitGroupMethod;
    if ((getUnitGroupMethod = DataServiceGrpc.getUnitGroupMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getUnitGroupMethod = DataServiceGrpc.getUnitGroupMethod) == null) {
          DataServiceGrpc.getUnitGroupMethod = getUnitGroupMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.Ref, org.openlca.proto.Proto.UnitGroup>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "unit_group"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.UnitGroup.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("unit_group"))
              .build();
        }
      }
    }
    return getUnitGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.openlca.proto.Proto.UnitGroup,
      org.openlca.proto.Proto.Ref> getPutUnitGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "put_unit_group",
      requestType = org.openlca.proto.Proto.UnitGroup.class,
      responseType = org.openlca.proto.Proto.Ref.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.openlca.proto.Proto.UnitGroup,
      org.openlca.proto.Proto.Ref> getPutUnitGroupMethod() {
    io.grpc.MethodDescriptor<org.openlca.proto.Proto.UnitGroup, org.openlca.proto.Proto.Ref> getPutUnitGroupMethod;
    if ((getPutUnitGroupMethod = DataServiceGrpc.getPutUnitGroupMethod) == null) {
      synchronized (DataServiceGrpc.class) {
        if ((getPutUnitGroupMethod = DataServiceGrpc.getPutUnitGroupMethod) == null) {
          DataServiceGrpc.getPutUnitGroupMethod = getPutUnitGroupMethod =
              io.grpc.MethodDescriptor.<org.openlca.proto.Proto.UnitGroup, org.openlca.proto.Proto.Ref>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "put_unit_group"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.UnitGroup.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.openlca.proto.Proto.Ref.getDefaultInstance()))
              .setSchemaDescriptor(new DataServiceMethodDescriptorSupplier("put_unit_group"))
              .build();
        }
      }
    }
    return getPutUnitGroupMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceStub>() {
        @java.lang.Override
        public DataServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceStub(channel, callOptions);
        }
      };
    return DataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceBlockingStub>() {
        @java.lang.Override
        public DataServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceBlockingStub(channel, callOptions);
        }
      };
    return DataServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataServiceFutureStub>() {
        @java.lang.Override
        public DataServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataServiceFutureStub(channel, callOptions);
        }
      };
    return DataServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DataServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * methods for Actor
     * </pre>
     */
    public void actors(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Actor> responseObserver) {
      asyncUnimplementedUnaryCall(getActorsMethod(), responseObserver);
    }

    /**
     */
    public void actor(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Actor> responseObserver) {
      asyncUnimplementedUnaryCall(getActorMethod(), responseObserver);
    }

    /**
     */
    public void putActor(org.openlca.proto.Proto.Actor request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutActorMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for Category
     * </pre>
     */
    public void categorys(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Category> responseObserver) {
      asyncUnimplementedUnaryCall(getCategorysMethod(), responseObserver);
    }

    /**
     */
    public void category(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Category> responseObserver) {
      asyncUnimplementedUnaryCall(getCategoryMethod(), responseObserver);
    }

    /**
     */
    public void putCategory(org.openlca.proto.Proto.Category request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutCategoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for Currency
     * </pre>
     */
    public void currencies(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Currency> responseObserver) {
      asyncUnimplementedUnaryCall(getCurrenciesMethod(), responseObserver);
    }

    /**
     */
    public void currency(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Currency> responseObserver) {
      asyncUnimplementedUnaryCall(getCurrencyMethod(), responseObserver);
    }

    /**
     */
    public void putCurrency(org.openlca.proto.Proto.Currency request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutCurrencyMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for DQSystem
     * </pre>
     */
    public void dqSystems(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.DqSystem> responseObserver) {
      asyncUnimplementedUnaryCall(getDqSystemsMethod(), responseObserver);
    }

    /**
     */
    public void dqSystem(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.DqSystem> responseObserver) {
      asyncUnimplementedUnaryCall(getDqSystemMethod(), responseObserver);
    }

    /**
     */
    public void putDqSystem(org.openlca.proto.Proto.DqSystem request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutDqSystemMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for Flow
     * </pre>
     */
    public void flows(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Flow> responseObserver) {
      asyncUnimplementedUnaryCall(getFlowsMethod(), responseObserver);
    }

    /**
     */
    public void flow(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Flow> responseObserver) {
      asyncUnimplementedUnaryCall(getFlowMethod(), responseObserver);
    }

    /**
     */
    public void putFlow(org.openlca.proto.Proto.Flow request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutFlowMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for FlowProperty
     * </pre>
     */
    public void flowProperties(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.FlowProperty> responseObserver) {
      asyncUnimplementedUnaryCall(getFlowPropertiesMethod(), responseObserver);
    }

    /**
     */
    public void flowProperty(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.FlowProperty> responseObserver) {
      asyncUnimplementedUnaryCall(getFlowPropertyMethod(), responseObserver);
    }

    /**
     */
    public void putFlowProperty(org.openlca.proto.Proto.FlowProperty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutFlowPropertyMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for ImpactCategory
     * </pre>
     */
    public void impactCategories(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ImpactCategory> responseObserver) {
      asyncUnimplementedUnaryCall(getImpactCategoriesMethod(), responseObserver);
    }

    /**
     */
    public void impactCategory(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ImpactCategory> responseObserver) {
      asyncUnimplementedUnaryCall(getImpactCategoryMethod(), responseObserver);
    }

    /**
     */
    public void putImpactCategory(org.openlca.proto.Proto.ImpactCategory request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutImpactCategoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for ImpactMethod
     * </pre>
     */
    public void impactMethods(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ImpactMethod> responseObserver) {
      asyncUnimplementedUnaryCall(getImpactMethodsMethod(), responseObserver);
    }

    /**
     */
    public void impactMethod(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ImpactMethod> responseObserver) {
      asyncUnimplementedUnaryCall(getImpactMethodMethod(), responseObserver);
    }

    /**
     */
    public void putImpactMethod(org.openlca.proto.Proto.ImpactMethod request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutImpactMethodMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for Location
     * </pre>
     */
    public void locations(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Location> responseObserver) {
      asyncUnimplementedUnaryCall(getLocationsMethod(), responseObserver);
    }

    /**
     */
    public void location(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Location> responseObserver) {
      asyncUnimplementedUnaryCall(getLocationMethod(), responseObserver);
    }

    /**
     */
    public void putLocation(org.openlca.proto.Proto.Location request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutLocationMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for Parameter
     * </pre>
     */
    public void parameters(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Parameter> responseObserver) {
      asyncUnimplementedUnaryCall(getParametersMethod(), responseObserver);
    }

    /**
     */
    public void parameter(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Parameter> responseObserver) {
      asyncUnimplementedUnaryCall(getParameterMethod(), responseObserver);
    }

    /**
     */
    public void putParameter(org.openlca.proto.Proto.Parameter request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutParameterMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for Process
     * </pre>
     */
    public void processes(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Process> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessesMethod(), responseObserver);
    }

    /**
     */
    public void process(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Process> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessMethod(), responseObserver);
    }

    /**
     */
    public void putProcess(org.openlca.proto.Proto.Process request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutProcessMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for ProductSystem
     * </pre>
     */
    public void productSystems(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ProductSystem> responseObserver) {
      asyncUnimplementedUnaryCall(getProductSystemsMethod(), responseObserver);
    }

    /**
     */
    public void productSystem(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ProductSystem> responseObserver) {
      asyncUnimplementedUnaryCall(getProductSystemMethod(), responseObserver);
    }

    /**
     */
    public void putProductSystem(org.openlca.proto.Proto.ProductSystem request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutProductSystemMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for Project
     * </pre>
     */
    public void projects(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Project> responseObserver) {
      asyncUnimplementedUnaryCall(getProjectsMethod(), responseObserver);
    }

    /**
     */
    public void project(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Project> responseObserver) {
      asyncUnimplementedUnaryCall(getProjectMethod(), responseObserver);
    }

    /**
     */
    public void putProject(org.openlca.proto.Proto.Project request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutProjectMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for SocialIndicator
     * </pre>
     */
    public void socialIndicators(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.SocialIndicator> responseObserver) {
      asyncUnimplementedUnaryCall(getSocialIndicatorsMethod(), responseObserver);
    }

    /**
     */
    public void socialIndicator(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.SocialIndicator> responseObserver) {
      asyncUnimplementedUnaryCall(getSocialIndicatorMethod(), responseObserver);
    }

    /**
     */
    public void putSocialIndicator(org.openlca.proto.Proto.SocialIndicator request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutSocialIndicatorMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for Source
     * </pre>
     */
    public void sources(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Source> responseObserver) {
      asyncUnimplementedUnaryCall(getSourcesMethod(), responseObserver);
    }

    /**
     */
    public void source(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Source> responseObserver) {
      asyncUnimplementedUnaryCall(getSourceMethod(), responseObserver);
    }

    /**
     */
    public void putSource(org.openlca.proto.Proto.Source request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutSourceMethod(), responseObserver);
    }

    /**
     * <pre>
     * methods for UnitGroup
     * </pre>
     */
    public void unitGroups(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.UnitGroup> responseObserver) {
      asyncUnimplementedUnaryCall(getUnitGroupsMethod(), responseObserver);
    }

    /**
     */
    public void unitGroup(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.UnitGroup> responseObserver) {
      asyncUnimplementedUnaryCall(getUnitGroupMethod(), responseObserver);
    }

    /**
     */
    public void putUnitGroup(org.openlca.proto.Proto.UnitGroup request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnimplementedUnaryCall(getPutUnitGroupMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getActorsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.Actor>(
                  this, METHODID_ACTORS)))
          .addMethod(
            getActorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.Actor>(
                  this, METHODID_ACTOR)))
          .addMethod(
            getPutActorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Actor,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_ACTOR)))
          .addMethod(
            getCategorysMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.Category>(
                  this, METHODID_CATEGORYS)))
          .addMethod(
            getCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.Category>(
                  this, METHODID_CATEGORY)))
          .addMethod(
            getPutCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Category,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_CATEGORY)))
          .addMethod(
            getCurrenciesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.Currency>(
                  this, METHODID_CURRENCIES)))
          .addMethod(
            getCurrencyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.Currency>(
                  this, METHODID_CURRENCY)))
          .addMethod(
            getPutCurrencyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Currency,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_CURRENCY)))
          .addMethod(
            getDqSystemsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.DqSystem>(
                  this, METHODID_DQ_SYSTEMS)))
          .addMethod(
            getDqSystemMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.DqSystem>(
                  this, METHODID_DQ_SYSTEM)))
          .addMethod(
            getPutDqSystemMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.DqSystem,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_DQ_SYSTEM)))
          .addMethod(
            getFlowsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.Flow>(
                  this, METHODID_FLOWS)))
          .addMethod(
            getFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.Flow>(
                  this, METHODID_FLOW)))
          .addMethod(
            getPutFlowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Flow,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_FLOW)))
          .addMethod(
            getFlowPropertiesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.FlowProperty>(
                  this, METHODID_FLOW_PROPERTIES)))
          .addMethod(
            getFlowPropertyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.FlowProperty>(
                  this, METHODID_FLOW_PROPERTY)))
          .addMethod(
            getPutFlowPropertyMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.FlowProperty,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_FLOW_PROPERTY)))
          .addMethod(
            getImpactCategoriesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.ImpactCategory>(
                  this, METHODID_IMPACT_CATEGORIES)))
          .addMethod(
            getImpactCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.ImpactCategory>(
                  this, METHODID_IMPACT_CATEGORY)))
          .addMethod(
            getPutImpactCategoryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.ImpactCategory,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_IMPACT_CATEGORY)))
          .addMethod(
            getImpactMethodsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.ImpactMethod>(
                  this, METHODID_IMPACT_METHODS)))
          .addMethod(
            getImpactMethodMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.ImpactMethod>(
                  this, METHODID_IMPACT_METHOD)))
          .addMethod(
            getPutImpactMethodMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.ImpactMethod,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_IMPACT_METHOD)))
          .addMethod(
            getLocationsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.Location>(
                  this, METHODID_LOCATIONS)))
          .addMethod(
            getLocationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.Location>(
                  this, METHODID_LOCATION)))
          .addMethod(
            getPutLocationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Location,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_LOCATION)))
          .addMethod(
            getParametersMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.Parameter>(
                  this, METHODID_PARAMETERS)))
          .addMethod(
            getParameterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.Parameter>(
                  this, METHODID_PARAMETER)))
          .addMethod(
            getPutParameterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Parameter,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_PARAMETER)))
          .addMethod(
            getProcessesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.Process>(
                  this, METHODID_PROCESSES)))
          .addMethod(
            getProcessMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.Process>(
                  this, METHODID_PROCESS)))
          .addMethod(
            getPutProcessMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Process,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_PROCESS)))
          .addMethod(
            getProductSystemsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.ProductSystem>(
                  this, METHODID_PRODUCT_SYSTEMS)))
          .addMethod(
            getProductSystemMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.ProductSystem>(
                  this, METHODID_PRODUCT_SYSTEM)))
          .addMethod(
            getPutProductSystemMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.ProductSystem,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_PRODUCT_SYSTEM)))
          .addMethod(
            getProjectsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.Project>(
                  this, METHODID_PROJECTS)))
          .addMethod(
            getProjectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.Project>(
                  this, METHODID_PROJECT)))
          .addMethod(
            getPutProjectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Project,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_PROJECT)))
          .addMethod(
            getSocialIndicatorsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.SocialIndicator>(
                  this, METHODID_SOCIAL_INDICATORS)))
          .addMethod(
            getSocialIndicatorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.SocialIndicator>(
                  this, METHODID_SOCIAL_INDICATOR)))
          .addMethod(
            getPutSocialIndicatorMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.SocialIndicator,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_SOCIAL_INDICATOR)))
          .addMethod(
            getSourcesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.Source>(
                  this, METHODID_SOURCES)))
          .addMethod(
            getSourceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.Source>(
                  this, METHODID_SOURCE)))
          .addMethod(
            getPutSourceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Source,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_SOURCE)))
          .addMethod(
            getUnitGroupsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.openlca.proto.services.Services.Empty,
                org.openlca.proto.Proto.UnitGroup>(
                  this, METHODID_UNIT_GROUPS)))
          .addMethod(
            getUnitGroupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.Ref,
                org.openlca.proto.Proto.UnitGroup>(
                  this, METHODID_UNIT_GROUP)))
          .addMethod(
            getPutUnitGroupMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.openlca.proto.Proto.UnitGroup,
                org.openlca.proto.Proto.Ref>(
                  this, METHODID_PUT_UNIT_GROUP)))
          .build();
    }
  }

  /**
   */
  public static final class DataServiceStub extends io.grpc.stub.AbstractAsyncStub<DataServiceStub> {
    private DataServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * methods for Actor
     * </pre>
     */
    public void actors(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Actor> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getActorsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void actor(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Actor> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getActorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putActor(org.openlca.proto.Proto.Actor request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutActorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for Category
     * </pre>
     */
    public void categorys(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Category> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCategorysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void category(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Category> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putCategory(org.openlca.proto.Proto.Category request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for Currency
     * </pre>
     */
    public void currencies(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Currency> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCurrenciesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void currency(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Currency> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCurrencyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putCurrency(org.openlca.proto.Proto.Currency request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutCurrencyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for DQSystem
     * </pre>
     */
    public void dqSystems(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.DqSystem> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getDqSystemsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void dqSystem(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.DqSystem> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDqSystemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putDqSystem(org.openlca.proto.Proto.DqSystem request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutDqSystemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for Flow
     * </pre>
     */
    public void flows(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Flow> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getFlowsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void flow(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Flow> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putFlow(org.openlca.proto.Proto.Flow request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutFlowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for FlowProperty
     * </pre>
     */
    public void flowProperties(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.FlowProperty> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getFlowPropertiesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void flowProperty(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.FlowProperty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFlowPropertyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putFlowProperty(org.openlca.proto.Proto.FlowProperty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutFlowPropertyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for ImpactCategory
     * </pre>
     */
    public void impactCategories(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ImpactCategory> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getImpactCategoriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void impactCategory(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ImpactCategory> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getImpactCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putImpactCategory(org.openlca.proto.Proto.ImpactCategory request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutImpactCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for ImpactMethod
     * </pre>
     */
    public void impactMethods(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ImpactMethod> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getImpactMethodsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void impactMethod(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ImpactMethod> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getImpactMethodMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putImpactMethod(org.openlca.proto.Proto.ImpactMethod request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutImpactMethodMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for Location
     * </pre>
     */
    public void locations(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Location> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLocationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void location(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Location> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLocationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putLocation(org.openlca.proto.Proto.Location request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutLocationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for Parameter
     * </pre>
     */
    public void parameters(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Parameter> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getParametersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void parameter(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Parameter> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getParameterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putParameter(org.openlca.proto.Proto.Parameter request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutParameterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for Process
     * </pre>
     */
    public void processes(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Process> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getProcessesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void process(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Process> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putProcess(org.openlca.proto.Proto.Process request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutProcessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for ProductSystem
     * </pre>
     */
    public void productSystems(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ProductSystem> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getProductSystemsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void productSystem(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ProductSystem> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProductSystemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putProductSystem(org.openlca.proto.Proto.ProductSystem request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutProductSystemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for Project
     * </pre>
     */
    public void projects(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Project> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getProjectsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void project(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Project> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putProject(org.openlca.proto.Proto.Project request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for SocialIndicator
     * </pre>
     */
    public void socialIndicators(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.SocialIndicator> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSocialIndicatorsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void socialIndicator(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.SocialIndicator> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSocialIndicatorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putSocialIndicator(org.openlca.proto.Proto.SocialIndicator request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutSocialIndicatorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for Source
     * </pre>
     */
    public void sources(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Source> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSourcesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void source(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Source> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putSource(org.openlca.proto.Proto.Source request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutSourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * methods for UnitGroup
     * </pre>
     */
    public void unitGroups(org.openlca.proto.services.Services.Empty request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.UnitGroup> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getUnitGroupsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unitGroup(org.openlca.proto.Proto.Ref request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.UnitGroup> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnitGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void putUnitGroup(org.openlca.proto.Proto.UnitGroup request,
        io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPutUnitGroupMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DataServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataServiceBlockingStub> {
    private DataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * methods for Actor
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.Actor> actors(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getActorsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Actor actor(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getActorMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putActor(org.openlca.proto.Proto.Actor request) {
      return blockingUnaryCall(
          getChannel(), getPutActorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for Category
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.Category> categorys(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getCategorysMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Category category(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putCategory(org.openlca.proto.Proto.Category request) {
      return blockingUnaryCall(
          getChannel(), getPutCategoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for Currency
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.Currency> currencies(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getCurrenciesMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Currency currency(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getCurrencyMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putCurrency(org.openlca.proto.Proto.Currency request) {
      return blockingUnaryCall(
          getChannel(), getPutCurrencyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for DQSystem
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.DqSystem> dqSystems(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getDqSystemsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.DqSystem dqSystem(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getDqSystemMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putDqSystem(org.openlca.proto.Proto.DqSystem request) {
      return blockingUnaryCall(
          getChannel(), getPutDqSystemMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for Flow
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.Flow> flows(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getFlowsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Flow flow(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getFlowMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putFlow(org.openlca.proto.Proto.Flow request) {
      return blockingUnaryCall(
          getChannel(), getPutFlowMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for FlowProperty
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.FlowProperty> flowProperties(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getFlowPropertiesMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.FlowProperty flowProperty(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getFlowPropertyMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putFlowProperty(org.openlca.proto.Proto.FlowProperty request) {
      return blockingUnaryCall(
          getChannel(), getPutFlowPropertyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for ImpactCategory
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.ImpactCategory> impactCategories(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getImpactCategoriesMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.ImpactCategory impactCategory(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getImpactCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putImpactCategory(org.openlca.proto.Proto.ImpactCategory request) {
      return blockingUnaryCall(
          getChannel(), getPutImpactCategoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for ImpactMethod
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.ImpactMethod> impactMethods(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getImpactMethodsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.ImpactMethod impactMethod(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getImpactMethodMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putImpactMethod(org.openlca.proto.Proto.ImpactMethod request) {
      return blockingUnaryCall(
          getChannel(), getPutImpactMethodMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for Location
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.Location> locations(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getLocationsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Location location(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getLocationMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putLocation(org.openlca.proto.Proto.Location request) {
      return blockingUnaryCall(
          getChannel(), getPutLocationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for Parameter
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.Parameter> parameters(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getParametersMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Parameter parameter(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getParameterMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putParameter(org.openlca.proto.Proto.Parameter request) {
      return blockingUnaryCall(
          getChannel(), getPutParameterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for Process
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.Process> processes(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getProcessesMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Process process(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getProcessMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putProcess(org.openlca.proto.Proto.Process request) {
      return blockingUnaryCall(
          getChannel(), getPutProcessMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for ProductSystem
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.ProductSystem> productSystems(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getProductSystemsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.ProductSystem productSystem(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getProductSystemMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putProductSystem(org.openlca.proto.Proto.ProductSystem request) {
      return blockingUnaryCall(
          getChannel(), getPutProductSystemMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for Project
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.Project> projects(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getProjectsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Project project(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getProjectMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putProject(org.openlca.proto.Proto.Project request) {
      return blockingUnaryCall(
          getChannel(), getPutProjectMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for SocialIndicator
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.SocialIndicator> socialIndicators(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getSocialIndicatorsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.SocialIndicator socialIndicator(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getSocialIndicatorMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putSocialIndicator(org.openlca.proto.Proto.SocialIndicator request) {
      return blockingUnaryCall(
          getChannel(), getPutSocialIndicatorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for Source
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.Source> sources(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getSourcesMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Source source(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getSourceMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putSource(org.openlca.proto.Proto.Source request) {
      return blockingUnaryCall(
          getChannel(), getPutSourceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * methods for UnitGroup
     * </pre>
     */
    public java.util.Iterator<org.openlca.proto.Proto.UnitGroup> unitGroups(
        org.openlca.proto.services.Services.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getUnitGroupsMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.UnitGroup unitGroup(org.openlca.proto.Proto.Ref request) {
      return blockingUnaryCall(
          getChannel(), getUnitGroupMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.openlca.proto.Proto.Ref putUnitGroup(org.openlca.proto.Proto.UnitGroup request) {
      return blockingUnaryCall(
          getChannel(), getPutUnitGroupMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DataServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DataServiceFutureStub> {
    private DataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Actor> actor(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getActorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putActor(
        org.openlca.proto.Proto.Actor request) {
      return futureUnaryCall(
          getChannel().newCall(getPutActorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Category> category(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putCategory(
        org.openlca.proto.Proto.Category request) {
      return futureUnaryCall(
          getChannel().newCall(getPutCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Currency> currency(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getCurrencyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putCurrency(
        org.openlca.proto.Proto.Currency request) {
      return futureUnaryCall(
          getChannel().newCall(getPutCurrencyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.DqSystem> dqSystem(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getDqSystemMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putDqSystem(
        org.openlca.proto.Proto.DqSystem request) {
      return futureUnaryCall(
          getChannel().newCall(getPutDqSystemMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Flow> flow(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putFlow(
        org.openlca.proto.Proto.Flow request) {
      return futureUnaryCall(
          getChannel().newCall(getPutFlowMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.FlowProperty> flowProperty(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getFlowPropertyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putFlowProperty(
        org.openlca.proto.Proto.FlowProperty request) {
      return futureUnaryCall(
          getChannel().newCall(getPutFlowPropertyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.ImpactCategory> impactCategory(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getImpactCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putImpactCategory(
        org.openlca.proto.Proto.ImpactCategory request) {
      return futureUnaryCall(
          getChannel().newCall(getPutImpactCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.ImpactMethod> impactMethod(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getImpactMethodMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putImpactMethod(
        org.openlca.proto.Proto.ImpactMethod request) {
      return futureUnaryCall(
          getChannel().newCall(getPutImpactMethodMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Location> location(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getLocationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putLocation(
        org.openlca.proto.Proto.Location request) {
      return futureUnaryCall(
          getChannel().newCall(getPutLocationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Parameter> parameter(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getParameterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putParameter(
        org.openlca.proto.Proto.Parameter request) {
      return futureUnaryCall(
          getChannel().newCall(getPutParameterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Process> process(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getProcessMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putProcess(
        org.openlca.proto.Proto.Process request) {
      return futureUnaryCall(
          getChannel().newCall(getPutProcessMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.ProductSystem> productSystem(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getProductSystemMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putProductSystem(
        org.openlca.proto.Proto.ProductSystem request) {
      return futureUnaryCall(
          getChannel().newCall(getPutProductSystemMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Project> project(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getProjectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putProject(
        org.openlca.proto.Proto.Project request) {
      return futureUnaryCall(
          getChannel().newCall(getPutProjectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.SocialIndicator> socialIndicator(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getSocialIndicatorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putSocialIndicator(
        org.openlca.proto.Proto.SocialIndicator request) {
      return futureUnaryCall(
          getChannel().newCall(getPutSocialIndicatorMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Source> source(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getSourceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putSource(
        org.openlca.proto.Proto.Source request) {
      return futureUnaryCall(
          getChannel().newCall(getPutSourceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.UnitGroup> unitGroup(
        org.openlca.proto.Proto.Ref request) {
      return futureUnaryCall(
          getChannel().newCall(getUnitGroupMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.openlca.proto.Proto.Ref> putUnitGroup(
        org.openlca.proto.Proto.UnitGroup request) {
      return futureUnaryCall(
          getChannel().newCall(getPutUnitGroupMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACTORS = 0;
  private static final int METHODID_ACTOR = 1;
  private static final int METHODID_PUT_ACTOR = 2;
  private static final int METHODID_CATEGORYS = 3;
  private static final int METHODID_CATEGORY = 4;
  private static final int METHODID_PUT_CATEGORY = 5;
  private static final int METHODID_CURRENCIES = 6;
  private static final int METHODID_CURRENCY = 7;
  private static final int METHODID_PUT_CURRENCY = 8;
  private static final int METHODID_DQ_SYSTEMS = 9;
  private static final int METHODID_DQ_SYSTEM = 10;
  private static final int METHODID_PUT_DQ_SYSTEM = 11;
  private static final int METHODID_FLOWS = 12;
  private static final int METHODID_FLOW = 13;
  private static final int METHODID_PUT_FLOW = 14;
  private static final int METHODID_FLOW_PROPERTIES = 15;
  private static final int METHODID_FLOW_PROPERTY = 16;
  private static final int METHODID_PUT_FLOW_PROPERTY = 17;
  private static final int METHODID_IMPACT_CATEGORIES = 18;
  private static final int METHODID_IMPACT_CATEGORY = 19;
  private static final int METHODID_PUT_IMPACT_CATEGORY = 20;
  private static final int METHODID_IMPACT_METHODS = 21;
  private static final int METHODID_IMPACT_METHOD = 22;
  private static final int METHODID_PUT_IMPACT_METHOD = 23;
  private static final int METHODID_LOCATIONS = 24;
  private static final int METHODID_LOCATION = 25;
  private static final int METHODID_PUT_LOCATION = 26;
  private static final int METHODID_PARAMETERS = 27;
  private static final int METHODID_PARAMETER = 28;
  private static final int METHODID_PUT_PARAMETER = 29;
  private static final int METHODID_PROCESSES = 30;
  private static final int METHODID_PROCESS = 31;
  private static final int METHODID_PUT_PROCESS = 32;
  private static final int METHODID_PRODUCT_SYSTEMS = 33;
  private static final int METHODID_PRODUCT_SYSTEM = 34;
  private static final int METHODID_PUT_PRODUCT_SYSTEM = 35;
  private static final int METHODID_PROJECTS = 36;
  private static final int METHODID_PROJECT = 37;
  private static final int METHODID_PUT_PROJECT = 38;
  private static final int METHODID_SOCIAL_INDICATORS = 39;
  private static final int METHODID_SOCIAL_INDICATOR = 40;
  private static final int METHODID_PUT_SOCIAL_INDICATOR = 41;
  private static final int METHODID_SOURCES = 42;
  private static final int METHODID_SOURCE = 43;
  private static final int METHODID_PUT_SOURCE = 44;
  private static final int METHODID_UNIT_GROUPS = 45;
  private static final int METHODID_UNIT_GROUP = 46;
  private static final int METHODID_PUT_UNIT_GROUP = 47;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACTORS:
          serviceImpl.actors((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Actor>) responseObserver);
          break;
        case METHODID_ACTOR:
          serviceImpl.actor((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Actor>) responseObserver);
          break;
        case METHODID_PUT_ACTOR:
          serviceImpl.putActor((org.openlca.proto.Proto.Actor) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_CATEGORYS:
          serviceImpl.categorys((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Category>) responseObserver);
          break;
        case METHODID_CATEGORY:
          serviceImpl.category((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Category>) responseObserver);
          break;
        case METHODID_PUT_CATEGORY:
          serviceImpl.putCategory((org.openlca.proto.Proto.Category) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_CURRENCIES:
          serviceImpl.currencies((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Currency>) responseObserver);
          break;
        case METHODID_CURRENCY:
          serviceImpl.currency((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Currency>) responseObserver);
          break;
        case METHODID_PUT_CURRENCY:
          serviceImpl.putCurrency((org.openlca.proto.Proto.Currency) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_DQ_SYSTEMS:
          serviceImpl.dqSystems((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.DqSystem>) responseObserver);
          break;
        case METHODID_DQ_SYSTEM:
          serviceImpl.dqSystem((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.DqSystem>) responseObserver);
          break;
        case METHODID_PUT_DQ_SYSTEM:
          serviceImpl.putDqSystem((org.openlca.proto.Proto.DqSystem) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_FLOWS:
          serviceImpl.flows((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Flow>) responseObserver);
          break;
        case METHODID_FLOW:
          serviceImpl.flow((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Flow>) responseObserver);
          break;
        case METHODID_PUT_FLOW:
          serviceImpl.putFlow((org.openlca.proto.Proto.Flow) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_FLOW_PROPERTIES:
          serviceImpl.flowProperties((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.FlowProperty>) responseObserver);
          break;
        case METHODID_FLOW_PROPERTY:
          serviceImpl.flowProperty((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.FlowProperty>) responseObserver);
          break;
        case METHODID_PUT_FLOW_PROPERTY:
          serviceImpl.putFlowProperty((org.openlca.proto.Proto.FlowProperty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_IMPACT_CATEGORIES:
          serviceImpl.impactCategories((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ImpactCategory>) responseObserver);
          break;
        case METHODID_IMPACT_CATEGORY:
          serviceImpl.impactCategory((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ImpactCategory>) responseObserver);
          break;
        case METHODID_PUT_IMPACT_CATEGORY:
          serviceImpl.putImpactCategory((org.openlca.proto.Proto.ImpactCategory) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_IMPACT_METHODS:
          serviceImpl.impactMethods((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ImpactMethod>) responseObserver);
          break;
        case METHODID_IMPACT_METHOD:
          serviceImpl.impactMethod((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ImpactMethod>) responseObserver);
          break;
        case METHODID_PUT_IMPACT_METHOD:
          serviceImpl.putImpactMethod((org.openlca.proto.Proto.ImpactMethod) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_LOCATIONS:
          serviceImpl.locations((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Location>) responseObserver);
          break;
        case METHODID_LOCATION:
          serviceImpl.location((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Location>) responseObserver);
          break;
        case METHODID_PUT_LOCATION:
          serviceImpl.putLocation((org.openlca.proto.Proto.Location) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_PARAMETERS:
          serviceImpl.parameters((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Parameter>) responseObserver);
          break;
        case METHODID_PARAMETER:
          serviceImpl.parameter((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Parameter>) responseObserver);
          break;
        case METHODID_PUT_PARAMETER:
          serviceImpl.putParameter((org.openlca.proto.Proto.Parameter) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_PROCESSES:
          serviceImpl.processes((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Process>) responseObserver);
          break;
        case METHODID_PROCESS:
          serviceImpl.process((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Process>) responseObserver);
          break;
        case METHODID_PUT_PROCESS:
          serviceImpl.putProcess((org.openlca.proto.Proto.Process) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_PRODUCT_SYSTEMS:
          serviceImpl.productSystems((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ProductSystem>) responseObserver);
          break;
        case METHODID_PRODUCT_SYSTEM:
          serviceImpl.productSystem((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.ProductSystem>) responseObserver);
          break;
        case METHODID_PUT_PRODUCT_SYSTEM:
          serviceImpl.putProductSystem((org.openlca.proto.Proto.ProductSystem) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_PROJECTS:
          serviceImpl.projects((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Project>) responseObserver);
          break;
        case METHODID_PROJECT:
          serviceImpl.project((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Project>) responseObserver);
          break;
        case METHODID_PUT_PROJECT:
          serviceImpl.putProject((org.openlca.proto.Proto.Project) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_SOCIAL_INDICATORS:
          serviceImpl.socialIndicators((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.SocialIndicator>) responseObserver);
          break;
        case METHODID_SOCIAL_INDICATOR:
          serviceImpl.socialIndicator((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.SocialIndicator>) responseObserver);
          break;
        case METHODID_PUT_SOCIAL_INDICATOR:
          serviceImpl.putSocialIndicator((org.openlca.proto.Proto.SocialIndicator) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_SOURCES:
          serviceImpl.sources((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Source>) responseObserver);
          break;
        case METHODID_SOURCE:
          serviceImpl.source((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Source>) responseObserver);
          break;
        case METHODID_PUT_SOURCE:
          serviceImpl.putSource((org.openlca.proto.Proto.Source) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_UNIT_GROUPS:
          serviceImpl.unitGroups((org.openlca.proto.services.Services.Empty) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.UnitGroup>) responseObserver);
          break;
        case METHODID_UNIT_GROUP:
          serviceImpl.unitGroup((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.UnitGroup>) responseObserver);
          break;
        case METHODID_PUT_UNIT_GROUP:
          serviceImpl.putUnitGroup((org.openlca.proto.Proto.UnitGroup) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.openlca.proto.services.Services.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataService");
    }
  }

  private static final class DataServiceFileDescriptorSupplier
      extends DataServiceBaseDescriptorSupplier {
    DataServiceFileDescriptorSupplier() {}
  }

  private static final class DataServiceMethodDescriptorSupplier
      extends DataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataServiceFileDescriptorSupplier())
              .addMethod(getActorsMethod())
              .addMethod(getActorMethod())
              .addMethod(getPutActorMethod())
              .addMethod(getCategorysMethod())
              .addMethod(getCategoryMethod())
              .addMethod(getPutCategoryMethod())
              .addMethod(getCurrenciesMethod())
              .addMethod(getCurrencyMethod())
              .addMethod(getPutCurrencyMethod())
              .addMethod(getDqSystemsMethod())
              .addMethod(getDqSystemMethod())
              .addMethod(getPutDqSystemMethod())
              .addMethod(getFlowsMethod())
              .addMethod(getFlowMethod())
              .addMethod(getPutFlowMethod())
              .addMethod(getFlowPropertiesMethod())
              .addMethod(getFlowPropertyMethod())
              .addMethod(getPutFlowPropertyMethod())
              .addMethod(getImpactCategoriesMethod())
              .addMethod(getImpactCategoryMethod())
              .addMethod(getPutImpactCategoryMethod())
              .addMethod(getImpactMethodsMethod())
              .addMethod(getImpactMethodMethod())
              .addMethod(getPutImpactMethodMethod())
              .addMethod(getLocationsMethod())
              .addMethod(getLocationMethod())
              .addMethod(getPutLocationMethod())
              .addMethod(getParametersMethod())
              .addMethod(getParameterMethod())
              .addMethod(getPutParameterMethod())
              .addMethod(getProcessesMethod())
              .addMethod(getProcessMethod())
              .addMethod(getPutProcessMethod())
              .addMethod(getProductSystemsMethod())
              .addMethod(getProductSystemMethod())
              .addMethod(getPutProductSystemMethod())
              .addMethod(getProjectsMethod())
              .addMethod(getProjectMethod())
              .addMethod(getPutProjectMethod())
              .addMethod(getSocialIndicatorsMethod())
              .addMethod(getSocialIndicatorMethod())
              .addMethod(getPutSocialIndicatorMethod())
              .addMethod(getSourcesMethod())
              .addMethod(getSourceMethod())
              .addMethod(getPutSourceMethod())
              .addMethod(getUnitGroupsMethod())
              .addMethod(getUnitGroupMethod())
              .addMethod(getPutUnitGroupMethod())
              .build();
        }
      }
    }
    return result;
  }
}
