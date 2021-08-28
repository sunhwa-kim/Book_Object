package com.sh.object.ch04.my_step02;


import com.sh.object.ch04.step01.discount.enumclazz.DiscountConditionType;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {

    private DiscountConditionType type;

    private int sequence;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public DiscountCondition(DiscountConditionType type,DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.type = type;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DiscountCondition(DiscountConditionType type, int sequence) {
        this.type = type;
        this.sequence = sequence;
    }

    public Boolean isDiscountableType(Screening screening) {
        if(this.type != DiscountConditionType.PERIOD) throw new IllegalArgumentException("조건 매칭 오류");
        return screening.getWhenScreened().getDayOfWeek().equals(this.dayOfWeek) &&
                this.startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                this.endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;

    }

    public Boolean isDiscountableOrder(Screening screening) {
        if(this.type != DiscountConditionType.SEQUENCE) throw new IllegalArgumentException("조건 매칭 오류");
        return screening.getSequence() == this.sequence;
    }

    public DiscountConditionType getType() {
        return type;
    }

    public void setType(DiscountConditionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DiscountCondition{" +
                "type=" + type +
                ", sequence=" + sequence +
                ", dayOfWeek=" + dayOfWeek +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
