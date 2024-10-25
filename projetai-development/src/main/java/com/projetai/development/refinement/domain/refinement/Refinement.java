package com.projetai.development.refinement.domain.refinement;

import com.projetai.development.refinement.infra.refinement.RefinementEntity;
import com.projetai.development.refinement.infra.refinement.RefinementEntityBuilder;
import com.projetai.development.utils.infra.notification.NotificationEntity;
import com.projetai.development.utils.infra.user.support.SupportEntity;

import java.time.LocalDateTime;

public class Refinement implements RefinementInterface {

    private boolean isApproved;

    private String necessaryAdjustments;

    private String techLeadUsername;

    private String developerUsername;

    private LocalDateTime startedTime;

    private LocalDateTime finishedTime;

    public Refinement(String techLeadUsername, String developerUsername, LocalDateTime startedTime) {
        this.techLeadUsername = techLeadUsername;
        this.developerUsername = developerUsername;
        this.startedTime = startedTime;
    }

    public Refinement(boolean isApproved, String necessaryAdjustments, String techLeadUsername,
                      String developerUsername, LocalDateTime startedTime, LocalDateTime finishedTime) {
        this.isApproved = isApproved;
        this.necessaryAdjustments = necessaryAdjustments;
        this.techLeadUsername = techLeadUsername;
        this.developerUsername = developerUsername;
        this.startedTime = startedTime;
        this.finishedTime = finishedTime;
    }

    @Override
    public RefinementEntity startRefinement() {
        return new RefinementEntityBuilder()
                .withTechLeadUsername(techLeadUsername)
                .withDeveloperUsername(developerUsername)
                .withStartedTimeAt(startedTime)
                .build();
    }

    @Override
    public RefinementEntity completeRefinement() {
        return new RefinementEntityBuilder()
                .withApproval(isApproved)
                .withNecessaryAdjustments(necessaryAdjustments)
                .withTechLeadUsername(techLeadUsername)
                .withDeveloperUsername(developerUsername)
                .withStartedTimeAt(startedTime)
                .withFinishedTimeAt(finishedTime)
                .build();
    }

    @Override
    public NotificationEntity<SupportEntity> makeNotification() {
        return null;
    }
}
