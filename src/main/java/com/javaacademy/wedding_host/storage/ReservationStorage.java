package com.javaacademy.wedding_host.storage;

import com.javaacademy.wedding_host.entity.Reservation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReservationStorage {
    private final Map<Integer, List<Reservation>> data = new HashMap<>();

    /*
    сохранение бронирований
     */
    public void save(Reservation reservation) {
        //проверяем есть ли список броней по данному месяцу
        List<Reservation> list = data.get(reservation.getMonthNumber());
        if(list == null) {
            list = new ArrayList<>();
        }
        //проверяем есть ли уже бронь в этом месяце на этот день
        else if(data.get(reservation.getMonthNumber()).contains(reservation)) {
            throw new RuntimeException("Эта дата уже забронирована");
        }
        //добавить новый элемент в список
        list.add(reservation);
        data.put(reservation.getMonthNumber(), list);
    }

    /*
    список броней за месяц
    */
    public List<Reservation> findAllByMonth(Integer month) {
        if(data.get(month) == null) {
            return new ArrayList<>();
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
