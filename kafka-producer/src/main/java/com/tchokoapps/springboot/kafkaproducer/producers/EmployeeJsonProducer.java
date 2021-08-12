package com.tchokoapps.springboot.kafkaproducer.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tchokoapps.springboot.kafkaproducer.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeJsonProducer {

    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper = new ObjectMapper();

    public EmployeeJsonProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Employee employee) throws JsonProcessingException {
        String jsonEmployee = objectMapper.writeValueAsString(employee);
        log.info("--- jsonEmployee ---");
        log.info(jsonEmployee);
        kafkaTemplate.send("t_employee", jsonEmployee);
    }
}
