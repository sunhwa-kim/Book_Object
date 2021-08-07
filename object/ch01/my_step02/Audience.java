package com.sh.object.ch01.my_step02;

import com.sh.object.ch01.step01.ticketOffice.model.Ticket;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        return this.bag.hasInvitation(ticket);
    }

}
