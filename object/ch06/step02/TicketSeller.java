package com.sh.object.ch06.step02;

public class TicketSeller {


    public Ticket getTicket() {
        return new Ticket();
    }

    public void plusAmount(Integer fee) {

    }

    public void setTicket(Audience audience) {
        audience.setTicket(getTicket());
    }
}
