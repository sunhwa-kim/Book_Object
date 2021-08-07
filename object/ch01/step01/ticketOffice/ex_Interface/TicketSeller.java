package com.sh.object.ch01.step01.ticketOffice.ex_Interface;


import com.sh.object.ch01.step01.ticketOffice.model.TicketOffice;

public class TicketSeller  {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
}
