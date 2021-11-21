package com.cloud.score;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@Log4j2
public class CloudScoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudScoreApplication.class, args);
        log.info("<------------CloudScoreApplication is starting------------>");
    }

}
