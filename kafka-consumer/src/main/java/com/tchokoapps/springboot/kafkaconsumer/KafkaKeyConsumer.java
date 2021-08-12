package com.tchokoapps.springboot.kafkaconsumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaKeyConsumer {

    @KafkaListener(topics = "t_multi_partitions", concurrency = "3")
    public void consume(ConsumerRecord<String, String> message) throws InterruptedException {
        log.info("Key: {}, Partition: {}, Message: {}", message.key(), message.partition(), message.value());
        Thread.sleep(100);
    }
}
