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

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
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
  }

  private static final int METHODID_ACTOR = 0;
  private static final int METHODID_PUT_ACTOR = 1;
  private static final int METHODID_FLOW = 2;
  private static final int METHODID_PUT_FLOW = 3;

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
        case METHODID_ACTOR:
          serviceImpl.actor((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Actor>) responseObserver);
          break;
        case METHODID_PUT_ACTOR:
          serviceImpl.putActor((org.openlca.proto.Proto.Actor) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Ref>) responseObserver);
          break;
        case METHODID_FLOW:
          serviceImpl.flow((org.openlca.proto.Proto.Ref) request,
              (io.grpc.stub.StreamObserver<org.openlca.proto.Proto.Flow>) responseObserver);
          break;
        case METHODID_PUT_FLOW:
          serviceImpl.putFlow((org.openlca.proto.Proto.Flow) request,
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
              .addMethod(getActorMethod())
              .addMethod(getPutActorMethod())
              .addMethod(getFlowMethod())
              .addMethod(getPutFlowMethod())
              .build();
        }
      }
    }
    return result;
  }
}
