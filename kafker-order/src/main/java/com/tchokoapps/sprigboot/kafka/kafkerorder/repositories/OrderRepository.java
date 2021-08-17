package com.tchokoapps.sprigboot.kafka.kafkerorder.repositories;

import com.tchokoapps.sprigboot.kafka.kafkerorder.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
