package com.projetai.quality.ticket.application.dto;


import com.projetai.quality.ticket.domain.status.TicketStatus;
import com.projetai.quality.ticket.domain.type.TicketType;
import com.projetai.quality.ticket.infra.TicketEntity;

public record GetAllTicketsData(Long id, String title, String description, String user, TicketType ticketType, TicketStatus ticketStatus) {
    public GetAllTicketsData(TicketEntity ticketEntity) {
        this(ticketEntity.getId(), ticketEntity.getTitle(), ticketEntity.getDescription(), ticketEntity.getUser(), ticketEntity.getTicketType(), ticketEntity.getTicketStatus());
    }
}
