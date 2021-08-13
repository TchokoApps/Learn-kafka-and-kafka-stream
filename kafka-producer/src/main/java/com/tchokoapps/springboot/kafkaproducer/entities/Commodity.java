package com.tchokoapps.springboot.kafkaproducer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Commodity {
    private String name;
    private double price;
    private String measurement;
    private long timestamp;
}
