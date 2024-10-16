package com.projetai.customer.contact.application;

import com.projetai.customer.contact.application.dto.ContactDto;
import com.projetai.customer.contact.domain.contact.Contact;
import com.projetai.customer.contact.infra.contact.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void makeContact(ContactDto contactDto) {
        Contact contact = contactDto.toContact();
        contact.makeContact();
        contact.sendNotification();
    }

}
