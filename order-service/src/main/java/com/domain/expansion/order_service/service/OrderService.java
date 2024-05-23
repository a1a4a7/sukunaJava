package com.domain.expansion.order_service.service;

import com.domain.expansion.order_service.model.Order;
import com.domain.expansion.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Order createOrder(Order order) {
        order.setStatus("processing");
        orderRepository.save(order);
        kafkaTemplate.send("orders", order.toString());
        return order;
    }
}
