package com.projetai.core.domain.user.support;

import com.projetai.core.domain.user.User;
import com.projetai.core.infra.user.support.SupportEntity;

public class Support extends User {

    private boolean isAvailable;

    public Support(String name, String email, boolean isAvailable) {
        super(name, email);
        this.isAvailable = isAvailable;
    }

    public static Support dbEntityToSupport(SupportEntity entity) {
        return new Support(entity.getName(), entity.getEmail(), entity.getIsAvailable());
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
