package com.sh.object.ch05.step04;


import com.sh.object.ch05.money.Money;
import com.sh.object.ch05.step03.DiscountCondition;

import java.time.Duration;

public class NoneDiscountMovie extends Movie{
    public NoneDiscountMovie(String title, Duration runningTime, Money money, DiscountCondition... discountConditions) {
        super(title, runningTime, money, discountConditions);
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
