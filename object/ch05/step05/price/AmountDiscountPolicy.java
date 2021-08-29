package com.sh.object.ch05.step05.price;

import com.sh.object.ch05.money.Money;
import com.sh.object.ch05.step05.DefaultDiscountPolicy;
import com.sh.object.ch05.step05.DiscountCondition;
import com.sh.object.ch05.step05.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening Screening) {
        return discountAmount;
    }
}
