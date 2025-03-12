package com.javaacademy.wedding_host.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReservationDto {
    private Integer monthNumber;
    private Integer dayNumber;
    @JsonProperty("booked")
    private Boolean isBooked;
}
