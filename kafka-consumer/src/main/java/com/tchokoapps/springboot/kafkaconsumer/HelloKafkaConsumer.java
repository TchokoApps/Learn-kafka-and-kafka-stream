package com.tchokoapps.springboot.kafkaconsumer;

import com.tchokoapps.springboot.kafkaconsumer.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloKafkaConsumer {

    Config config;

    public HelloKafkaConsumer(Config config) {
        this.config = config;
    }

    @KafkaListener(topics = "test-topic" )
    public void consume(String message) {
        log.info("Received - " + message);
    }
}
