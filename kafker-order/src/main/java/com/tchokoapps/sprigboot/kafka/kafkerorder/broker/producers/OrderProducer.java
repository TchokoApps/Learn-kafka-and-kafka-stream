package com.tchokoapps.sprigboot.kafka.kafkerorder.broker.producers;

import com.tchokoapps.sprigboot.kafka.kafkerorder.broker.messages.OrderKafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class OrderProducer {

    private KafkaTemplate<String, OrderKafkaMessage> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, OrderKafkaMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(OrderKafkaMessage orderKafkaMessage) {
        kafkaTemplate.send("t.commodity.order", orderKafkaMessage.getNumber(), orderKafkaMessage).addCallback(new ListenableFutureCallback<SendResult<String, OrderKafkaMessage>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Order {} failed to publish, bacause {}", orderKafkaMessage.getNumber(), throwable.getStackTrace());
            }

            @Override
            public void onSuccess(SendResult<String, OrderKafkaMessage> stringOrderMessageSendResult) {
                log.info("Order {} published successfully", orderKafkaMessage.getNumber());
            }
        });
    }
}
