package com.domain.expansion.api_gateway_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Api_gateway_serviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Api_gateway_serviceApplication.class, args);
    }
}
