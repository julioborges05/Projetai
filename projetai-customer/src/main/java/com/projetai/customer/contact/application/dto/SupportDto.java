package com.projetai.customer.contact.application.dto;

import com.projetai.customer.contact.domain.user.support.Support;

public record SupportDto(String name, String email) {

    public Support toSupport() {
        return new Support(name, email);
    }

}
