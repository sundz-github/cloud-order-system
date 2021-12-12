package com.cloud.payment;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@Log4j2
@MapperScan(basePackages = {"com.cloud.payment.mapper"})
@EnableHystrix
@EnableCircuitBreaker
public class CloudPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudPaymentApplication.class, args);
        log.info("<------------CloudPaymentApplication is starting------------>");
    }

}
