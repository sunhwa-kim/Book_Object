package com.sh.object.ch02.step01.mine.discount;

import com.sh.object.ch02.step01.mine.Screening;

import java.math.BigDecimal;

public interface DiscountPolicy {
    BigDecimal calculateDiscount(Screening screening);
    BigDecimal getDiscount(Screening screening);
}
