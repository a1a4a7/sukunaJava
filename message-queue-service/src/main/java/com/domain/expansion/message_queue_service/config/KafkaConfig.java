package com.domain.expansion.message_queue_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic() {
        return new NewTopic("myTopic", 1, (short) 1);
    }
}