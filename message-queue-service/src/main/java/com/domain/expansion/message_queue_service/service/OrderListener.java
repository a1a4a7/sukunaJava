package com.domain.expansion.message_queue_service.service;

import com.domain.expansion.message_queue_service.model.Order;
import com.domain.expansion.message_queue_service.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {

    @Autowired
    private OrderRepository orderRepository;

    @KafkaListener(topics = "orders", groupId = "order-group")
    public void listen(String message) {
        // 将消息转换为订单对象
        Order order = convertMessageToOrder(message);
        // 更新订单状态
        order.setStatus("completed");
        // 保存订单
        orderRepository.save(order);
    }

    private Order convertMessageToOrder(String message) {
        // 实现消息转换逻辑
        // 示例：假设消息是 JSON 格式
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(message, Order.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert message to order", e);
        }
    }
}
