package com.tchokoapps.springboot.kafkaconsumer;

import com.tchokoapps.springboot.kafkaconsumer.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FixedRateConsumer {

    Config config;

    public FixedRateConsumer(Config config) {
        this.config = config;
    }

    @KafkaListener(topics = "fixed-rate" )
    public void consume(String message) {
        log.info("Received from topic 'fixed-rate':  " + message);
    }
}
