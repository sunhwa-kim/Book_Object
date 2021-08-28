package com.sh.object.ch05.step04;


import com.sh.object.ch05.money.Money;
import com.sh.object.ch05.step03.DiscountCondition;

import java.time.Duration;

public class AmountDiscountMovie extends Movie {
    private Money discountAmount;

    public AmountDiscountMovie(String title, Duration runningTime, Money money, Money discountAmount, DiscountCondition... discountConditions) {
        super(title, runningTime, money, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return discountAmount;
    }
}
