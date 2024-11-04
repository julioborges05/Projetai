package com.projetai.customer.contact.application.dto;

public record ContactAnalysisDto(boolean isReplied, String comment, Long contactId) {
}
