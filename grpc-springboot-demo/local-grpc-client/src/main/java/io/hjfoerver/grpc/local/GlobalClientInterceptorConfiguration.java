package io.hjfoerver.grpc.local;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 全局客户端拦截器配置
 *
 * @return
 */
@Order(Ordered.LOWEST_PRECEDENCE)
@Configuration
public class GlobalClientInterceptorConfiguration {

//    @Bean
//    public GlobalClientInterceptorConfigurerAdapter globalInterceptorConfigurerAdapter() {
//        return new GlobalClientInterceptorConfigurerAdapter() {
//            @Override
//            public void addClientInterceptors(GlobalClientInterceptorRegistry registry) {
//                registry.addClientInterceptors(new ClientLogGrpcInterceptor());
//            }
//        };
//    }

}