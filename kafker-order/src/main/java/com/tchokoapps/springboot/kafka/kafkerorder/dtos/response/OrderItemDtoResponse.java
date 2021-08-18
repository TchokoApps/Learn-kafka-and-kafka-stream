package com.tchokoapps.springboot.kafka.kafkerorder.dtos.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderItemDtoResponse {

    private String name;

    private int price;

    private int quantity;
}
