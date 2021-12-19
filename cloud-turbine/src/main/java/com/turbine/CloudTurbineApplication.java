package com.turbine;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/19 16:05
 */
@SpringBootApplication
@EnableEurekaClient
@EnableTurbine
@Log4j2
@EnableHystrixDashboard
public class CloudTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudTurbineApplication.class, args);
        log.info("<------------CloudTurbineApplication is starting------------>");
    }
}
