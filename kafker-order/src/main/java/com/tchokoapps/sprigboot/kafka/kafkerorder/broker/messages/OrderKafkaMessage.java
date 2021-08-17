package com.tchokoapps.sprigboot.kafka.kafkerorder.broker.messages;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tchokoapps.sprigboot.kafka.kafkerorder.utils.LocalDateTimeDeserializer;
import com.tchokoapps.sprigboot.kafka.kafkerorder.utils.LocalDateTimeSerializer;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderKafkaMessage {

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateTime;

    private String number;

    private String location;

    private String creditCardNumber;

    private List<OrderItemKafkaMessage> orderItemMessages;
}
