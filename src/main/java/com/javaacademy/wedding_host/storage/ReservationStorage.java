package com.javaacademy.wedding_host.storage;

import com.javaacademy.wedding_host.entity.Reservation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReservationStorage {
    private final Map<Integer, SortedSet<Reservation>> data = new HashMap<>();

    /*
    сохранение бронирований
     */
    public void save(Reservation reservation) {
        //проверяем есть ли список броней по данному месяцу
        SortedSet<Reservation> set = data.get(reservation.getMonthNumber());
        if(set == null) {
            set = new TreeSet<Reservation>();
        }
        //проверяем есть ли уже бронь в этом месяце на этот день
        else if(data.get(reservation.getMonthNumber()).contains(reservation)) {
            throw new RuntimeException("Эта дата уже забронирована");
        }
        //добавить новый элемент в список
        set.add(reservation);
        data.put(reservation.getMonthNumber(), set);
    }

    /*
    список броней за месяц
    */
    public SortedSet<Reservation> findAllByMonth(Integer month) {
        if(data.get(month) == null) {
            return new TreeSet<Reservation>();
        }
        else {
            return data.get(month);
        }
    }

    /*
    количество забронированных дней в месяце
    */
    public int countByMonth(Integer month) {
        if(data.get(month) == null){
            return 0;
        }
        else {
            return data.get(month).size();
        }
    }
}
