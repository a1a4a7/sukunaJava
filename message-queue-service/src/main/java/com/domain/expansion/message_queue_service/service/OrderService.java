package com.domain.expansion.message_queue_service.service;

import com.domain.expansion.message_queue_service.model.Order;
import com.domain.expansion.message_queue_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RedisTemplate<String, Order> orderRedisTemplate;

    public void processOrder(Order order) {
        // 处理订单逻辑，例如支付验证、库存检查等
        order.setStatus("completed");

        // 更新数据库中的订单状态
        orderRepository.save(order);

        // 将订单信息保存到 Redis 缓存中
        saveOrderToCache(order);
    }

    public void saveOrderToCache(Order order) {
        orderRedisTemplate.opsForValue().set("order:" + order.getId(), order);
    }
}
