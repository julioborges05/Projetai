package com.projetai.quality.ticket.infra.user.dev;

import com.projetai.core.domain.user.User;

public class Dev extends User {

    private Long id;

    public Dev(String name, String email) {
        super(name, email);
    }

    public Dev(DevEntity devEntity) {
        super(devEntity.getName(), devEntity.getEmail());
        this.id = devEntity.getId();
    }

    public Long getId() {
        return id;
    }


}
