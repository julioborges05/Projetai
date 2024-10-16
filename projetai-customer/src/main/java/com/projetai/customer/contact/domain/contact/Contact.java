package com.projetai.customer.contact.domain.contact;

import com.projetai.customer.contact.domain.contact.type.ContactType;
import com.projetai.customer.contact.domain.user.client.Client;
import com.projetai.customer.contact.domain.user.support.Support;
import com.projetai.customer.contact.infra.contact.ContactEntity;
import com.projetai.customer.contact.infra.contact.ContactEntityBuilder;
import com.projetai.customer.contact.infra.user.ClientEntity;
import com.projetai.customer.contact.infra.user.SupportEntity;

public class Contact implements ContactInterface {

    private final String title;
    private final String message;
    private final ContactType type;

    public Contact(String title, String message, ContactType type) {
        this.title = title;
        this.message = message;
        this.type = type;
    }

    @Override
    public ContactEntity makeContactFromClientToSupport(Client client, Support support) {
        support.makeSupportUserUnavailable();

        return new ContactEntityBuilder()
                .withTitle(this.title)
                .withMessage(this.message)
                .withType(this.type)
                .withClientEntity(new ClientEntity(client.getId(), client.getName(), client.getEmail()))
                .withSupportEntity(new SupportEntity(support.getName(), support.getEmail(), support.isAvailable()))
                .build();
    }

    @Override
    public void sendNotificationTo(Support support) {
    }

}
