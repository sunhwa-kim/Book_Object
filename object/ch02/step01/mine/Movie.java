package com.sh.object.ch02.step01.mine;

import com.sh.object.ch02.step01.mine.discount.DiscountPolicy;
import com.sh.object.ch02.step01.mine.enumClazz.Genre;

import java.math.BigDecimal;

public class Movie {

    private String title;
    private Genre genre;
    private Integer ScreeningTime;  // 분 단위
    private Integer fee;
    private Boolean subtitle; // 자막 유무
    private BigDecimal income;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Genre genre, Integer screeningTime, Integer fee, Boolean subtitle, DiscountPolicy discountPolicy) {
        this.title = title;
        this.genre = genre;
        ScreeningTime = screeningTime;
        this.fee = fee;
        this.subtitle = subtitle;
        this.discountPolicy = discountPolicy;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public Integer getScreeningTime() {
        return ScreeningTime;
    }

    // TODO 할인 비적용시 요금 -> Discount 결과로?
    public Integer getFee() {
        return fee;
    }

    public Boolean getSubtitle() {
        return subtitle;
    }

    public BigDecimal calculateMovieFee(Screening screening) {
        return BigDecimal.valueOf(this.fee).subtract(this.discountPolicy.calculateDiscount(screening));
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre=" + genre +
                ", ScreeningTime=" + ScreeningTime +
                ", fee=" + fee +
                ", subtitle=" + subtitle +
                ", income=" + income +
                ", discountPolicy=" + discountPolicy +
                '}';
    }
}
