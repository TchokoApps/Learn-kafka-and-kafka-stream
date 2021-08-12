package com.tchokoapps.springboot.kafkaproducer.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tchokoapps.springboot.kafkaproducer.json.CustomLocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @JsonProperty("employee_id")
    private String id;

    private String name;

    @JsonProperty("birth_date")
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate birthDate;
}
