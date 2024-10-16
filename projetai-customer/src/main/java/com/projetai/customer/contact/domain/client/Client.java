package com.projetai.customer.contact.domain.client;

import com.projetai.customer.contact.domain.common.User;
import com.projetai.customer.contact.domain.contact.Contact;
import com.projetai.customer.contact.domain.support.Support;

public class Client extends User implements ClientInterface {

    public Client(String name, String email) {
        super(name, email);
    }

    @Override
    public void makeContactTo(Support support) {
        Contact contact = new Contact();
        contact.sendNotificationTo(support);
    }

}
