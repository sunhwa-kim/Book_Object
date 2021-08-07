package com.sh.object.ch01.my_step02;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        this.ticketSeller.sellTo(audience);
    }
}
