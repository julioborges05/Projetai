package com.projetai.customer.contact.domain.contact;

import com.projetai.customer.contact.infra.contact.ContactEntity;
import com.projetai.customer.contact.infra.notification.NotificationEntity;
import com.projetai.customer.contact.infra.user.client.ClientEntity;
import com.projetai.customer.contact.infra.user.support.SupportEntity;

public interface ContactInterface {

    ContactEntity makeContact();

    NotificationEntity<SupportEntity> makeNotificationToSupport();

    ContactEntity findContact();

    void replyProblem();

    void closeContact();

    NotificationEntity<ClientEntity> makeNotificationToClient();

}
