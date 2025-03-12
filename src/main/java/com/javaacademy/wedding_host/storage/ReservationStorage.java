package com.javaacademy.wedding_host.storage;

import com.javaacademy.wedding_host.entity.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ReservationStorage {
    private final Map<Integer, List<Reservation>> data = new HashMap<>();

    /*
    сохранение бронирований
     */
    public void save(Reservation reservation) {
        List<Reservation> list = data.get(reservation.getMonthNumber());
        if(list == null) {
            list = new ArrayList<>();
            data.put(reservation.getMonthNumber(), list);
        }
        //проверяем есть ли уже бронь в этом месяце на этот день
        else if(data.get(reservation.getMonthNumber()).contains(reservation)) {
            throw new RuntimeException("Эта дата уже забронирована");
        }
        //добавить новый элемент в список
        data.put(reservation.getMonthNumber(), list);
    }

    /*
    список броней за месяц
    */
    public List<Reservation> findAllByMonth(Integer month) {
        return data.get(month);
    }

    /*
    количество забронированных дней в месяце
    */
    public int countByMonth(Integer month) {
        return data.get(month).size();
    }
}
