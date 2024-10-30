package com.projetai.customer.contact.application;

import com.projetai.core.application.dto.SupportDto;
import com.projetai.core.domain.user.support.Support;
import com.projetai.core.infra.notification.NotificationRepository;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.core.infra.user.support.SupportRepository;
import com.projetai.customer.contact.application.dto.ClientDto;
import com.projetai.customer.contact.application.dto.ContactDto;
import com.projetai.customer.contact.domain.client.Client;
import com.projetai.customer.contact.domain.contact.Contact;
import com.projetai.customer.contact.infra.contact.ContactRepository;
import com.projetai.customer.contact.infra.user.client.ClientEntity;
import com.projetai.customer.contact.infra.user.client.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final SupportRepository supportRepository;
    private final ClientRepository clientRepository;
    private final NotificationRepository<SupportEntity> notificationRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository, SupportRepository supportRepository,
                          ClientRepository clientRepository, NotificationRepository<SupportEntity> notificationRepository) {
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
                .map(Support::dbEntityToSupport)
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

    public List<ClientDto> findAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(Client::dbEntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ClientDto createClient(ClientDto clientDto) {
        ClientEntity client = new ClientEntity(clientDto);
        client.setId(null);

        return Client.dbEntityToDto(clientRepository.save(client));
    }

    public List<SupportDto> findAllSupports() {
        return supportRepository.findAll()
                .stream()
                .map(Support::dbEntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public SupportDto createSupport(SupportDto supportDto) {
        SupportEntity support = new SupportEntity(supportDto);
        support.setId(null);

        return Support.dbEntityToDto(supportRepository.save(support));
    }
}
