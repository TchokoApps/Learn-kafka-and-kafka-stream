package com.tchokoapps.springboot.kafka.kafkapatternconsumer.kafka;

import com.tchokoapps.springboot.kafka.kafkerorder.kafka.messages.OrderKafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderListener {

    @KafkaListener(topics = "t.commodity.order")
    public void listen(OrderKafkaMessage orderKafkaMessage) {
        log.info("Message Received: {}", orderKafkaMessage);
        orderKafkaMessage.getOrderItemKafkaMessages().forEach(orderItemKafkaMessage -> {
            log.info("Total amount for item {} is : {}", orderItemKafkaMessage.getName(),
                    orderItemKafkaMessage.getPrice() * orderItemKafkaMessage.getQuantity());
        });
    }
}
