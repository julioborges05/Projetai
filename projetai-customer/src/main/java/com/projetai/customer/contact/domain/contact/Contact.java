package com.projetai.customer.contact.domain.contact;

import com.projetai.customer.contact.application.dto.ContactDto;
import com.projetai.customer.contact.domain.contact.type.ContactType;
import com.projetai.customer.contact.domain.user.client.Client;
import com.projetai.customer.contact.domain.user.support.Support;
import com.projetai.customer.contact.infra.contact.ContactEntity;
import com.projetai.customer.contact.infra.contact.ContactEntityBuilder;
import com.projetai.customer.contact.infra.notification.NotificationEntity;
import com.projetai.customer.contact.infra.notification.NotificationEntityBuilder;
import com.projetai.customer.contact.infra.user.client.ClientEntity;
import com.projetai.customer.contact.infra.user.support.SupportEntity;

public class Contact implements ContactInterface {

    private final String title;
    private final String message;
    private final ContactType type;
    private final Client client;
    private final Support support;

    public Contact(ContactDto contactDto, Client client, Support support) {
        this.title = contactDto.title();
        this.message = contactDto.message();
        this.type = contactDto.type();
        this.client = client;
        this.support = support;
    }

    @Override
    public ContactEntity makeContact() {
        support.makeSupportUserUnavailable();

        return new ContactEntityBuilder()
                .withTitle(this.title)
                .withMessage(this.message)
                .withType(this.type)
                .withClientEntity(new ClientEntity(this.client))
                .withSupportEntity(new SupportEntity(this.support))
                .build();
    }

    @Override
    public NotificationEntity<SupportEntity> makeNotificationToSupport() {
        String message = "New contact from " + this.client.getName() + " with type " + this.type;

        return new NotificationEntityBuilder<SupportEntity>()
                .withTitle("New contact")
                .withMessage(message)
                .withType(this.type)
                .withUserEntity(new SupportEntity(this.support))
                .build();
    }

    @Override
    public ContactEntity findContact() {
        return null;
    }

    @Override
    public void replyProblem() {

    }

    @Override
    public void closeContact() {

    }

    @Override
    public NotificationEntity<ClientEntity> makeNotificationToClient() {
        return null;
    }

}
