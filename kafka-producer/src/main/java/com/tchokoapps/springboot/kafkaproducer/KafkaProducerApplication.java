package com.tchokoapps.springboot.kafkaproducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tchokoapps.springboot.kafkaproducer.entities.Employee;
import com.tchokoapps.springboot.kafkaproducer.producers.EmployeeJsonProducer;
import com.tchokoapps.springboot.kafkaproducer.producers.HelloKafkaProducer;
import com.tchokoapps.springboot.kafkaproducer.producers.KafkaKeyProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@Slf4j
@SpringBootApplication
//@EnableScheduling
public class KafkaProducerApplication implements CommandLineRunner {

    private HelloKafkaProducer helloKafkaProducer;
    private KafkaKeyProducer kafkaKeyProducer;
    private EmployeeJsonProducer employeeJsonProducer;

    public KafkaProducerApplication(HelloKafkaProducer helloKafkaProducer, KafkaKeyProducer kafkaKeyProducer, EmployeeJsonProducer employeeJsonProducer) {
        this.helloKafkaProducer = helloKafkaProducer;
        this.kafkaKeyProducer = kafkaKeyProducer;
        this.employeeJsonProducer = employeeJsonProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        helloKafkaProducer.sendHello("Charles");

        sendKafkaMessageWithKey();

        sendJsonEmployeeMessage();
    }

    private void sendJsonEmployeeMessage() throws JsonProcessingException {

        for (int i = 0; i < 5; i++) {
            Employee employee = new Employee("emp-" + i, "Employee-" + i, LocalDate.now());
            employeeJsonProducer.sendMessage(employee);
        }
    }

    private void sendKafkaMessageWithKey() {
        for (int i = 0; i < 5; i++) {
            final String key = "key-" + (i % 4);
            final String data = "data " + i + " with key = " + key;

            kafkaKeyProducer.send(key, data);
            log.info("Message sent: " + data);
        }
    }
}
