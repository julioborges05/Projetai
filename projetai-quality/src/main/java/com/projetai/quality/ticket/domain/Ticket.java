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
import com.projetai.quality.ticket.infra.user.dev.Dev;

public class Ticket implements TicketInterface {

    private final TicketType ticketType;
    private final DeveloperEntity dev;
    private final Long contactId;
    private final String title;


    public Ticket(TicketType ticketType, DeveloperEntity dev, Long contactId, String title) {
        this.ticketType = ticketType;
        this.dev = dev;
        this.contactId = contactId;
        this.title = title;
    }

    public Ticket(TicketEntity ticketEntity) {
        this.ticketType = ticketEntity.getTicketType();
        this.contactId = ticketEntity.getContactId();
        this.title = ticketEntity.getTitle();
        //TODO: criar o dev a partir do banco
        this.dev = new DeveloperEntity("João", "191");
    }

    @Override
    public TicketEntity defineTicketParameters(TicketParametersDto parameters) {
        return new TicketEntityBuilder().withTicketType(parameters.type())
                .withDescription(parameters.description())
                .withTitle(parameters.title())
                .withContactId(parameters.contactId())
                .withMessage(parameters.message())
                .withAuthorId(parameters.authorId())
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
    public void ticketFinished() {

    }

    @Override
    public NotificationEntity<SupportEntity> sendNotificationToSupport() {
        return null;
    }
}
