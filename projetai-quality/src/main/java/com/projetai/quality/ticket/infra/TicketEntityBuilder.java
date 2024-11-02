package com.projetai.quality.ticket.infra;

import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.ticket.TicketEnum.TicketStatus;
import com.projetai.core.infra.ticket.TicketEnum.TicketType;


public class TicketEntityBuilder {
    private final TicketEntity ticketEntity = new TicketEntity();

    public TicketEntityBuilder withTitle(String title) {
        ticketEntity.setTitle(title);
        return this;
    }
    public TicketEntityBuilder withDescription(String description) {
        ticketEntity.setDescription(description);
        return this;
    }

    public TicketEntityBuilder withTicketType(TicketType ticketType) {
        ticketEntity.setTicketType(ticketType);
        return this;
    }
    public TicketEntityBuilder withTicketStatus(TicketStatus ticketStatus) {
        ticketEntity.setTicketStatus(ticketStatus);
        return this;
    }
    public TicketEntityBuilder withContactId(Long contadId){
        ticketEntity.setContactId(contadId);
        return this;
    }
    public TicketEntityBuilder withMessage(String message){
        ticketEntity.setMessage(message);
        return this;
    }
    public TicketEntityBuilder withAuthorId(Long authorId){
        ticketEntity.setClientId(authorId);
        return this;
    }

    public TicketEntity build() {
        return ticketEntity;
    }


}
