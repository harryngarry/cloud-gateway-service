package com.iboss.cgs.Config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/user/**")
                		//.filters(f -> f.hystrix(h -> h.setName("CircuitBreaker")
                		//		.setFallbackUri("forward:/userFallBack")))
                        .uri("http://localhost:9191")
                        .id("user-service"))

                .route(r -> r.path("/account/**")
                		//.filters(f -> f.hystrix(h -> h.setName("CircuitBreaker")
                		//		.setFallbackUri("forward:/accountFallback")))
                        .uri("http://localhost:9192")
                        .id("account-service"))
                .build();
    }

}
