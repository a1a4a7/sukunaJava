package com.domain.expansion.docs_testing_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Docs_testing_serviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Docs_testing_serviceApplication.class, args);
    }
}
