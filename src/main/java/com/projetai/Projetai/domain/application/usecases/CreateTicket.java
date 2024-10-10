package com.projetai.Projetai.domain.application.usecases;

import com.projetai.Projetai.domain.application.gateways.TicketRepository;
import com.projetai.Projetai.domain.entities.ticket.Ticket;

public class CreateTicket {
    private final TicketRepository repository;

    public CreateTicket(TicketRepository repository) {
        this.repository = repository;
    }


    public Ticket createTicket(Ticket ticket){

        return repository.saveTicket(ticket);
    }
}
