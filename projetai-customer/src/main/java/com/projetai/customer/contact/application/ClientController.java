package com.projetai.customer.contact.application;

import com.projetai.customer.contact.application.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ContactService contactService;

    @Autowired
    public ClientController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> findAllClients() {
        return ResponseEntity.ok(contactService.findAllClients());
    }

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(contactService.createClient(clientDto));
    }

}
