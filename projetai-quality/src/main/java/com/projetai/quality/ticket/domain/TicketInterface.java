package com.projetai.quality.ticket.domain;


import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.quality.ticket.infra.TicketEntity;
import com.projetai.quality.ticket.infra.user.dev.DevEntity;

public interface TicketInterface {

    String DefineTicketParameters(String parameters);

    NotificationEntity<DevEntity> SendNotificationToDev();

    boolean AnalizeTicket();

    NotificationEntity<SupportEntity> SendNotificationToSupport();

    void TicketFinished();

}
