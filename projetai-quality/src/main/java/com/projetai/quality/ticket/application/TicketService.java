package com.projetai.quality.ticket.application;

import com.projetai.quality.ticket.application.dto.GetAllTicketsData;
import com.projetai.quality.ticket.domain.Ticket;
import com.projetai.quality.ticket.domain.status.TicketStatus;
import com.projetai.quality.ticket.infra.TicketEntity;
import com.projetai.quality.ticket.infra.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    //Return details of a Ticket searching by its id
    public TicketEntity DetailTicket(Long id){
        return  ticketRepository.getReferenceById(id);
    }

    //Return a page with 10 first tickets
    public Page GetAllTickets(Pageable pageable){
        return ticketRepository.findByTicketStatusNot(TicketStatus.FINISHED, pageable).map(GetAllTicketsData::new);
    }

    public Object notification() {
        Ticket ticket = new Ticket();
        return  ticket.SendNotificationToDev();
    }

    public void addTicketParameters(String parameters, Long id) {

    }
}
