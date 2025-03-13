package com.javaacademy.wedding_host.service;

import com.javaacademy.wedding_host.dto.ReservationDto;
import com.javaacademy.wedding_host.entity.Reservation;
import com.javaacademy.wedding_host.mapper.ReservationMapper;
import com.javaacademy.wedding_host.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public List<ReservationDto> findAllByMonth(Integer month) {
        List<Reservation> list = reservationRepository.findAllByMonth(month);
        if(list.size() == 0){
            return null;
        }
        return list.stream().map(reservationMapper::mapToDto).toList();
    }

    public void save(ReservationDto reservationDto) {
        Reservation reservation = reservationMapper.mapToEntity(reservationDto);
        reservationRepository.save(reservation);
    }

    public Map<String, Integer> countByMonth(Integer month) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("count", reservationRepository.countByMonth(month));
        return map;
    }

}
