package cloud.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>  </p>
 *
 * @author Sundz
 * @date 2021/12/25 18:29
 */
@Configuration
public class GateWayConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes().route("order-gateway-id", p -> p.path("/order/**").uri("http://localhost:2020")).build();
    }
}
