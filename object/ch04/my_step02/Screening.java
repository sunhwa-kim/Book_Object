package com.sh.object.ch04.my_step02;

import com.sh.object.ch04.step01.common.Money;

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

    public Money caculatedFee(int audienceCount) {
        return this.movie.caculateFee(this).times(audienceCount);
    }

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "movie=" + movie +
                ", sequence=" + sequence +
                ", whenScreened=" + whenScreened +
                '}';
    }
}
