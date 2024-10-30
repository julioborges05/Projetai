package com.projetai.quality.ticket.domain;


import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.quality.ticket.domain.parameters.TicketParametersDto;
import com.projetai.quality.ticket.infra.user.dev.DevEntity;

public interface TicketInterface {

    TicketEntity defineTicketParameters(TicketParametersDto parameters);

    NotificationEntity<DevEntity> makeNotificationToDev();

    boolean analizeTicket();

    NotificationEntity<SupportEntity> sendNotificationToSupport();

    void ticketFinished();

}
