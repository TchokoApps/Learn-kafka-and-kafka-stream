package com.tchokoapps.sprigboot.kafka.kafkerorder.services;

import com.tchokoapps.sprigboot.kafka.kafkerorder.broker.messages.OrderItemKafkaMessage;
import com.tchokoapps.sprigboot.kafka.kafkerorder.broker.messages.OrderKafkaMessage;
import com.tchokoapps.sprigboot.kafka.kafkerorder.broker.producers.OrderProducer;
import com.tchokoapps.sprigboot.kafka.kafkerorder.dtos.request.OrderDtoRequest;
import com.tchokoapps.sprigboot.kafka.kafkerorder.entities.Order;
import com.tchokoapps.sprigboot.kafka.kafkerorder.entities.OrderItem;
import com.tchokoapps.sprigboot.kafka.kafkerorder.repositories.OrderRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private OrderProducer orderProducer;

    public OrderService(OrderRepository orderRepository, OrderProducer orderProducer) {
        this.orderRepository = orderRepository;
        this.orderProducer = orderProducer;
    }

    public Order saveOrder(OrderDtoRequest orderDtoRequest) {

        List<OrderItem> orderItems = orderDtoRequest.getOrderItemDtoRequests().stream().map(orderItemDtoRequest -> {
            OrderItem.OrderItemBuilder builder = OrderItem.builder();
            builder.name(orderItemDtoRequest.getName());
            builder.price(orderItemDtoRequest.getPrice());
            builder.quantity(orderItemDtoRequest.getQuantity());
            return builder.build();
        }).collect(Collectors.toList());

        Order order = Order.builder()
                .creditCardNumber(orderDtoRequest.getCreditCardNumber())
                .dateTime(LocalDateTime.now())
                .location(orderDtoRequest.getLocation())
                .number(RandomStringUtils.randomAlphanumeric(8).toUpperCase())
                .orderItems(orderItems)
                .build();

        order.setOrderItems(orderItems);

        Order orderSaved = orderRepository.save(order);

        OrderKafkaMessage orderKafkaMessage = new OrderKafkaMessage();
        orderKafkaMessage.setCreditCardNumber(orderSaved.getCreditCardNumber());
        orderKafkaMessage.setDateTime(orderSaved.getDateTime());
        orderKafkaMessage.setLocation(orderSaved.getLocation());
        orderKafkaMessage.setNumber(orderSaved.getNumber());

        List<OrderItemKafkaMessage> orderItemKafkaMessages = orderSaved.getOrderItems().stream().map(orderItem -> {
            OrderItemKafkaMessage orderItemMessage = new OrderItemKafkaMessage();
            orderItemMessage.setName(orderItem.getName());
            orderItemMessage.setPrice(orderItem.getPrice());
            orderItemMessage.setQuantity(orderItem.getQuantity());
            return orderItemMessage;
        }).collect(Collectors.toList());

        orderKafkaMessage.setOrderItemMessages(orderItemKafkaMessages);

        orderProducer.publish(orderKafkaMessage);

        return order;
    }
}
