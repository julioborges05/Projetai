package com.projetai.development.refinement.infra.refinement;

import java.time.LocalDateTime;

public class RefinementEntityBuilder {

    private final RefinementEntity refinementEntity = new RefinementEntity();

    public RefinementEntityBuilder withApproval(boolean isApproved) {
        refinementEntity.setApproved(isApproved);
        return this;
    }

    public RefinementEntityBuilder withNecessaryAdjustments(String necessaryAdjustments) {
        refinementEntity.setNecessaryAdjustments(necessaryAdjustments);
        return this;
    }

    public RefinementEntityBuilder withTechLeadUsername(String techLeadUsername) {
        refinementEntity.setTechLeadUsername(techLeadUsername);
        return this;
    }

    public RefinementEntityBuilder withDeveloperUsername(String developerUsername) {
        refinementEntity.setDeveloperUsername(developerUsername);
        return this;
    }

    public RefinementEntityBuilder withStartedTimeAt(LocalDateTime startedTime) {
        refinementEntity.setStartedTime(startedTime);
        return this;
    }

    public RefinementEntityBuilder withFinishedTimeAt(LocalDateTime finishedTime) {
        refinementEntity.setFinishedTime(finishedTime);
        return this;
    }

    public RefinementEntity build() {
        return refinementEntity;
    }
}
