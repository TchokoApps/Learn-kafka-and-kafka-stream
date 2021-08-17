package com.tchokoapps.sprigboot.kafka.kafkerorder.broker.messages;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderMessage {

    private String creditCardNumber;
    private String itemName;
    private LocalDateTime orderDateTime;
    private String orderLocation;
    private String orderNumber;
    private String price;
    private int quantity;
}
