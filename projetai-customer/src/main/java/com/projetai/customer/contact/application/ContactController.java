package com.projetai.customer.contact.application;

import com.projetai.core.application.dto.SupportDto;
import com.projetai.customer.contact.application.dto.ClientDto;
import com.projetai.customer.contact.application.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    @RequestMapping("/clients")
    public ResponseEntity<List<ClientDto>> findAllClients() {
        return ResponseEntity.ok(contactService.findAllClients());
    }

    @PostMapping
    @RequestMapping("/createClient")
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(contactService.createClient(clientDto));
    }

    @GetMapping
    @RequestMapping("/support")
    public ResponseEntity<List<SupportDto>> findAllSupports() {
        return ResponseEntity.ok(contactService.findAllSupports());
    }

    @PostMapping
    @RequestMapping("/createSupport")
    public ResponseEntity<SupportDto> createSupport(@RequestBody SupportDto supportDto) {
        return ResponseEntity.ok(contactService.createSupport(supportDto));
    }

    @PostMapping
    @RequestMapping("/makeContact")
    public ResponseEntity<String> contact(@RequestBody ContactDto contactDto) {
        contactService.makeContact(contactDto);
        return ResponseEntity.ok("Contact made successfully");
    }
}
