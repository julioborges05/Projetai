package com.projetai.customer.contact.domain.contact;

import com.projetai.customer.contact.domain.user.client.Client;
import com.projetai.customer.contact.domain.user.support.Support;

public class Contact implements ContactInterface {

    private final String title;
    private final String message;
    private final Type type;
    private final Client client;

    private Support support;

    public Contact(String title, String message, Type type, Client client) {
        this.title = title;
        this.message = message;
        this.type = type;
        this.client = client;
    }

    @Override
    public void makeContactTo(Support support) {
        this.support = support;
    }

    @Override
    public void sendNotificationTo(Support support) {
        this.support = support;
    }

}
