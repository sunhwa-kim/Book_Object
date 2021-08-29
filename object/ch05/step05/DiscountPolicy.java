package com.sh.object.ch05.step05;


import com.sh.object.ch05.money.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
