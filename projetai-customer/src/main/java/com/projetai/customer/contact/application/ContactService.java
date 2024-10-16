package com.projetai.customer.contact.application;

import com.projetai.customer.contact.domain.client.Client;
import com.projetai.customer.contact.domain.support.Support;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    public void makeContact() {
        Support support = new Support("Support", "helpdesk@projetai.com");

        Client client = new Client("John Doe", "johndoe@gmail.com");
        client.makeContactTo(support);
    }

}
