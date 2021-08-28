package com.sh.object.ch05.step04;


import com.sh.object.ch05.money.Money;
import com.sh.object.ch05.step01.Screening;
import com.sh.object.ch05.step03.DiscountCondition;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public Movie(String title, Duration runningTime, Money money, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = money;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money caculateMovieFee(Screening screening) {
        if(isDiscountable(screening)) return this.fee.minus(calculateDiscountAmount());
        return this.fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    abstract protected Money calculateDiscountAmount();

    protected Money getFee() {
        return this.fee;
    }

}
