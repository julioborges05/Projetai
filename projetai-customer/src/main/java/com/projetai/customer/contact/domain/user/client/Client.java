package com.projetai.customer.contact.domain.user.client;

import com.projetai.customer.contact.domain.user.User;

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
        return id;
    }
}
