package com.projetai.quality.ticket.infra;

import com.projetai.quality.ticket.domain.status.TicketStatus;
import com.projetai.quality.ticket.domain.type.TicketType;
import jakarta.persistence.*;

@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String user;

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

    public TicketEntity() {
    }


}
