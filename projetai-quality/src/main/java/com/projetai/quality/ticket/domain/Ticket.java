package com.projetai.quality.ticket.domain;


import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.notification.NotificationEntityBuilder;
import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.ticket.TicketEnum.TicketStatus;
import com.projetai.core.infra.ticket.TicketEnum.TicketType;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.support.SupportEntity;

import com.projetai.quality.ticket.domain.parameters.TicketParametersDto;
import com.projetai.quality.ticket.infra.TicketEntityBuilder;

public class Ticket implements TicketInterface {

    private TicketType ticketType;
    private DeveloperEntity dev;
    private Long contactId;
    private String title;
    private SupportEntity support;


    public Ticket(TicketParametersDto parameters, DeveloperEntity dev) {
        this.ticketType = parameters.type();
        this.dev = dev;
        this.contactId = parameters.contactId();
        this.title = parameters.title();
    }



    public Ticket() {
    }


    @Override
    public TicketEntity defineTicketParameters(TicketParametersDto parameters) {
        return new TicketEntityBuilder().withTicketType(parameters.type())
                .withDescription(parameters.description())
                .withTitle(parameters.title())
                .withContactId(parameters.contactId())
                .withClientId(parameters.clientId())
                .withTicketStatus(parameters.status())
                .build();
    }

    @Override
    public NotificationEntity<DeveloperEntity> makeNotificationToDev() {
        String message = "You have a new ticket";

        return new NotificationEntityBuilder<DeveloperEntity>()
                .withMessage(message)
                .withTitle(title)
                .withType(this.ticketType.name())
                .withUserEntity(this.dev.toEntity())
                .build();
    }

    @Override
    public boolean analizeTicket() {
        return false;
    }

    @Override
    public TicketEntity ticketFinished(TicketEntity ticket) {
        ticket.setTicketStatus(TicketStatus.FINISHED);
        return ticket;
    }

    @Override
    public NotificationEntity<SupportEntity> makeNotificationToSupport() {
        String message = "This ticket has been finished by the developer";

        return new NotificationEntityBuilder<SupportEntity>()
                .withMessage(message)
                .withTitle(title)
                .withType(ticketType.name())
                .withUserEntity(new SupportEntity(this.support))
                .build();
    }
}
