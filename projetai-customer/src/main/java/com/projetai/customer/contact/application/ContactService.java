package com.projetai.customer.contact.application;

import com.projetai.customer.contact.application.dto.ClientDto;
import com.projetai.customer.contact.application.dto.ContactDto;
import com.projetai.customer.contact.domain.contact.Contact;
import com.projetai.customer.contact.domain.user.client.Client;
import com.projetai.customer.contact.domain.user.support.Support;
import com.projetai.customer.contact.infra.contact.ContactEntity;
import com.projetai.customer.contact.infra.contact.ContactRepository;
import com.projetai.customer.contact.infra.user.ClientEntity;
import com.projetai.customer.contact.infra.user.ClientRepository;
import com.projetai.customer.contact.infra.user.SupportEntity;
import com.projetai.customer.contact.infra.user.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final SupportRepository supportRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository, SupportRepository supportRepository,
                          ClientRepository clientRepository) {
        this.contactRepository = contactRepository;
        this.supportRepository = supportRepository;
        this.clientRepository = clientRepository;
    }

    @Transient
    public void makeContact(ContactDto contactDto) {
        Client client = getClientForContact(contactDto.clientDto());
        Support support = getSupportForContact();
        Contact contact = contactDto.toContact();

        contactRepository.save(contact.makeContactFromClientToSupport(client, support));

        contact.sendNotificationTo(support);
    }

    private Support getSupportForContact() {
        return supportRepository.findFirstByAvailableTrue()
                .map(SupportEntity::toSupport)
                .orElseThrow(() -> new RuntimeException("No support available"));
    }

    private Client getClientForContact(ClientDto clientDto) {
        if (clientDto.id() == null) {
            return new Client(clientDto.name(), clientDto.email());
        }

        return clientRepository.findById(clientDto.id())
                .map(ClientEntity::toClient)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

}
