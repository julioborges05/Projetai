package com.projetai.quality.ticket.infra;

import com.projetai.quality.ticket.domain.status.TicketStatus;
import com.projetai.quality.ticket.domain.type.TicketType;
import jakarta.persistence.*;

@Entity(name = "ticket")
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String user;
    private String parameters;

    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUser() {
        return user;
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

    public void setUser(String user) {
        this.user = user;
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

    public TicketEntity() {
    }


}
