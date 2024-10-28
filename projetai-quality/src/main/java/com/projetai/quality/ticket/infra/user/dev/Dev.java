package com.projetai.quality.ticket.infra.user.dev;

import com.projetai.core.domain.user.User;

public class Dev extends User {

    Long id;

    public Dev(String name, String email) {
        super(name, email);
    }
    public Long getId() {
        return id;
    }


}
