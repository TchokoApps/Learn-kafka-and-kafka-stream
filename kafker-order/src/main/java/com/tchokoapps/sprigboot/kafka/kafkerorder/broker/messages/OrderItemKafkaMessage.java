package com.tchokoapps.sprigboot.kafka.kafkerorder.broker.messages;

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
