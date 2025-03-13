package com.javaacademy.wedding_host.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Reservation {
    private final Integer monthNumber;
    private final Integer dayNumber;
    private Boolean isBooked = true;
}
