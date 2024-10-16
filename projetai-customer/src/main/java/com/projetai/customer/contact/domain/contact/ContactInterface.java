package com.projetai.customer.contact.domain.contact;

import com.projetai.customer.contact.domain.user.client.Client;
import com.projetai.customer.contact.domain.user.support.Support;
import com.projetai.customer.contact.infra.contact.ContactEntity;

public interface ContactInterface {

    ContactEntity makeContactFromClientToSupport(Client client, Support support);

    void sendNotificationTo(Support support);

}
