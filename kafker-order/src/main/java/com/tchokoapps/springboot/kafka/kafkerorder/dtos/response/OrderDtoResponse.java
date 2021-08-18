package com.tchokoapps.springboot.kafka.kafkerorder.dtos.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDtoResponse {

    private String number;

    private String location;

    private LocalDateTime dateTime;

    private String creditCardNumber;

    private List<OrderItemDtoResponse> orderItemDtoResponses;
}
