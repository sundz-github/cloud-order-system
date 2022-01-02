package com.cloud.order.intercepter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * <p> feign拦截器  给请求添加指定头部  可以用于跨服务传递用户信息 </p>
 *
 * @author Sundz
 * @date 2022/1/2 17:27
 */
@Component
public class FeignIntercepterConfiguration implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("UUID", UUID.randomUUID().toString());
    }
}
