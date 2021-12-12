package com.cloud.order.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/11 18:25
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }

}
