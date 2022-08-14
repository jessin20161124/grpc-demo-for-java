package io.hjfoerver.grpc.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * test controller
 */
@RestController
public class GrpcClientController {

    @Autowired
    private GrpcClientService grpcClientService;

    /**
     * http://localhost:8080/api/user
     * @param userId
     * @return
     */
    @RequestMapping("/api/user")
    public String queryUserName(@RequestParam(defaultValue = "1") Long userId) {
        return grpcClientService.queryUserNameById(userId);
    }

    @RequestMapping("/api/users")
    public List<User> users(@RequestBody List<Long> userIds){
        return grpcClientService.queryUserByIds(userIds);
    }
}
