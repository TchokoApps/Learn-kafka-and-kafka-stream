package com.tchokoapps.springboot.kafka.kafkerorder.repositories;

import com.tchokoapps.springboot.kafka.kafkerorder.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
