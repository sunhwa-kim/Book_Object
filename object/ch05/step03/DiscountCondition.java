package com.sh.object.ch05.step03;


import com.sh.object.ch05.step01.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
