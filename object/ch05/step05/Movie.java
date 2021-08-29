package com.sh.object.ch05.step05;

import com.sh.object.ch05.money.Money;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money money, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = money;
        this.discountPolicy = discountPolicy;
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    
    // interface로 분리 : DiscountCondition
/*    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }*/

    // interface, 상속 : DiscountPolicy, DefaultDiscountPolicy
    /*abstract protected Money calculateDiscountAmount();*/

    protected Money getFee() {
        return this.fee;
    }

}
