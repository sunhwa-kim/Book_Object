package com.sh.object.ch05.step05;

import com.sh.object.ch05.money.Money;
import com.sh.object.ch05.step01.Customer;

import java.time.LocalDateTime;

public class Screening {

    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

/*    public int getSequence() {
        return sequence;
    }*/

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }
}
