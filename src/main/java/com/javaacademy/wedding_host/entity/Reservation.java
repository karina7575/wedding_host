package com.javaacademy.wedding_host.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reservation {
    private Integer monthNumber;
    private Integer dayNumber;
    private Boolean isBooked;
}
