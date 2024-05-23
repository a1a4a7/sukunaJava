package com.domain.expansion.order_service.service;

import com.domain.expansion.order_service.model.Order;
import com.domain.expansion.order_service.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private RedisTemplate<String, Order> orderRedisTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Order createOrder(Order order) {
        order.setStatus("processing");
        orderRepository.save(order);
        try {
            String orderJson = objectMapper.writeValueAsString(order);
            kafkaTemplate.send("orders", orderJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    public void saveOrderToCache(Order order) {
        orderRedisTemplate.opsForValue().set("order:" + order.getId(), order);
    }
}
