package com.tchokoapps.springboot.kafka.kafkerorder.dtos.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tchokoapps.springboot.kafka.kafkerorder.utils.LocalDateTimeDeserializer;
import com.tchokoapps.springboot.kafka.kafkerorder.utils.LocalDateTimeSerializer;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDtoRequest {

    private String location;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateTime;

    private String creditCardNumber;

    private List<OrderItemDtoRequest> orderItemDtoRequests;

}
