package com.sh.object.ch02.step01.mine.discount;

import com.sh.object.ch02.step01.mine.Screening;

public class OrderCondition implements DiscountCondition{

    private Integer conditionOfOrder;

    public OrderCondition(Integer order) {
        this.conditionOfOrder = order;
    }

    @Override
    public Boolean isCheckCondition(Screening screening) {
        return this.conditionOfOrder == screening.getOrder();
    }
}
