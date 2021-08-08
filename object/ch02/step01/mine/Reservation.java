package com.sh.object.ch02.step01.mine;

import java.math.BigInteger;

public class Reservation {
    private Screening screening;
    private String screeningInformation;
    private Integer theNumberOfAudience;
    private Integer fullPrice;
    private BigInteger actualPrice;

    public Reservation(Screening screening, Integer theNumberOfAudience) {
        this.screening = screening;
        this.theNumberOfAudience = theNumberOfAudience;
        this.fullPrice = this.screening.originalMovieFee(theNumberOfAudience);
        this.actualPrice = this.screening.caculatePrice(theNumberOfAudience);
        this.screeningInformation = this.screening.getScreeningTimeInformation();
    }

    public Screening getScreening() {
        return screening;
    }

    public String getScreeningInformation() {
        return screeningInformation;
    }

    public Integer getTheNumberOfAudience() {
        return theNumberOfAudience;
    }

    public void showReservationInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append("예매 정보\n 제목 : " + this.screening.getTitle());
        sb.append("\n 상영정보 : " + this.screeningInformation);
        sb.append("\n 인원 : " + this.theNumberOfAudience);
        sb.append("\n 정 가 : " + this.fullPrice);
        sb.append("\n 결제가격 : " + this.actualPrice);
        System.out.println(sb.toString());
    }


}
