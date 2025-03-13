package com.javaacademy.wedding_host.service;

import com.javaacademy.wedding_host.dto.ReservationDto;
import com.javaacademy.wedding_host.entity.Reservation;
import com.javaacademy.wedding_host.mapper.ReservationMapper;
import com.javaacademy.wedding_host.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public List<ReservationDto> findAllByMonth(Integer month) {
        List<Reservation> list = reservationRepository.findAllByMonth(month);
        return list.stream().map(reservationMapper::mapToDto).toList();
    }

    public void save(ReservationDto reservationDto) {
        Reservation reservation = reservationMapper.mapToEntity(reservationDto);
        reservationRepository.save(reservation);
    }

    public Integer countByMonth(Integer month) {
        return reservationRepository.countByMonth(month);
    }

}
