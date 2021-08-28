package com.sh.object.ch04.my_step02;

import com.sh.object.ch04.step01.common.Money;
import com.sh.object.ch04.step01.reservation.Customer;

public class Reservation {

    private Customer customer;

    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public int getAudienceCount() {
        return audienceCount;
    }

    public void setAudienceCount(int audienceCount) {
        this.audienceCount = audienceCount;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "customer=" + customer +
                "\n, screening=" + screening +
                "\n, fee=" + fee +
                "\n, audienceCount=" + audienceCount +
                '}';
    }
}
