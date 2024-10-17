package com.projetai.customer.contact.application.dto;

import com.projetai.customer.contact.domain.contact.type.ContactType;

public record ContactDto(String title, String message, ContactType type, ClientDto clientDto) {
}
