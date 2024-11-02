package com.projetai.customer.contact.domain.contact;

import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.customer.contact.application.dto.ContactDto;
import com.projetai.customer.contact.infra.contact.ContactEntity;
import com.projetai.customer.contact.infra.user.client.ClientEntity;

public interface ContactInterface {

    ContactEntity makeContact();

    NotificationEntity<SupportEntity> makeNotificationToSupport();

    void replyProblem();

    void closeContact();

    NotificationEntity<ClientEntity> makeNotificationToClient();

}
