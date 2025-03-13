package com.javaacademy.wedding_host.mapper;

import com.javaacademy.wedding_host.dto.ReservationDto;
import com.javaacademy.wedding_host.entity.Reservation;
import org.springframework.stereotype.Service;

@Service
public class ReservationMapper {

    public ReservationDto mapToDto(Reservation reservation) {
        return new ReservationDto(reservation.getMonthNumber(), reservation.getDayNumber(), reservation.getIsBooked());
    }

    public Reservation mapToEntity(ReservationDto reservationDto) {
        return new Reservation(reservationDto.getMonthNumber(), reservationDto.getDayNumber());
    }
}
