package com.domain.expansion.db_cache_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class DbCacheServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbCacheServiceApplication.class, args);
    }
}
