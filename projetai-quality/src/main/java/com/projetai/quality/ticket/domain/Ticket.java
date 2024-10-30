package com.projetai.quality.ticket.domain;


import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.notification.NotificationEntityBuilder;
import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.ticket.TicketEnum.TicketType;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.support.SupportEntity;

import com.projetai.quality.ticket.domain.parameters.TicketParametersDto;
import com.projetai.quality.ticket.infra.user.dev.Dev;

public class Ticket implements TicketInterface {
    private final TicketType ticketType;
    private final Dev dev;
    private final Long contactId;

    public Ticket(TicketType ticketType, Dev dev, Long contactId) {
        this.ticketType = ticketType;
        this.dev = dev;
        this.contactId = contactId;
    }

    public Ticket(TicketEntity ticketEntity) {
        this.ticketType = ticketEntity.getTicketType();
        this.contactId = ticketEntity.getContactId();
//        this.dev = new Dev(ticketEntity.getUser());
        //TODO: criar o dev a partir do banco
        this.dev = new Dev("", "");
    }

    @Override
    public TicketEntity defineTicketParameters(TicketParametersDto parameters) {
        return new TicketEntity(this.contactId);
    }

    @Override
    public NotificationEntity<DeveloperEntity> makeNotificationToDev() {
        String message = "You have a new ticket";

        return new NotificationEntityBuilder<DeveloperEntity>()
                .withMessage(message)
                .withTitle("New ticket")
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
