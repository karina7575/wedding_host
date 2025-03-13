package com.javaacademy.wedding_host.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationDto {
    @JsonProperty("month")
    private Integer monthNumber;
    @JsonProperty("day")
    private Integer dayNumber;
    @JsonProperty("booked")
    private Boolean isBooked = true;
}
