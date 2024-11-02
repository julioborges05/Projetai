package com.projetai.quality.assurance.infra.assurance;

import com.projetai.quality.assurance.domain.assurance.status.AssuranceStatus;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.support.SupportEntity;

public class AssuranceEntityBuilder {
    private final AssuranceEntity assuranceEntity = new AssuranceEntity();

    public AssuranceEntityBuilder withProgress(AssuranceStatus status) {
        assuranceEntity.setStatus(status);
        return this;
    }

    public AssuranceEntityBuilder withApproval(AssuranceStatus status) {
        assuranceEntity.setStatus(status);
        return this;
    }

    public AssuranceEntityBuilder withNecessaryAdjustments(AssuranceStatus status) {
        assuranceEntity.setStatus(status);
        return this;
    }

    public AssuranceEntityBuilder withDeveloperEntity(DeveloperEntity developerEntity) {
        assuranceEntity.setDeveloperEntity(developerEntity);
        return this;
    }

    public AssuranceEntityBuilder withSupportEntity(SupportEntity supportEntity) {
        assuranceEntity.setSupportEntity(supportEntity);
        return this;
    }

    public AssuranceEntity build() {
        return assuranceEntity;
    }
}
