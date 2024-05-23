package com.domain.expansion.message_queue_service.listener;

import com.domain.expansion.message_queue_service.model.Order;
import com.domain.expansion.message_queue_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderListener {

    @Autowired
    private OrderService orderService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "orders", groupId = "myGroup")
    public void listen(String message) {
        try {
            Order order = objectMapper.readValue(message, Order.class);
            orderService.processOrder(order);
        } catch (Exception e) {
            // 记录或处理错误
            e.printStackTrace();
        }
    }
}
