package com.sh.object.ch02.step01.mine.discount;

import com.sh.object.ch02.step01.mine.Screening;

public interface DiscountCondition {

    Boolean isCheckCondition(Screening screening);
}
