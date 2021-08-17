package com.tchokoapps.sprigboot.kafka.kafkerorder.dtos.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderItemDtoRequest {

    private String name;

    private int price;

    private int quantity;
}
