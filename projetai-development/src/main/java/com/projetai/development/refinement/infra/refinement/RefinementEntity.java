package com.projetai.development.refinement.infra.refinement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "refinement")
public class RefinementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isApproved;

    private String necessaryAdjustments;

    private String techLeadUsername;

    private String developerUsername;

    private LocalDateTime startedTime;

    private LocalDateTime finishedTime;

    public RefinementEntity() {}

    public RefinementEntity(Long id, boolean isApproved, String necessaryAdjustments, String techLeadUsername,
                            String developerUsername, LocalDateTime startedTime, LocalDateTime finishedTime) {
        this.id = id;
        this.isApproved = isApproved;
        this.necessaryAdjustments = necessaryAdjustments;
        this.techLeadUsername = techLeadUsername;
        this.developerUsername = developerUsername;
        this.startedTime = startedTime;
        this.finishedTime = finishedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getNecessaryAdjustments() {
        return necessaryAdjustments;
    }

    public void setNecessaryAdjustments(String necessaryAdjustments) {
        this.necessaryAdjustments = necessaryAdjustments;
    }

    public String getTechLeadUsername() {
        return techLeadUsername;
    }

    public void setTechLeadUsername(String techLeadUsername) {
        this.techLeadUsername = techLeadUsername;
    }

    public String getDeveloperUsername() {
        return developerUsername;
    }

    public void setDeveloperUsername(String developerUsername) {
        this.developerUsername = developerUsername;
    }

    public LocalDateTime getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(LocalDateTime startedTime) {
        this.startedTime = startedTime;
    }

    public LocalDateTime getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(LocalDateTime finishedTime) {
        this.finishedTime = finishedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RefinementEntity that = (RefinementEntity) o;

        return isApproved == that.isApproved
                && Objects.equals(id, that.id)
                && Objects.equals(necessaryAdjustments, that.necessaryAdjustments)
                && Objects.equals(techLeadUsername, that.techLeadUsername)
                && Objects.equals(developerUsername, that.developerUsername)
                && Objects.equals(startedTime, that.startedTime)
                && Objects.equals(finishedTime, that.finishedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isApproved, necessaryAdjustments, techLeadUsername, developerUsername, startedTime, finishedTime);
    }
}
