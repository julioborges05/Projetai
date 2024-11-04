package com.projetai.customer.contact.application.dto;

import com.projetai.customer.contact.domain.contact.type.ContactType;
import com.projetai.customer.contact.infra.contact.ContactEntity;

public record ContactDto(Long id, String title, String message, ContactType type, ClientDto clientDto, boolean closed) {

    public ContactDto(ContactEntity contactEntity) {
        this(
                contactEntity.getId(),
                contactEntity.getTitle(),
                contactEntity.getMessage(),
                contactEntity.getType(),
                new ClientDto(contactEntity.getClientEntity()),
                contactEntity.isClosed()
        );
    }

}
