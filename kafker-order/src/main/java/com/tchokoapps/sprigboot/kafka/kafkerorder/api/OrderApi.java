package com.tchokoapps.sprigboot.kafka.kafkerorder.api;

import com.tchokoapps.sprigboot.kafka.kafkerorder.dtos.request.OrderDtoRequest;
import com.tchokoapps.sprigboot.kafka.kafkerorder.dtos.response.OrderDtoResponse;
import com.tchokoapps.sprigboot.kafka.kafkerorder.entities.Order;
import com.tchokoapps.sprigboot.kafka.kafkerorder.services.OrderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderApi {

    private OrderService orderService;

    public OrderApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDtoResponse> createOrder(@RequestBody OrderDtoRequest orderRequest) {

        Order orderSaved = orderService.saveOrder(orderRequest);

        OrderDtoResponse orderDtoResponse = new OrderDtoResponse(orderSaved.getNumber());

        return ResponseEntity.ok().body(orderDtoResponse);

    }
}
