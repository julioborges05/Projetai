package com.projetai.quality.ticket.domain;


import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.user.UserEntity;
import com.projetai.quality.ticket.domain.parameters.AnalyzeTicket;
import com.projetai.quality.ticket.domain.parameters.TicketParametersDto;

public interface TicketInterface {

    TicketEntity defineTicketParameters(TicketParametersDto parameters);

    NotificationEntity<UserEntity> makeNotificationToDev();

    TicketEntity analizeTicket(TicketEntity ticket, AnalyzeTicket message);

    TicketEntity ticketFinished(TicketEntity ticket);

    NotificationEntity<UserEntity> makeNotificationToSupport();

    NotificationEntity<UserEntity> makeNotificationToClient();

}
