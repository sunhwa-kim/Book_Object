package com.sh.object.ch02.step01.mine;

import com.sh.object.ch02.step01.mine.enumClazz.Genre;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        Movie movie = new Movie("인터스텔라", Genre.SCIENCE_FICTION, 175, 3000, true);

        ArrayList<Screening> lst = new ArrayList<>();
        Screening screening = new Screening(movie, 1, LocalDateTime.now().minusHours(2L), 300);
        Screening screening2 = new Screening(movie, 2, LocalDateTime.now(), 300);

        lst.add(screening);
        lst.add(screening2);


        Reservation reservation = new Reservation(screening, 2);

        System.out.println(screening.toString());
        reservation.showReservationInformation();
    }
}
