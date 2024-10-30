package com.projetai.core.infra.ticket;

import com.projetai.core.infra.ticket.TicketEnum.TicketStatus;
import com.projetai.core.infra.ticket.TicketEnum.TicketType;
import jakarta.persistence.*;

@Entity(name = "ticket")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long userId;
    private String parameters;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    private Long contactId;

    public TicketEntity() {
    }

    public TicketEntity(Long contactId) {
        this.contactId = contactId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getUser() {
        return userId;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public String getParameters() {
        return parameters;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Long getContactId() {
        return contactId;
    }
}
