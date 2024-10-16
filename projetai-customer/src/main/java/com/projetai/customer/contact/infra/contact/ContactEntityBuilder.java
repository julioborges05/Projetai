package com.projetai.customer.contact.infra.contact;

import com.projetai.customer.contact.domain.contact.type.ContactType;
import com.projetai.customer.contact.infra.user.ClientEntity;
import com.projetai.customer.contact.infra.user.SupportEntity;

public class ContactEntityBuilder {

    private final ContactEntity contactEntity = new ContactEntity();

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

    public ContactEntity build() {
        return contactEntity;
    }
}
