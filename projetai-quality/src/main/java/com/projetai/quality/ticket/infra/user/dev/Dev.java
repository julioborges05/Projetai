package com.projetai.quality.ticket.infra.user.dev;

import com.projetai.core.domain.user.User;
import com.projetai.core.infra.user.developer.DeveloperEntity;

public class Dev extends User {

    private Long id;

    public Dev(String name, String email) {
        super(name, email);
    }

    public Dev(DeveloperEntity devEntity) {
        super(devEntity.getName(), devEntity.getEmail());
        this.id = devEntity.getId();
    }

    public DeveloperEntity toEntity() {
        return new DeveloperEntity(this.getName(), this.getEmail());
    }

    public Long getId() {
        return id;
    }


}
