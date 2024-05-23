package com.domain.expansion.message_queue_service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MessageQueueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageQueueServiceApplication.class, args);
    }
}
