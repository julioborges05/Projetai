package com.projetai.customer.contact.application;

import com.projetai.customer.contact.application.dto.ClientDto;
import com.projetai.customer.contact.application.dto.ContactDto;
import com.projetai.customer.contact.domain.contact.Contact;
import com.projetai.customer.contact.domain.user.client.Client;
import com.projetai.customer.contact.domain.user.support.Support;
import com.projetai.customer.contact.infra.contact.ContactRepository;
import com.projetai.customer.contact.infra.notification.NotificationRepository;
import com.projetai.customer.contact.infra.user.client.ClientEntity;
import com.projetai.customer.contact.infra.user.client.ClientRepository;
import com.projetai.customer.contact.infra.user.support.SupportEntity;
import com.projetai.customer.contact.infra.user.support.SupportRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final SupportRepository supportRepository;
    private final ClientRepository clientRepository;
    private final NotificationRepository notificationRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository, SupportRepository supportRepository,
                          ClientRepository clientRepository, NotificationRepository notificationRepository) {
        this.contactRepository = contactRepository;
        this.supportRepository = supportRepository;
        this.clientRepository = clientRepository;
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    public void makeContact(ContactDto contactDto) {
        Client client = getClientForContact(contactDto.clientDto());
        Support support = getSupportForContact();
        Contact contact = new Contact(contactDto, client, support);

        contactRepository.save(contact.makeContact());
        notificationRepository.save(contact.makeNotificationToSupport());
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
