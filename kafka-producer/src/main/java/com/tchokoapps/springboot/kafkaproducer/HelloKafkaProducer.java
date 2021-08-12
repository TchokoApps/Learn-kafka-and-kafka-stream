package com.tchokoapps.springboot.kafkaproducer;

import com.tchokoapps.springboot.kafkaproducer.config.Config;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class HelloKafkaProducer {

    private KafkaTemplate<String, String> kafkaTemplate;
    private Config config;

    public HelloKafkaProducer(KafkaTemplate<String, String> kafkaTemplate, Config config) {
        this.kafkaTemplate = kafkaTemplate;
        this.config = config;
    }

    public void sendHello(String message) {
        kafkaTemplate.send(config.getTopic(), "Hello, " + message);
    }
}
