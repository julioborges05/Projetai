package com.projetai.quality.assurance.infra.assurance;

import com.projetai.quality.assurance.domain.assurance.status.AssuranceStatus;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.support.SupportEntity;

public class AssuranceEntityBuilder {
    private final AssuranceEntity assuranceEntity = new AssuranceEntity();

    public AssuranceEntityBuilder withTitle(String title) {
        assuranceEntity.setTitle(title);
        return this;
    }

    public AssuranceEntityBuilder withMessage(String message) {
        assuranceEntity.setMessage(message);
        return this;
    }

    public AssuranceEntityBuilder withProgress(AssuranceStatus status) {
        assuranceEntity.setStatus(status);
        return this;
    }

    public AssuranceEntityBuilder withDeveloperEntity(DeveloperEntity developer) {
        assuranceEntity.setDeveloperEntity(developer);
        return this;
    }

    public AssuranceEntityBuilder withSupportEntity(SupportEntity support) {
        assuranceEntity.setSupportEntity(support);
        return this;
    }

    public AssuranceEntity build() {
        return assuranceEntity;
    }
}
