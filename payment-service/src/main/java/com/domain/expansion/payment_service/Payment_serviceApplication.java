package com.domain.expansion.payment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment_serviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Payment_serviceApplication.class, args);
    }
}
