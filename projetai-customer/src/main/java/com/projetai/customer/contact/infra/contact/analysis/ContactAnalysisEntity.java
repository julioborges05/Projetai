package com.projetai.customer.contact.infra.contact.analysis;

import com.projetai.customer.contact.domain.contact.analysis.ContactAnalysis;
import jakarta.persistence.*;

@Entity(name = "contact_analysis")
public class ContactAnalysisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long contactId;
    @Column(name = "is_replied")
    private boolean isReplied;
    private String comment;

    public ContactAnalysisEntity() {
    }

    public ContactAnalysisEntity(Long contactId, boolean isReplied, String comment) {
        this.contactId = contactId;
        this.isReplied = isReplied;
        this.comment = comment;
    }

    public ContactAnalysisEntity(ContactAnalysis contactAnalysis) {
        this.contactId = contactAnalysis.getContactId();
        this.isReplied = contactAnalysis.isReplied();
        this.comment = contactAnalysis.getComment();
    }
}
