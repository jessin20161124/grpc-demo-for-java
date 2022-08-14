package io.hjforever.grpc.user;

import com.google.protobuf.Any;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 * https://github.com/grpc/grpc-java/tree/v1.48.1/examples/src/main/java/io/grpc/
 *
 * http://doc.oschina.net/grpc?t=60134
 *
 * @author hjforever
 */
public class UserClient {

    private static final Logger logger = LoggerFactory.getLogger(UserClient.class);

    private final ManagedChannel channel;

    //阻塞
    private final UserGrpc.UserBlockingStub blockingStub;
    //异步
    private final UserGrpc.UserStub asyncStub;


    public UserClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                /**
                 *
                 * 此处将设为文本连接,只用于测试
                 *
                 */
                .usePlaintext()
            // 好像会自动重连？？
            // 心跳多久没回复算超时
            .keepAliveTimeout(30, TimeUnit.SECONDS)
            // 心跳间隔
            .keepAliveTime(15, TimeUnit.SECONDS)
            .keepAliveWithoutCalls(true)
            // 消息体大小？？byte
            .maxInboundMessageSize(1000)
            .intercept(new ClientLogGrpcInterceptor())
                .build());
    }


    UserClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = UserGrpc.newBlockingStub(channel);
        asyncStub = UserGrpc.newStub(channel);
    }


    public static void main(String[] args) throws Exception {

        UserClient client = new UserClient("localhost", 50051);
        try {
            client.queryUserByIds();
            client.queryUserByName();
            TimeUnit.SECONDS.sleep(10000);
        } finally {
            client.shutdown();
        }
    }


    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void queryUserByIds() {
        Value numberValue = Value.newBuilder().setNumberValue(1.125).build();

        com.google.protobuf.Struct st = Struct.newBuilder().putFields("key", numberValue).build();
        UserInfo userInfo = UserInfo.newBuilder().setName("xiaoming").setAge(10).build();
        UserRequest userRequest = UserRequest.newBuilder().setUserId(1L)
                .putData(1, "hello")
            .putData(2, "abc")
            .setObj(Any.pack(userInfo))
//            .setObj(Any.pack(Int32Value.newBuilder().setValue(123).build()))
            .setSt(st)
            .build();
        //blockingStub.withDeadlineAfter()
        //blockingStub.withInterceptors();
        Iterator<UserReply> users = blockingStub.queryUserByIds(userRequest);
        for (int i = 0; users.hasNext(); i++) {
            UserReply userReply = users.next();
            logger.info("user id is : {} , user name is :{},user age is {}", userReply.getUserId(), userReply.getName(), userReply.getAge());
        }
    }

    public void queryUserByName() throws InterruptedException {

        //只有当流结束或者发生异常时才终止,不然就一直等待，可以在调用时判断时间防止一直等待
        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<UserRequest> userRequestStreamObserver = asyncStub.queryUserByName(new StreamObserver<UserReply>() {

            @Override
            public void onNext(UserReply value) {
                logger.info("get user id is :{} , name is :{} , age is :{}", value.getUserId(), value.getName(), value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                logger.error("error:", t);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                logger.info("query user by name finished!!");
                finishLatch.countDown();
            }
        });

        /**
         * 设置 UserRequest 请求流
         */
        for (int i = 0; i < 10; i++) {
            UserRequest userRequest = UserRequest.newBuilder().setUserId(i + 1).setName("user" + i).build();
            userRequestStreamObserver.onNext(userRequest);
        }
        userRequestStreamObserver.onCompleted();

        /**
         * 阻塞直到结束，建议加上超时时间 eg : finishLatch.await(1,TimeUnit.SECONDS)
         */
        finishLatch.await();

    }

}
