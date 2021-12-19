package com.cloud.order.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/4 19:10
 */
@Configuration
public class BeanConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    /*@Bean
    public ServletListenerRegistrationBean<RequestContextListener> requestContextListener(){
        ServletListenerRegistrationBean<RequestContextListener> bean = new ServletListenerRegistrationBean<>(new RequestContextListener());
        return bean;
    }*/

}
