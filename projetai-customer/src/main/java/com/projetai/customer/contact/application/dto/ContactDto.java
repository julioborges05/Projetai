package com.projetai.customer.contact.application.dto;

import com.projetai.customer.contact.domain.contact.Contact;
import com.projetai.customer.contact.domain.contact.Type;

public record ContactDto(
        String title,
        String message,
        Type type,
        ClientDto clientDto
) {

    public Contact toContact() {
        return new Contact(title, message, type, clientDto.toClient());
    }

}
