package com.projetai.quality.ticket.application;

import com.projetai.core.infra.notification.NotificationRepository;
import com.projetai.core.infra.ticket.TicketEnum.TicketStatus;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.developer.DeveloperRepository;
import com.projetai.quality.ticket.application.dto.GetAllTicketsData;
import com.projetai.quality.ticket.domain.Ticket;
import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.ticket.TicketRepository;
import com.projetai.quality.ticket.domain.parameters.TicketParametersDto;
import com.projetai.quality.ticket.infra.user.dev.Dev;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final DeveloperRepository devRepository;
    private final NotificationRepository<DeveloperEntity> notificationRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, DeveloperRepository devRepository,
                         NotificationRepository<DeveloperEntity> notificationRepository) {
        this.ticketRepository = ticketRepository;
        this.devRepository = devRepository;
        this.notificationRepository = notificationRepository;
    }

    //Return details of a Ticket searching by its id
    public TicketEntity detailTicket(Long id){
        return  ticketRepository.getReferenceById(id);
    }

    //Return a page with 10 first tickets
    public Page<GetAllTicketsData> getAllTickets(Pageable pageable){
        return ticketRepository.findByTicketStatusNot(TicketStatus.FINISHED, pageable).map(GetAllTicketsData::new);
    }

    @Transactional
    public void createTicketParameters(TicketParametersDto parameters) {
        DeveloperEntity developer = getDevForTicket(parameters);
        Ticket ticket = createTicket(parameters, developer);
        //notificationRepository.save(ticket.makeNotificationToDev());
    }

    @Transactional
    public DeveloperEntity getDevForTicket(TicketParametersDto parameters) {
        return new DeveloperEntity(devRepository.findById(parameters.userNotifiedId()).orElseThrow());
    }
    @Transactional
    public Ticket createTicket(TicketParametersDto parameters, DeveloperEntity developer) {
        Ticket ticket = new Ticket(parameters.type(), developer, parameters.contactId(), parameters.title());
        ticketRepository.save(ticket.defineTicketParameters(parameters));
        return ticket;
    }
}
