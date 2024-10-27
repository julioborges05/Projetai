package com.projetai.customer.contact.domain.client;

import com.projetai.core.domain.user.User;
import com.projetai.customer.contact.infra.user.client.ClientEntity;

public class Client extends User {

    public Client(String name, String email) {
        super(name, email);
    }

    public static Client dbEntityToClient(ClientEntity entity) {
        return new Client(entity.getName(), entity.getEmail());
    }
}
