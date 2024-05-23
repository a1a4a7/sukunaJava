package com.domain.expansion.message_queue_service.repository;


import com.domain.expansion.message_queue_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
