package com.projetai.quality.ticket.domain;


import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.notification.NotificationEntityBuilder;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.quality.ticket.domain.type.TicketType;
import com.projetai.quality.ticket.infra.user.dev.Dev;
import com.projetai.quality.ticket.infra.user.dev.DevEntity;

public class Ticket implements TicketInterface{
    TicketType ticketType;
    Dev dev;


    @Override
    public String DefineTicketParameters(String parameters) {
        return "";
    }

    @Override
    public NotificationEntity<DevEntity> SendNotificationToDev() {
        String message = "You have a new ticket";

        return new NotificationEntityBuilder<DevEntity>()
                .withMessage(message)
                .withTitle("New ticket")
                .withType(this.ticketType.name())
                .withUserEntity(new DevEntity(this.dev))
                .build();
    }

    @Override
    public boolean AnalizeTicket() {
        return false;
    }

    @Override
    public void TicketFinished() {

    }

    @Override
    public NotificationEntity<SupportEntity> SendNotificationToSupport() {
        return null;
    }
}
