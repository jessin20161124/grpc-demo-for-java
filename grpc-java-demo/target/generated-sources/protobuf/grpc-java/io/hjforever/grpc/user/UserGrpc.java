package io.hjforever.grpc.user;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The user service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.48.1)",
    comments = "Source: user.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserGrpc {

  private UserGrpc() {}

  public static final String SERVICE_NAME = "user.User";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.hjforever.grpc.user.UserRequest,
      io.hjforever.grpc.user.UserReply> getQueryUserByNameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryUserByName",
      requestType = io.hjforever.grpc.user.UserRequest.class,
      responseType = io.hjforever.grpc.user.UserReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<io.hjforever.grpc.user.UserRequest,
      io.hjforever.grpc.user.UserReply> getQueryUserByNameMethod() {
    io.grpc.MethodDescriptor<io.hjforever.grpc.user.UserRequest, io.hjforever.grpc.user.UserReply> getQueryUserByNameMethod;
    if ((getQueryUserByNameMethod = UserGrpc.getQueryUserByNameMethod) == null) {
      synchronized (UserGrpc.class) {
        if ((getQueryUserByNameMethod = UserGrpc.getQueryUserByNameMethod) == null) {
          UserGrpc.getQueryUserByNameMethod = getQueryUserByNameMethod =
              io.grpc.MethodDescriptor.<io.hjforever.grpc.user.UserRequest, io.hjforever.grpc.user.UserReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryUserByName"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.hjforever.grpc.user.UserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.hjforever.grpc.user.UserReply.getDefaultInstance()))
              .setSchemaDescriptor(new UserMethodDescriptorSupplier("QueryUserByName"))
              .build();
        }
      }
    }
    return getQueryUserByNameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.hjforever.grpc.user.UserRequest,
      io.hjforever.grpc.user.UserReply> getQueryUserByIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryUserByIds",
      requestType = io.hjforever.grpc.user.UserRequest.class,
      responseType = io.hjforever.grpc.user.UserReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.hjforever.grpc.user.UserRequest,
      io.hjforever.grpc.user.UserReply> getQueryUserByIdsMethod() {
    io.grpc.MethodDescriptor<io.hjforever.grpc.user.UserRequest, io.hjforever.grpc.user.UserReply> getQueryUserByIdsMethod;
    if ((getQueryUserByIdsMethod = UserGrpc.getQueryUserByIdsMethod) == null) {
      synchronized (UserGrpc.class) {
        if ((getQueryUserByIdsMethod = UserGrpc.getQueryUserByIdsMethod) == null) {
          UserGrpc.getQueryUserByIdsMethod = getQueryUserByIdsMethod =
              io.grpc.MethodDescriptor.<io.hjforever.grpc.user.UserRequest, io.hjforever.grpc.user.UserReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryUserByIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.hjforever.grpc.user.UserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.hjforever.grpc.user.UserReply.getDefaultInstance()))
              .setSchemaDescriptor(new UserMethodDescriptorSupplier("QueryUserByIds"))
              .build();
        }
      }
    }
    return getQueryUserByIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.hjforever.grpc.user.UserRequest,
      io.hjforever.grpc.user.UserReply> getQueryLastUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryLastUsers",
      requestType = io.hjforever.grpc.user.UserRequest.class,
      responseType = io.hjforever.grpc.user.UserReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<io.hjforever.grpc.user.UserRequest,
      io.hjforever.grpc.user.UserReply> getQueryLastUsersMethod() {
    io.grpc.MethodDescriptor<io.hjforever.grpc.user.UserRequest, io.hjforever.grpc.user.UserReply> getQueryLastUsersMethod;
    if ((getQueryLastUsersMethod = UserGrpc.getQueryLastUsersMethod) == null) {
      synchronized (UserGrpc.class) {
        if ((getQueryLastUsersMethod = UserGrpc.getQueryLastUsersMethod) == null) {
          UserGrpc.getQueryLastUsersMethod = getQueryLastUsersMethod =
              io.grpc.MethodDescriptor.<io.hjforever.grpc.user.UserRequest, io.hjforever.grpc.user.UserReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryLastUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.hjforever.grpc.user.UserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.hjforever.grpc.user.UserReply.getDefaultInstance()))
              .setSchemaDescriptor(new UserMethodDescriptorSupplier("QueryLastUsers"))
              .build();
        }
      }
    }
    return getQueryLastUsersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserStub>() {
        @java.lang.Override
        public UserStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserStub(channel, callOptions);
        }
      };
    return UserStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserBlockingStub>() {
        @java.lang.Override
        public UserBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserBlockingStub(channel, callOptions);
        }
      };
    return UserBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserFutureStub>() {
        @java.lang.Override
        public UserFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserFutureStub(channel, callOptions);
        }
      };
    return UserFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The user service definition.
   * </pre>
   */
  public static abstract class UserImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *双向流 （流是可以多次）
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserRequest> queryUserByName(
        io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserReply> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getQueryUserByNameMethod(), responseObserver);
    }

    /**
     * <pre>
     * 服务端 to 客户端  ， 服务端接收客户端UserRequest请求 返回 UserReply 流 （多次）
     * </pre>
     */
    public void queryUserByIds(io.hjforever.grpc.user.UserRequest request,
        io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getQueryUserByIdsMethod(), responseObserver);
    }

    /**
     * <pre>
     * 客户端 to 服务端 流 ，客户端发送 UserRequest 流 （多次），服务端接收后返回 UserReply
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserRequest> queryLastUsers(
        io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserReply> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getQueryLastUsersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getQueryUserByNameMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                io.hjforever.grpc.user.UserRequest,
                io.hjforever.grpc.user.UserReply>(
                  this, METHODID_QUERY_USER_BY_NAME)))
          .addMethod(
            getQueryUserByIdsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                io.hjforever.grpc.user.UserRequest,
                io.hjforever.grpc.user.UserReply>(
                  this, METHODID_QUERY_USER_BY_IDS)))
          .addMethod(
            getQueryLastUsersMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                io.hjforever.grpc.user.UserRequest,
                io.hjforever.grpc.user.UserReply>(
                  this, METHODID_QUERY_LAST_USERS)))
          .build();
    }
  }

  /**
   * <pre>
   * The user service definition.
   * </pre>
   */
  public static final class UserStub extends io.grpc.stub.AbstractAsyncStub<UserStub> {
    private UserStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserStub(channel, callOptions);
    }

    /**
     * <pre>
     *双向流 （流是可以多次）
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserRequest> queryUserByName(
        io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserReply> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getQueryUserByNameMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * 服务端 to 客户端  ， 服务端接收客户端UserRequest请求 返回 UserReply 流 （多次）
     * </pre>
     */
    public void queryUserByIds(io.hjforever.grpc.user.UserRequest request,
        io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getQueryUserByIdsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 客户端 to 服务端 流 ，客户端发送 UserRequest 流 （多次），服务端接收后返回 UserReply
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserRequest> queryLastUsers(
        io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserReply> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getQueryLastUsersMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * The user service definition.
   * </pre>
   */
  public static final class UserBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserBlockingStub> {
    private UserBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 服务端 to 客户端  ， 服务端接收客户端UserRequest请求 返回 UserReply 流 （多次）
     * </pre>
     */
    public java.util.Iterator<io.hjforever.grpc.user.UserReply> queryUserByIds(
        io.hjforever.grpc.user.UserRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getQueryUserByIdsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The user service definition.
   * </pre>
   */
  public static final class UserFutureStub extends io.grpc.stub.AbstractFutureStub<UserFutureStub> {
    private UserFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_QUERY_USER_BY_IDS = 0;
  private static final int METHODID_QUERY_USER_BY_NAME = 1;
  private static final int METHODID_QUERY_LAST_USERS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY_USER_BY_IDS:
          serviceImpl.queryUserByIds((io.hjforever.grpc.user.UserRequest) request,
              (io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserReply>) responseObserver);
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
        case METHODID_QUERY_USER_BY_NAME:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.queryUserByName(
              (io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserReply>) responseObserver);
        case METHODID_QUERY_LAST_USERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.queryLastUsers(
              (io.grpc.stub.StreamObserver<io.hjforever.grpc.user.UserReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.hjforever.grpc.user.UserProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("User");
    }
  }

  private static final class UserFileDescriptorSupplier
      extends UserBaseDescriptorSupplier {
    UserFileDescriptorSupplier() {}
  }

  private static final class UserMethodDescriptorSupplier
      extends UserBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserFileDescriptorSupplier())
              .addMethod(getQueryUserByNameMethod())
              .addMethod(getQueryUserByIdsMethod())
              .addMethod(getQueryLastUsersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
