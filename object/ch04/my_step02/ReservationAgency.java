package com.sh.object.ch04.my_step02;


import com.sh.object.ch04.step01.common.Money;
import com.sh.object.ch04.step01.reservation.Customer;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.caculatedFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }


}
