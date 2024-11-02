package com.projetai.quality.ticket.application.dto;

import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.ticket.TicketEnum.TicketStatus;
import com.projetai.core.infra.ticket.TicketEnum.TicketType;

public record GetAllTicketsData(Long id, String title, String description, TicketType ticketType, TicketStatus ticketStatus) {
    public GetAllTicketsData(TicketEntity ticketEntity) {
        this(ticketEntity.getId(), ticketEntity.getTitle(), ticketEntity.getDescription(), ticketEntity.getTicketType(), ticketEntity.getTicketStatus());
    }
}
