package com.tchokoapps.springboot.kafka.kafkerorder.repositories;

import com.tchokoapps.springboot.kafka.kafkerorder.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
}
