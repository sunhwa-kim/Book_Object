package com.sh.object.ch05.step05.price;

import com.sh.object.ch05.money.Money;
import com.sh.object.ch05.step05.DefaultDiscountPolicy;
import com.sh.object.ch05.step05.DiscountCondition;
import com.sh.object.ch05.step05.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening Screening) {
        return null;
    }
}
