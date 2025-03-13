package com.javaacademy.wedding_host.repository;

import com.javaacademy.wedding_host.entity.Reservation;
import com.javaacademy.wedding_host.storage.ReservationStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReservationRepository {
    private final ReservationStorage reservationStorage;

    public void save(Reservation reservation) {
        //проверяем есть ли список броней по данному месяцу
        SortedSet<Reservation> set = reservationStorage.getData().get(reservation.getMonthNumber());
        if(set == null) {
            set = new TreeSet<Reservation>();
        }
        //проверяем есть ли уже бронь в этом месяце на этот день
        else if(reservationStorage.getData().get(reservation.getMonthNumber()).contains(reservation)) {
            throw new RuntimeException("Эта дата уже забронирована");
        }
        //добавить новый элемент в список
        set.add(reservation);
        reservationStorage.getData().put(reservation.getMonthNumber(), set);
    }

    public List<Reservation> findAllByMonth(Integer month) {
        SortedSet<Reservation> bookings = reservationStorage.getData().get(month);
        if(bookings == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(bookings);
    }

    public int countByMonth(Integer month) {
        if(reservationStorage.getData().get(month) == null){
            return 0;
        }
        else {
            return reservationStorage.getData().get(month).size();
        }
    }
}
