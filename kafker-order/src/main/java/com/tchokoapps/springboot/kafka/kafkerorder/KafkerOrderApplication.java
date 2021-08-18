package com.tchokoapps.springboot.kafka.kafkerorder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tchokoapps.springboot.kafka.kafkerorder.dtos.request.OrderDtoRequest;
import com.tchokoapps.springboot.kafka.kafkerorder.dtos.request.OrderItemDtoRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class KafkerOrderApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkerOrderApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        OrderDtoRequest orderDtoRequest = new OrderDtoRequest();

        orderDtoRequest.setLocation(RandomStringUtils.randomAlphanumeric(8));
        orderDtoRequest.setDateTime(LocalDateTime.now());
        orderDtoRequest.setCreditCardNumber(RandomStringUtils.randomAlphanumeric(8));

        OrderItemDtoRequest orderItemDtoRequest = new OrderItemDtoRequest();
        orderItemDtoRequest.setName(RandomStringUtils.randomAlphanumeric(8));
        orderItemDtoRequest.setPrice(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        orderItemDtoRequest.setName(RandomStringUtils.randomAlphanumeric(8));
        orderItemDtoRequest.setQuantity(Integer.parseInt(RandomStringUtils.randomNumeric(3)));

        OrderItemDtoRequest orderItemDtoRequest2 = new OrderItemDtoRequest();
        orderItemDtoRequest2.setName(RandomStringUtils.randomAlphanumeric(8));
        orderItemDtoRequest2.setPrice(Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        orderItemDtoRequest2.setName(RandomStringUtils.randomAlphanumeric(8));
        orderItemDtoRequest2.setQuantity(Integer.parseInt(RandomStringUtils.randomNumeric(3)));

        orderDtoRequest.setOrderItemDtoRequests(Arrays.asList(orderItemDtoRequest,orderItemDtoRequest2));

        String orderDtoRequestString = objectMapper.writeValueAsString(orderDtoRequest);
        log.info("--- orderDtoRequest ---");
        log.info(orderDtoRequestString);
    }
}
