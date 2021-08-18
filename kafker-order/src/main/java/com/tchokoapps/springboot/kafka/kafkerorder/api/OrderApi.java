package com.tchokoapps.springboot.kafka.kafkerorder.api;

import com.tchokoapps.springboot.kafka.kafkerorder.dtos.request.OrderDtoRequest;
import com.tchokoapps.springboot.kafka.kafkerorder.dtos.response.OrderDtoResponse;
import com.tchokoapps.springboot.kafka.kafkerorder.dtos.response.OrderItemDtoResponse;
import com.tchokoapps.springboot.kafka.kafkerorder.entities.Order;
import com.tchokoapps.springboot.kafka.kafkerorder.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v1/order")
public class OrderApi {

    private OrderService orderService;

    public OrderApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDtoResponse> createOrder(@RequestBody OrderDtoRequest orderRequest) {

        log.info("-- orderRequest --");
        log.info(orderRequest.toString());

        orderRequest.setDateTime(LocalDateTime.now());

        Order orderSaved = orderService.saveOrder(orderRequest);

        OrderDtoResponse orderDtoResponse = new OrderDtoResponse();
        orderDtoResponse.setLocation(orderSaved.getLocation());
        orderDtoResponse.setNumber(orderSaved.getNumber());
        orderDtoResponse.setDateTime(orderSaved.getDateTime());
        orderDtoResponse.setCreditCardNumber(orderSaved.getCreditCardNumber());

        orderDtoResponse.setOrderItemDtoResponses(orderSaved.getOrderItems().stream().map(orderItem -> {

            OrderItemDtoResponse orderItemDtoResponse = new OrderItemDtoResponse();
            orderItemDtoResponse.setName(orderItem.getName());
            orderItemDtoResponse.setPrice(orderItem.getPrice());
            orderItemDtoResponse.setQuantity(orderItem.getQuantity());

            return orderItemDtoResponse;

        }).collect(Collectors.toList()));

        return ResponseEntity.ok().body(orderDtoResponse);
    }
}
