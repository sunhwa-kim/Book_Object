package com.sh.object.ch06.step02;

public class Bag {
    public boolean hasInvitation() {
        return true;
    }

    public void hold(Ticket ticket) {
        if(hasInvitation()){

        }else{
            minusAmount(ticket.getFee());
        }
    }

    public void minusAmount(Integer fee) {

    }
}
