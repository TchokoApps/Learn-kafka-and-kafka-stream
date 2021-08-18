package com.tchokoapps.springboot.kafka.kafkerorder.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Config {

    @Bean
    public NewTopic topicOrder() {
        return TopicBuilder.name("t.commodity.order").partitions(2).replicas(1).build();
    }
}
