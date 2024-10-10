package com.projetai.Projetai.domain.entities.ticket;

public record CreateTicketData(String title, String userName, String userEmail, String description, TicketType ticketType, TicketStatus ticketStatus) {
}
