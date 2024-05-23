package com.domain.expansion.api_gateway_service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r.path("/auth/**")
                        .uri("lb://auth-service"))
                .route("db-cache-service", r -> r.path("/db/**")
                        .uri("lb://db-cache-service"))
                .route("order-service", r -> r.path("/order/**")
                        .uri("lb://order-service"))
                .build();
    }
}
