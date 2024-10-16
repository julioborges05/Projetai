package com.projetai.customer.contact.application;

import com.projetai.customer.contact.application.dto.ContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    @RequestMapping("/makeContact")
    public ResponseEntity<String> contact(@RequestBody ContactDto contactDto) {
        contactService.makeContact(contactDto);
        return ResponseEntity.ok("Contact made successfully");
    }

}
