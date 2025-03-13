package com.javaacademy.wedding_host.controller;

import com.javaacademy.wedding_host.dto.ReservationDto;
import com.javaacademy.wedding_host.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class ReservationController {
    private final ReservationService reservationService;

    /*
    1. Сервер будет хранить в себе информацию о бронированиях
     */
    @GetMapping("/month/{number}")
    public List<ReservationDto> findAllByMonth(@PathVariable Integer month) {
        return reservationService.findAllByMonth(month);
    }

    /*
    2. Сервер должен принимать запрос на бронирование
     */
    @PostMapping
    public void save(ReservationDto reservationDto) {
        reservationService.save(reservationDto);
    }

    /*
    3. Сервер должен отдавать количество забронированных дней за этот выбранный месяц
     */
    @GetMapping("/month/{number}/free")
    public Integer countByMonth(@PathVariable Integer month) {
        return reservationService.countByMonth(month);
    }


}
