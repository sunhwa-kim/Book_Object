package com.sh.object.ch05.step05.price;

import com.sh.object.ch05.money.Money;
import com.sh.object.ch05.step05.DefaultDiscountPolicy;
import com.sh.object.ch05.step05.Screening;

public class NoneDiscountPolicy extends DefaultDiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening Screening) {
        return Money.ZERO;
    }
}
