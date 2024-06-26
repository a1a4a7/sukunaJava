package com.domain.expansion.communications_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Communications_serviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Communications_serviceApplication.class, args);
    }
}
