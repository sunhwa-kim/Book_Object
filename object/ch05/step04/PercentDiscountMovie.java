package com.sh.object.ch05.step04;


import com.sh.object.ch05.money.Money;
import com.sh.object.ch05.step03.DiscountCondition;

import java.time.Duration;

public class PercentDiscountMovie extends Movie{
    private double percent;

    public PercentDiscountMovie(String title, Duration runningTime, Money money, double percent, DiscountCondition... discountConditions) {
        super(title, runningTime, money, discountConditions);
        this.percent = percent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return getFee().times(percent);
    }
}
