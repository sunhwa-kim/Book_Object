package com.sh.object.ch02.step01.mine;

public class Reservation {
    private Screening screening;
    private String screeningInformation;
    private Integer theNumberOfAudience;
    private Integer fullPrice;

    public Reservation(Screening screening, Integer theNumberOfAudience) {
        this.screening = screening;
        this.theNumberOfAudience = theNumberOfAudience;
        this.fullPrice = this.screening.getFullPrice(theNumberOfAudience);
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
        System.out.println(sb.toString());
    }


}
