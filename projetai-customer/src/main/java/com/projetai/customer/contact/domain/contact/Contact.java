package com.projetai.customer.contact.domain.contact;

import com.projetai.customer.contact.domain.contact.type.ContactType;
import com.projetai.customer.contact.domain.user.client.Client;

public class Contact implements ContactInterface {

    private final String title;
    private final String message;
    private final ContactType type;
    private final Client client;

    public Contact(String title, String message, ContactType type, Client client) {
        this.title = title;
        this.message = message;
        this.type = type;
        this.client = client;
    }

    @Override
    public void makeContact() {
    }

    @Override
    public void sendNotification() {
    }

}
