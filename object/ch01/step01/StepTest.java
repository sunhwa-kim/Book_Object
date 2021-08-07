package com.sh.object.ch01.step01;

import com.sh.object.ch01.step01.event.Invitation;
import com.sh.object.ch01.step01.ticketOffice.ex_Interface.TicketSeller;
import com.sh.object.ch01.step01.ticketOffice.model.Ticket;
import com.sh.object.ch01.step01.ticketOffice.model.TicketOffice;
import com.sh.object.ch01.step01.ticketOffice.service.Theater;
import com.sh.object.ch01.step01.user.Audience;
import com.sh.object.ch01.step01.user.Bag;

public class StepTest {
    public static void main(String[] args) {
        Bag bag = new Bag(1000000L);
//        Audience audience = new Audience(bag);
        Audience invitedAudience = new Audience(new Bag(new Invitation(),1000000));

        TicketOffice ticketOffice = new TicketOffice(1000000000L, new Ticket());
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);

//        theater.enter(audience);
//        System.out.println(audience.getBag().hasTicket());
        theater.enter(invitedAudience);
        System.out.println(invitedAudience.getBag().hasInvitation());
        System.out.println(invitedAudience.getBag().hasTicket());
    }
}
