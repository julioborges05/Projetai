package com.projetai.quality.ticket.domain;


import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.notification.NotificationEntityBuilder;
import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.ticket.TicketEnum.TicketStatus;
import com.projetai.core.infra.ticket.TicketEnum.TicketType;
import com.projetai.core.infra.user.UserEntity;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.support.SupportEntity;

import com.projetai.quality.ticket.domain.parameters.AnalyzeTicket;
import com.projetai.quality.ticket.domain.parameters.DevAnalyses;
import com.projetai.quality.ticket.domain.parameters.TicketParametersDto;
import com.projetai.quality.ticket.infra.TicketEntityBuilder;


public class Ticket implements TicketInterface {

    private final TicketType ticketType;
    private DeveloperEntity dev;
    private final Long contactId;
    private final String title;
    private SupportEntity support;
    private Long clientId;


    public Ticket(TicketParametersDto parameters, DeveloperEntity dev) {
        this.ticketType = parameters.type();
        this.dev = dev;
        this.contactId = parameters.contactId();
        this.title = parameters.title();
    }

    public Ticket(TicketEntity ticket, DeveloperEntity developer) {
        this.ticketType = ticket.getTicketType();
        this.dev = developer;
        this.contactId = ticket.getContactId();
        this.title = ticket.getTitle();
    }

    public Ticket(TicketEntity ticket, SupportEntity support){
        this.ticketType = ticket.getTicketType();
        this.contactId = ticket.getContactId();
        this.title = ticket.getTitle();
        this.support = support;
    }

    public void setClientId(Long clientId){
        this.clientId = clientId;
    }


    @Override
    public TicketEntity defineTicketParameters(TicketParametersDto parameters) {
        return new TicketEntityBuilder().withTicketType(parameters.type())
                .withDescription(parameters.description())
                .withTitle(parameters.title())
                .withContactId(parameters.contactId())
                .withClientId(parameters.clientId())
                .withTicketStatus(parameters.status())
                .withDevId(parameters.userNotifiedId())
                .build();
    }

    @Override
    public NotificationEntity<UserEntity> makeNotificationToDev() {
        String message = "You have a new ticket";

        return new NotificationEntityBuilder<UserEntity>()
                .withMessage(message)
                .withTitle(title)
                .withType(this.ticketType.name())
                .withUserEntity(this.dev.toEntity())
                .build();
    }

    @Override
    public TicketEntity analizeTicket(TicketEntity ticket, AnalyzeTicket message) {
        if(message.analyses() == DevAnalyses.REJECTED){
            ticket.setTicketStatus(TicketStatus.FINISHED);
            return ticket;
        }
        ticket.setTicketStatus(TicketStatus.IN_PROGRESS);
        return ticket;
    }

    @Override
    public TicketEntity ticketFinished(TicketEntity ticket) {
        ticket.setTicketStatus(TicketStatus.FINISHED);
        return ticket;
    }

    @Override
    public NotificationEntity<UserEntity> makeNotificationToSupport() {
        String message = "This ticket has been finished by the developer";

        return new NotificationEntityBuilder<UserEntity>()
                .withMessage(message)
                .withTitle(title)
                .withType(ticketType.name())
                .withUserEntity(new SupportEntity(this.support))
                .build();
    }

    @Override
    public NotificationEntity<UserEntity> makeNotificationToClient() {
        String message = "Your contact has been finished";

        return new NotificationEntityBuilder<UserEntity>()
                .withMessage(message)
                .withTitle(title)
                .withType(ticketType.name())
                .withUserId(this.clientId)
                .build();
    }
}
