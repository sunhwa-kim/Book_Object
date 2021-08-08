package com.sh.object.ch02.step01.mine;

import com.sh.object.ch02.step01.mine.discount.*;
import com.sh.object.ch02.step01.mine.enumClazz.Genre;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        DiscountCondition orderCondition = new OrderCondition(1);
        DiscountCondition periodCondition = new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(00,00), LocalTime.of(2,00));
        DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy(0.05, orderCondition);
        DiscountPolicy feeDiscountPolicy = new FeeDiscountPolicy(500, periodCondition);
        Movie movie = new Movie("인터스텔라", Genre.SCIENCE_FICTION, 175, 3000, true, rateDiscountPolicy);
        Movie movie2 = new Movie("인터스텔라", Genre.SCIENCE_FICTION, 175, 3000, true, feeDiscountPolicy);

        ArrayList<Screening> lst = new ArrayList<>();
        Screening screening = new Screening(movie, 1, LocalDateTime.now().minusHours(2L), 300);
        Screening screening2 = new Screening(movie, 2, LocalDateTime.now(), 300);
        Screening screening3 = new Screening(movie2, 2, LocalDateTime.now(), 300);

        lst.add(screening);
        lst.add(screening2);
        lst.add(screening3);


        Reservation reservation = new Reservation(screening, 2);
        Reservation reservation3 = new Reservation(screening3, 2);

        System.out.println("남은 좌석 : "+screening.getSeats());
        reservation.showReservationInformation();
        System.out.println("-----------------------");
        System.out.println("남은 좌석 : "+screening3.getSeats());
        reservation3.showReservationInformation();
    }
}
