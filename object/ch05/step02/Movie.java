package com.sh.object.ch05.step02;


import com.sh.object.ch05.enumclazz.MovieType;
import com.sh.object.ch05.money.Money;
import com.sh.object.ch05.step01.Screening;

import java.time.Duration;
import java.util.List;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<PeriodCondtion> periodCondtions;
    private List<SequenceCondition> sequenceConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Movie(String title, Duration runningTime, Money fee, List<PeriodCondtion> periodCondtions, List<SequenceCondition> sequenceConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.periodCondtions = periodCondtions;
        this.sequenceConditions = sequenceConditions;
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return checkPeriodConditions(screening) || checkSequenceConditions(screening);
    }

    private Money calculateDiscountAmount() {
        switch(movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }

        throw new IllegalStateException();
    }

    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

    private Money calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }

    // step02 - DiscountCodition 클래스 분리
    private boolean checkPeriodConditions(Screening screening) {
        return periodCondtions.stream().anyMatch(condition -> condition.isSatisfiedByPeriod(screening));
    }

    private boolean checkSequenceConditions(Screening screening) {
        return sequenceConditions.stream().anyMatch(condition -> condition.isSatisfiedBySequence(screening));
    }
}
