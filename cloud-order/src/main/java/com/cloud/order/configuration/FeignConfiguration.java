package com.cloud.order.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * <p> 该配置类不需要加Configuration 否则将会被全局共享 </p>
 *
 * @author Sundz
 * @date 2022/1/2 16:49
 */
public class FeignConfiguration {

    @Bean
    public Logger.Level level(){
        return Logger.Level.BASIC;
    }
}
