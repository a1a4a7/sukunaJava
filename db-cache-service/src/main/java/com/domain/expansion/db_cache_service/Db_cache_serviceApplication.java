package com.domain.expansion.db_cache_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Db_cache_serviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Db_cache_serviceApplication.class, args);
    }
}
