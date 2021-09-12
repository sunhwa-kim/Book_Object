package com.sh.object.ch06.step02;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public void setTicket(Ticket ticket) {
        bag.setTicket(ticket);
    }


}
