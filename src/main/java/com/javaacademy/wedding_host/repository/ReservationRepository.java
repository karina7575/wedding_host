package com.javaacademy.wedding_host.repository;

import com.javaacademy.wedding_host.entity.Reservation;
import com.javaacademy.wedding_host.storage.ReservationStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservationRepository {
    private final ReservationStorage reservationStorage;

    public void save(Reservation reservation) {
        reservationStorage.save(reservation);
    }

    public List<Reservation> findAllByMonth(Integer month) {
        return reservationStorage.findAllByMonth(month);
    }

    public int countByMonth(Integer month) {
        return reservationStorage.countByMonth(month);
    }
}
