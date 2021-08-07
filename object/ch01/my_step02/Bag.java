package com.sh.object.ch01.my_step02;

import com.sh.object.ch01.step01.event.Invitation;
import com.sh.object.ch01.step01.ticketOffice.model.Ticket;

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public Long hasInvitation(Ticket ticket) {
        if(invitation != null){
            this.setTicket(ticket);
            return 0L;
        }
        else{
            this.buyTicket(ticket);
            return ticket.getFee();
        }
    }

    private boolean hasTicket() {
        return ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    public void buyTicket(Ticket ticket) {
        this.minusAmount(ticket.getFee());
        this.setTicket(ticket);
    }
}
