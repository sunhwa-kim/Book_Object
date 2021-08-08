package com.sh.object.ch02.step01.mine.discount;

import com.sh.object.ch02.step01.mine.Screening;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition{

    private DayOfWeek dayOfWeek;
    private LocalTime start;
    private LocalTime end;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.start = startTime;
        this.end = endTime;
    }

    @Override
    public Boolean isCheckCondition(Screening screening) {
        LocalDateTime showTime = screening.getShowTime();
        return (this.dayOfWeek.equals(showTime.getDayOfWeek()) &&
                this.start.compareTo(showTime.toLocalTime()) <= 0 &&
                this.end.compareTo(showTime.toLocalTime()) >= 0);
    }
}
