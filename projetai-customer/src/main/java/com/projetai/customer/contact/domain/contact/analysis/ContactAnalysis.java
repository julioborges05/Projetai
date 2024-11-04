package com.projetai.customer.contact.domain.contact.analysis;

import com.projetai.customer.contact.application.dto.ContactAnalysisDto;
import com.projetai.customer.contact.infra.contact.analysis.ContactAnalysisEntity;

public class ContactAnalysis {

    private final Long contactId;
    private final boolean isReplied;
    private final String comment;

    public ContactAnalysis(Long contactId, boolean isReplied, String comment) {
        this.contactId = contactId;
        this.isReplied = isReplied;
        this.comment = comment;
    }

    public ContactAnalysis(ContactAnalysisDto contactAnalysisDto) {
        this.contactId = contactAnalysisDto.contactId();
        this.isReplied = contactAnalysisDto.isReplied();
        this.comment = contactAnalysisDto.comment();
    }

    public ContactAnalysisEntity makeContactAnalysis() {
        return new ContactAnalysisEntity(this.contactId, this.isReplied, this.comment);
    }

    public Long getContactId() {
        return contactId;
    }

    public boolean isReplied() {
        return isReplied;
    }

    public String getComment() {
        return comment;
    }
}
