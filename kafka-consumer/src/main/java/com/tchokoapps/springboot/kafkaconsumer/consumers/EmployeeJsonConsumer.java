package com.tchokoapps.springboot.kafkaconsumer.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tchokoapps.springboot.kafkaconsumer.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeJsonConsumer {
    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "t_employee" )
    public void consume(String message) throws JsonProcessingException {
        Employee employee = objectMapper.readValue(message, Employee.class);
        log.info("Received from topic 't_employee':  " + employee);
    }
}
