package com.projetai.development.utils.domain.user.developer;

import com.projetai.core.domain.user.User;
import com.projetai.development.develop.application.dto.DeveloperDto;
import com.projetai.development.utils.infra.user.developer.DeveloperEntity;

public class Developer extends User {

    public Developer(String name, String email) {
        super(name, email);
    }

    public static DeveloperDto dbEntityToDto(DeveloperEntity developer) {
        return new DeveloperDto(developer.getId(), developer.getName(), developer.getEmail());
    }
}
