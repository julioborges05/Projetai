package com.projetai.quality.assurance.domain.user.support;

import com.projetai.quality.assurance.domain.user.User;

public class Support extends User {
    private boolean isAvailable;

    public Support(String name, String email, boolean isAvailable) {
        super(name, email);
        this.isAvailable = isAvailable;
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