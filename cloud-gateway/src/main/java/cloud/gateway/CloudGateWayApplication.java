package cloud.gateway;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/19 21:30
 */
@SpringBootApplication()
@Log4j2
@EnableEurekaClient
public class CloudGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGateWayApplication.class, args);
        log.info("<------------CloudGateWayApplication is starting------------>");
    }
}
