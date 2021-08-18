package com.tchokoapps.springboot.kafka.kafkerorder.kafka.messages;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderItemKafkaMessage {

    private String name;

    private int price;

    private int quantity;

}
