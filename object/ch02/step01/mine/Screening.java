package com.sh.object.ch02.step01.mine;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Screening {
    private Movie movie;
    private Integer order;
    private LocalDateTime showTime;
    private Integer seats;


    public Screening(Movie movie, Integer order, LocalDateTime showTime, Integer seats) {
        this.movie = movie;
        this.order = order;
        this.showTime = showTime;
        this.seats = seats;
    }

    public BigDecimal getMovieFee() {
        return BigDecimal.valueOf(this.movie.getFee());
    }

    public Integer getOrder() {
        return order;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public Integer getSeats() {
        return seats;
    }

    public Integer originalMovieFee(Integer numbers) {
        return this.movie.getFee() * numbers;
    }

    public BigInteger caculatePrice(Integer numbers){
        this.seats -= numbers;
        return this.movie.calculateMovieFee(this).multiply(BigDecimal.valueOf(numbers)).toBigInteger();
    }

    public String getTitle() {
        return this.movie.getTitle();
    }

    public Integer getScreeningTime() {
        return this.movie.getScreeningTime();
    }

    public String getScreeningTimeInformation() {
        String dateTimeFormat = localDateTimeformat(this.showTime);
        String endOfTime = screeningEndOfTime();
        return dateTimeFormat + "~" + endOfTime;
    }

    public LocalDateTime getEndOfShowTime() {
        Integer minutes = getScreeningTime();
        return this.showTime.plusMinutes(minutes);
    }

    private String screeningEndOfTime() {
        LocalDateTime endTime = getEndOfShowTime();
        return hourAndMinuteformat(endTime);
    }

    private String hourAndMinuteformat(LocalDateTime localDateTime) {
        DateTimeFormatter hhMm = DateTimeFormatter.ofPattern("HH:mm");
        return localDateTime.format(hhMm);
    }

    private String localDateTimeformat(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy??? MM??? dd???, HH:mm");
        return localDateTime.format(formatter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screening screening = (Screening) o;
        return Objects.equals(movie, screening.movie) && Objects.equals(order, screening.order) && Objects.equals(showTime, screening.showTime) && Objects.equals(seats, screening.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, order, showTime, seats);
    }

    @Override
    public String toString() {
        return "Screening{" +
                "movie=" + movie +
                ", order=" + order +
                ", showTime=" + showTime +
                ", seats=" + seats +
                '}';
    }

    public Movie getMovie() {
    }
}

