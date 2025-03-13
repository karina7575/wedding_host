package com.javaacademy.wedding_host.controller;

import com.javaacademy.wedding_host.dto.ReservationDto;
import com.javaacademy.wedding_host.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
@CrossOrigin
@Slf4j
public class ReservationController {
    private final ReservationService reservationService;

    /*
    1. Сервер будет хранить в себе информацию о бронированиях
     */
    @GetMapping("/month/{month}")
    public List<ReservationDto> findAllByMonth(@PathVariable int month) {
        return reservationService.findAllByMonth(month);
    }

    /*
    2. Сервер должен принимать запрос на бронирование
     */
    @PostMapping
    @ResponseStatus(value = CREATED)
    public void save(@RequestBody ReservationDto reservationDto) {
        reservationService.save(reservationDto);
    }

    /*
    3. Сервер должен отдавать количество забронированных дней за этот выбранный месяц
     */
    @GetMapping("/month/{month}/free")
    public Map<String, Integer> countByMonth(@PathVariable Integer month) {
        return reservationService.countByMonth(month);
    }


}
