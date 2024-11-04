package com.projetai.customer.contact.infra.contact;

import com.projetai.customer.contact.domain.contact.type.ContactType;
import com.projetai.customer.contact.infra.user.client.ClientEntity;
import com.projetai.core.infra.user.support.SupportEntity;

public class ContactEntityBuilder {

    private final ContactEntity contactEntity = new ContactEntity();

    public ContactEntityBuilder withId(Long id) {
        contactEntity.setId(id);
        return this;
    }

    public ContactEntityBuilder withTitle(String title) {
        contactEntity.setTitle(title);
        return this;
    }

    public ContactEntityBuilder withMessage(String message) {
        contactEntity.setMessage(message);
        return this;
    }

    public ContactEntityBuilder withType(ContactType type) {
        contactEntity.setType(type);
        return this;
    }

    public ContactEntityBuilder withClientEntity(ClientEntity clientEntity) {
        contactEntity.setClientEntity(clientEntity);
        return this;
    }

    public ContactEntityBuilder withSupportEntity(SupportEntity supportEntity) {
        contactEntity.setSupportEntity(supportEntity);
        return this;
    }

    public ContactEntityBuilder withClosed(boolean isClosed) {
        contactEntity.setClosed(isClosed);
        return this;
    }

    public ContactEntityBuilder withReplied(boolean isReplied) {
        contactEntity.setReplied(isReplied);
        return this;
    }

    public ContactEntity build() {
        return contactEntity;
    }
}
