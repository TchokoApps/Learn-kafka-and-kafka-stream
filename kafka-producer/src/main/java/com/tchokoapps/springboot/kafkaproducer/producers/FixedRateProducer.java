package com.tchokoapps.springboot.kafkaproducer.producers;

import com.tchokoapps.springboot.kafkaproducer.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FixedRateProducer {

    private KafkaTemplate<String, String> kafkaTemplate;
    private Config config;
    private int counter = 0;

    public FixedRateProducer(KafkaTemplate<String, String> kafkaTemplate, Config config) {
        this.kafkaTemplate = kafkaTemplate;
        this.config = config;
    }

//    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        counter++;
        log.info("counter is - " + counter);
        kafkaTemplate.send(config.getTopic(), "Fixed rate 4 - " + counter);

    }
}
