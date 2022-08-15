package io.hjforever.grpc.user;

import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * user server
 *
 * @author hjforever
 */
public class UserServer {

    private static final Logger logger = LoggerFactory.getLogger(UserServer.class);

    private Server server;

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final UserServer server = new UserServer();
        server.start();
        server.blockUntilShutdown();
    }

    private void start() throws IOException {
    /* The port on which the server should run */
        int port = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new UserImpl())
            // 允许客户端在没有调用时（没有header/data）发起心跳
            .permitKeepAliveWithoutCalls(true)
            // 允许客户端发起心跳间隔的最低时间，也就是客户端至少是10s
            .permitKeepAliveTime(10, TimeUnit.SECONDS)
            .build()
            .start();

        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                UserServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    static class UserImpl extends UserGrpc.UserImplBase {

        @Override
        public void queryUserByIds(UserRequest userRequest, StreamObserver<UserReply> stream) {
            Long userId = userRequest.getUserId();
            Map<Integer, String> data = userRequest.getDataMap();
            UserInfo userInfo;
            try {
                userInfo = userRequest.getObj().unpack(UserInfo.class);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }

            logger.info("query user by id : {}, data:{}, userInfo is {}, struct is:{}",
                userId, data, userInfo, userRequest.getSt().getFieldsMap());
            //模拟查询数据
            for (int i = 0; i < 10; i++) {
                UserReply userReply = UserReply.newBuilder().setUserId(i + 1).setAge(i + 1).setName("测试" + i).build();
                stream.onNext(userReply);
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            stream.onCompleted();
        }


        @Override
        public StreamObserver<UserRequest> queryUserByName(final StreamObserver<UserReply> streamObserver) {

            return new StreamObserver<UserRequest>() {
                @Override
                public void onNext(UserRequest userRequest) {
                    logger.info("user request is : {}", userRequest);

                    /**
                     * 根据 userRequest 查询对应的 userReply
                     */
                    UserReply userReply = UserReply.newBuilder()
                            .setName(userRequest.getName())
                            .setAge(18)
                            .setUserId(userRequest.getUserId())
                            .build();
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    streamObserver.onNext(userReply);

                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onCompleted() {
                    streamObserver.onCompleted();
                }
            };
        }

        @Override
        public StreamObserver<UserRequest> queryLastUsers(final StreamObserver<UserReply> userReplyStreamObserver) {

            /**
             *
             * 此处主要模拟接收客户端 UserRequest 流，然后返回 UserReply
             *
             */
            return new StreamObserver<UserRequest>() {

                //缓存 UserRequest 流
                List<UserRequest> users = new ArrayList<UserRequest>();

                @Override
                public void onNext(UserRequest value) {
                    users.add(value);
                }

                @Override
                public void onError(Throwable t) {

                }

                @Override
                public void onCompleted() {
                    //获取最后一条用户
                    UserRequest lastUser = users.get(users.size() - 1);
                    UserReply userReply = UserReply.newBuilder().setUserId(lastUser.getUserId())
                            .setAge(18).setName(lastUser.getName())
                            .build();
                    /**
                     * userReplyStreamObserver 必须为final 具体参考java语法
                     */
                    userReplyStreamObserver.onNext(userReply);
                    userReplyStreamObserver.onCompleted();
                }
            };
        }

    }
}
