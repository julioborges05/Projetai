package com.projetai.customer.contact.domain.client;

import com.projetai.core.domain.user.User;
import com.projetai.customer.contact.application.dto.ClientDto;
import com.projetai.customer.contact.infra.user.client.ClientEntity;

public class Client extends User {

    private Long id;

    public Client(String name, String email) {
        super(name, email);
    }

    public Client(Long id, String name, String email) {
        super(name, email);
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public static Client dbEntityToClient(ClientEntity entity) {
        return new Client(entity.getName(), entity.getEmail());
    }

    public static ClientDto dbEntityToDto(ClientEntity client) {
        return new ClientDto(client.getId(), client.getName(), client.getEmail());
    }
}
