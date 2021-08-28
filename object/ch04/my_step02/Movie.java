package com.sh.object.ch04.my_step02;


import com.sh.object.ch04.step01.common.Money;
import com.sh.object.ch04.step01.discount.enumclazz.DiscountConditionType;
import com.sh.object.ch04.step01.movie.enumclazz.MovieType;

import java.time.Duration;
import java.util.List;

public class Movie {

    private String title;

    private Duration runningTime;

    private Money fee;

    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;


    public Movie(String title, Money fee, List<DiscountCondition> discountConditions, MovieType movieType, Money discountAmount) {
        this.title = title;
        this.fee = fee;
        this.discountConditions = discountConditions;
        this.movieType = movieType;
        this.discountAmount = discountAmount;
    }

    public Boolean isDiscountable(Screening screening) {
        for (DiscountCondition discountCondition : discountConditions) {
            if (discountCondition.getType() == DiscountConditionType.PERIOD){
                return discountCondition.isDiscountableType(screening);
            }
            else{
                return discountCondition.isDiscountableOrder(screening);
            }
        }
        return false;
    }

    public Money caculateFee(Screening screening) {
        if(this.isDiscountable(screening)){
            Money discountAmount = this.caculateDiscountAmount();
            return this.fee.minus(discountAmount);
        }
        return this.fee;
    }

    private Money caculateDiscountAmount() {
        Money discountAmount = Money.ZERO;
        switch (this.movieType) {
            case AMOUNT_DISCOUNT:
                discountAmount = this.discountAmount;
                break;
            case PERCENT_DISCOUNT:
                discountAmount = this.fee.times(this.discountPercent);
                break;
            case NONE_DISCOUNT:
                discountAmount = Money.ZERO;
                break;
        }
        return discountAmount;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", runningTime=" + runningTime +
                ", fee=" + fee +
                ", discountConditions=" + discountConditions +
                ", movieType=" + movieType +
                ", discountAmount=" + discountAmount +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
