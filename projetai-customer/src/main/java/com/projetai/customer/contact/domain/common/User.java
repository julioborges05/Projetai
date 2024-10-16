package com.projetai.customer.contact.domain.common;

public abstract class User {

    private final String name;
    private final String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
