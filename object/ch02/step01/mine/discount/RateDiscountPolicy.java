package com.sh.object.ch02.step01.mine.discount;


import com.sh.object.ch02.step01.mine.Screening;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RateDiscountPolicy implements DiscountPolicy {

    private Double percent;
    // 중복 o
    private List<DiscountCondition> conditions = new ArrayList<>();

    public RateDiscountPolicy(Double rateOfDiscount ,DiscountCondition... discountCondition) {
        this.percent = rateOfDiscount;
        this.conditions = Arrays.asList(discountCondition);
    }

    @Override
    public BigDecimal calculateDiscount(Screening screening) {
        // 조건맞는지 체크 : 상영 순번, 상영 시작 시간 등
        for (DiscountCondition condition : conditions) {
            if(condition.isCheckCondition(screening)) return this.getDiscount(screening);
        }
        // 조건 안 맞을 때
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getDiscount(Screening screening) {
        return BigDecimal.valueOf(this.percent).multiply(screening.getMovieFee());
    }
}
