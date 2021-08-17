package com.tchokoapps.sprigboot.kafka.kafkerorder.repositories;

import com.tchokoapps.sprigboot.kafka.kafkerorder.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
}
