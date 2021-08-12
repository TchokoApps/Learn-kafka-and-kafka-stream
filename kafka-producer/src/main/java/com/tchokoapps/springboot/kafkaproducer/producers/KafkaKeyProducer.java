package com.tchokoapps.springboot.kafkaproducer.producers;

import com.tchokoapps.springboot.kafkaproducer.config.Config;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaKeyProducer {

    private KafkaTemplate<String, String> kafkaTemplate;
    private Config config;

    public KafkaKeyProducer(KafkaTemplate<String, String> kafkaTemplate, Config config) {
        this.kafkaTemplate = kafkaTemplate;
        this.config = config;
    }

    public void send(String key, String data) {
        kafkaTemplate.send("t_multi_partitions", key, data);
    }
}
