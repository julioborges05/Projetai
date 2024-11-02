package com.projetai.customer.contact.application.dto;

import com.projetai.customer.contact.domain.contact.type.ContactType;
import com.projetai.customer.contact.infra.contact.ContactEntity;

public record ContactDto(String title, String message, ContactType type, ClientDto clientDto) {

    public ContactDto(ContactEntity contactEntity) {
        this(contactEntity.getTitle(), contactEntity.getMessage(), contactEntity.getType(), new ClientDto(contactEntity.getClientEntity()));
    }

}
