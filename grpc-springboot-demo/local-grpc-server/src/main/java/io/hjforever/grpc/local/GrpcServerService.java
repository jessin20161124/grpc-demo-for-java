package io.hjforever.grpc.local;

import io.grpc.stub.StreamObserver;
import io.hjforever.grpc.user.UserGrpc;
import io.hjforever.grpc.user.UserReply;
import io.hjforever.grpc.user.UserRequest;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * user service
 */
@GrpcService
public class GrpcServerService extends UserGrpc.UserImplBase {

    Logger logger = LoggerFactory.getLogger(GrpcServerService.class);

    Random random = new Random();
    @Override
    public void queryUserById(UserRequest userRequest, StreamObserver<UserReply> responseObserver) {

        logger.info("请求参数为: {}", userRequest);

        Long userId = userRequest.getUserId();

        UserReply userReply = UserReply.newBuilder().setUserId(userId).setName("mike" + userId).setAge(18).build();
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(8));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        responseObserver.onNext(userReply);

        responseObserver.onCompleted();
        logger.info("请求参数为: {}，响应", userRequest);

    }


    @Override
    public StreamObserver<UserRequest> queryUserIds(final StreamObserver<UserReply> streamObserver) {

        return new StreamObserver<UserRequest>() {
            @Override
            public void onNext(UserRequest userRequest) {
                logger.info("user request is : {}", userRequest);
                /**
                 * 根据 userRequest 查询对应的 userReply
                 */
                UserReply userReply = UserReply.newBuilder()
                        .setName("mike"+userRequest.getUserId())
                        .setAge(18)
                        .setUserId(userRequest.getUserId())
                        .build();
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
}
