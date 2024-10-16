package com.projetai.customer.contact.application.dto;

import com.projetai.customer.contact.domain.user.client.Client;

public record ClientDto(String name, String email) {

    public Client toClient() {
        return new Client(name, email);
    }

}
