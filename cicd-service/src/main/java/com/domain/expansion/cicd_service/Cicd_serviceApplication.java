package com.domain.expansion.cicd_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Cicd_serviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Cicd_serviceApplication.class, args);
    }
}
