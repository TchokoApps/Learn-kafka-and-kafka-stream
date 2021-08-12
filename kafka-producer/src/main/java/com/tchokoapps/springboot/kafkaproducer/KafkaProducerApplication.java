package com.tchokoapps.springboot.kafkaproducer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@Slf4j
@SpringBootApplication
//@EnableScheduling
public class KafkaProducerApplication implements CommandLineRunner {

    private HelloKafkaProducer helloKafkaProducer;
    private KafkaKeyProducer kafkaKeyProducer;
    private Random random = new Random();

    public KafkaProducerApplication(HelloKafkaProducer helloKafkaProducer, KafkaKeyProducer kafkaKeyProducer) {
        this.helloKafkaProducer = helloKafkaProducer;
        this.kafkaKeyProducer = kafkaKeyProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        helloKafkaProducer.sendHello("Charles");

        sendKafkaMessageWithKey();
    }

    private void sendKafkaMessageWithKey() {
        for (int i = 0; i < 10000; i++) {
            final String key = "key-" + (i % 4);
            final String data = "data " + i + " with key = " + key;

            kafkaKeyProducer.send(key, data);
            log.info("Message sent: " + data);
        }
    }
}
