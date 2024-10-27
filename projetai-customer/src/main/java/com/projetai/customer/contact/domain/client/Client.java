package com.projetai.customer.contact.domain.client;

import com.projetai.core.domain.user.User;
import com.projetai.customer.contact.application.dto.ClientDto;
import com.projetai.customer.contact.infra.user.client.ClientEntity;

public class Client extends User {

    public Client(String name, String email) {
        super(name, email);
    }

    public static Client dbEntityToClient(ClientEntity entity) {
        return new Client(entity.getName(), entity.getEmail());
    }

    public static ClientDto dbEntityToDto(ClientEntity client) {
        return new ClientDto(client.getId(), client.getName(), client.getEmail());
    }
}
