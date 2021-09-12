package com.sh.object.ch06.step02;

public class Audience {


    public boolean hasInvitation() {
        return true;
    }
    public void setTicket(Ticket ticket) {
        if (this.hasInvitation()) {
            Ticket ticket = ticketSeller.getTicket();
            this.setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicket();
            this.minusAmount(ticket.getFee());
            ticketSeller.plusAmount(ticket.getFee());
            this.setTicket(ticket);
        }
    }

    public void minusAmount(Integer fee) {

    }
}
