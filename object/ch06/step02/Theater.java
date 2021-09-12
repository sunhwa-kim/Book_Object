package com.sh.object.ch06.step02;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
//        ticketSeller.setTicket(audience);
        ticketSeller.sellTo(audience);
    }
}
