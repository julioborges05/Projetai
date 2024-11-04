package com.projetai.customer.contact.application;

import com.projetai.customer.contact.application.dto.ContactAnalysisDto;
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

    @PostMapping("/makeContact")
    public ResponseEntity<String> contact(@RequestBody ContactDto contactDto) {
        contactService.makeContact(contactDto);
        return ResponseEntity.ok("Contact made successfully");
    }

    @PostMapping("replyProblem")
    public ResponseEntity<String> replyProblem(@RequestBody ContactAnalysisDto contactAnalysis) {
        contactService.replyProblem(contactAnalysis);
        return ResponseEntity.ok("Problem replied successfully");
    }

    @GetMapping("/findContact")
    public ResponseEntity<ContactDto> findContact(@RequestParam Long id) {
        return ResponseEntity.ok(contactService.findContact(id));
    }

    @GetMapping
    public ResponseEntity<List<ContactDto>> findAll() {
        return ResponseEntity.ok(contactService.findAll());
    }

}
