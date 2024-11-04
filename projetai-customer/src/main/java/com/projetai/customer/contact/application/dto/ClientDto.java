package com.projetai.customer.contact.application.dto;

import com.projetai.customer.contact.infra.user.client.ClientEntity;

public record ClientDto(Long id, String name, String email) {

    public ClientDto(ClientEntity clientEntity) {
        this(clientEntity.getId(), clientEntity.getName(), clientEntity.getEmail());
    }

}
