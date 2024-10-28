package com.projetai.core.domain.user.support;

import com.projetai.core.application.dto.SupportDto;
import com.projetai.core.domain.user.User;
import com.projetai.core.infra.user.support.SupportEntity;

public class Support extends User {

    private Long id;
    private boolean isAvailable;

    public Support(String name, String email, boolean isAvailable) {
        super(name, email);
        this.isAvailable = isAvailable;
    }

    public Support(Long id, String name, String email, boolean isAvailable) {
        super(name, email);
        this.isAvailable = isAvailable;
        this.id = id;
    }

    public static Support dbEntityToSupport(SupportEntity entity) {
        return new Support(entity.getId(), entity.getName(), entity.getEmail(), entity.getIsAvailable());
    }

    public static SupportDto dbEntityToDto(SupportEntity support) {
        return new SupportDto(support.getId(), support.getName(), support.getEmail(), support.getIsAvailable());
    }

    public Long getId() {
        return this.id;
    }

    public void makeSupportUserAvailable() {
        this.isAvailable = true;
    }

    public void makeSupportUserUnavailable() {
        this.isAvailable = false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

}
