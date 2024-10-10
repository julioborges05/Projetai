package com.projetai.Projetai.domain.application.gateways;

import com.projetai.Projetai.domain.entities.ticket.Ticket;

import java.util.List;

public interface TicketRepository {

    Ticket saveTicket(Ticket ticket);

    List<Ticket> listTicket();
}
