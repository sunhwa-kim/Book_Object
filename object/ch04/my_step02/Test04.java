package com.sh.object.ch04.my_step02;

import com.sh.object.ch04.step01.common.Money;
import com.sh.object.ch04.step01.discount.enumclazz.DiscountConditionType;
import com.sh.object.ch04.step01.movie.enumclazz.MovieType;
import com.sh.object.ch04.step01.reservation.Customer;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Test04 {
    public static void main(String[] args) {

        List<DiscountCondition> conditions = new ArrayList<>();
        DiscountCondition condition = new DiscountCondition(DiscountConditionType.PERIOD, DayOfWeek.SATURDAY, LocalTime.of(18, 00), LocalTime.of(23,00));
        conditions.add(condition);
        conditions.add(new DiscountCondition(DiscountConditionType.SEQUENCE,4));

        Movie movie = new Movie("킹덤:아신전", Money.wons(12000L), conditions, MovieType.AMOUNT_DISCOUNT, Money.wons(5000L));

        Screening screening = new Screening(movie, 4, LocalDateTime.now());
        Customer customer = new Customer("김선화", "Kim_Sunhwa");

        Reservation reserve = new ReservationAgency().reserve(screening, customer, 2);
        System.out.println(reserve.toString());
    }
}
