package com.sh.object.ch01.my_step02;

import com.sh.object.ch01.step01.ticketOffice.model.Ticket;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        Ticket ticket = this.ticketOffice.getTicket();
        Long fee = audience.buy(ticket);
        this.incomeTicket(fee);
    }

    private void incomeTicket(Long fee) {
        this.ticketOffice.plusAmount(fee);
    }

}
