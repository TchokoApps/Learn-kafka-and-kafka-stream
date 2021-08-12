package com.tchokoapps.springboot.kafkaproducer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class KafkaProducerApplication implements CommandLineRunner {

    private HelloKafkaProducer helloKafkaProducer;

    public KafkaProducerApplication(HelloKafkaProducer helloKafkaProducer) {
        this.helloKafkaProducer = helloKafkaProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
		helloKafkaProducer.sendHello("Charles");
    }
}
