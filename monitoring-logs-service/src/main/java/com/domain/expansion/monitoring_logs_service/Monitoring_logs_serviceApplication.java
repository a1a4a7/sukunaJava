package com.domain.expansion.monitoring_logs_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Monitoring_logs_serviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Monitoring_logs_serviceApplication.class, args);
    }
}
