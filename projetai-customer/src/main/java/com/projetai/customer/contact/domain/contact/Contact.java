package com.projetai.customer.contact.domain.contact;

import com.projetai.customer.contact.application.dto.ContactDto;
import com.projetai.customer.contact.domain.client.Client;
import com.projetai.core.domain.user.support.Support;
import com.projetai.customer.contact.domain.contact.type.ContactType;
import com.projetai.customer.contact.infra.contact.ContactEntity;
import com.projetai.customer.contact.infra.contact.ContactEntityBuilder;
import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.notification.NotificationEntityBuilder;
import com.projetai.customer.contact.infra.user.client.ClientEntity;
import com.projetai.core.infra.user.support.SupportEntity;

public class Contact implements ContactInterface {

    private final Long id;
    private final String title;
    private final String message;
    private final ContactType type;
    private final Client client;
    private final Support support;
    private boolean isClosed;
    private boolean isReplied;

    public Contact(ContactDto contactDto, Client client, Support support) {
        this.id = contactDto.id();
        this.title = contactDto.title();
        this.message = contactDto.message();
        this.type = contactDto.type();
        this.client = client;
        this.support = support;
        this.isClosed = false;
        this.isReplied = false;
    }

    public Contact(ContactEntity contactEntity) {
        this.id = contactEntity.getId();
        this.title = contactEntity.getTitle();
        this.message = contactEntity.getMessage();
        this.type = contactEntity.getType();
        this.client = contactEntity.getClientEntity().toClient();
        this.support = contactEntity.getSupportEntity().toSupport();
        this.isClosed = contactEntity.isClosed();
        this.isReplied = contactEntity.isReplied();
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
                .withClosed(this.isClosed)
                .withReplied(this.isReplied)
                .build();
    }

    @Override
    public NotificationEntity<SupportEntity> makeNotificationToSupport() {
        String message = "New contact from " + this.client.getName() + " with type " + this.type;

        return new NotificationEntityBuilder<SupportEntity>()
                .withTitle("New contact")
                .withMessage(message)
                .withType(this.type.name())
                .withUserEntity(new SupportEntity(this.support))
                .build();
    }

    @Override
    public ContactEntity replyProblem() {
        this.isReplied = true;
        this.support.makeSupportUserAvailable();
        this.isClosed = false;

        return new ContactEntityBuilder()
                .withId(this.id)
                .withTitle(this.title)
                .withMessage(this.message)
                .withType(this.type)
                .withClientEntity(new ClientEntity(this.client))
                .withSupportEntity(new SupportEntity(this.support))
                .withClosed(this.isClosed)
                .withReplied(this.isReplied)
                .build();
    }

    @Override
    public ContactEntity closeContact() {
        this.support.makeSupportUserAvailable();
        this.isClosed = true;

        return new ContactEntityBuilder()
                .withId(this.id)
                .withTitle(this.title)
                .withMessage(this.message)
                .withType(this.type)
                .withClientEntity(new ClientEntity(this.client))
                .withSupportEntity(new SupportEntity(this.support))
                .withClosed(this.isClosed)
                .withReplied(this.isReplied)
                .build();
    }

    @Override
    public NotificationEntity<ClientEntity> makeNotificationToClient() {
        String message = "Contact closed by support " + this.support.getName();

        return new NotificationEntityBuilder<ClientEntity>()
                .withTitle("Contact closed")
                .withMessage(message)
                .withType(this.type.name())
                .withUserEntity(new ClientEntity(this.client))
                .build();
    }

}
