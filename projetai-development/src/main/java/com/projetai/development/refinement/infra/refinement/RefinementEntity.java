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

    private String userEmail;

    private LocalDateTime startedTime;

    private LocalDateTime finishedTime;

    public RefinementEntity() {}

    public RefinementEntity(Long id, boolean isApproved, String necessaryAdjustments, String techLeadUsername,
                            String userEmail, LocalDateTime startedTime, LocalDateTime finishedTime) {
        this.id = id;
        this.isApproved = isApproved;
        this.necessaryAdjustments = necessaryAdjustments;
        this.techLeadUsername = techLeadUsername;
        this.userEmail = userEmail;
        this.startedTime = startedTime;
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
                && Objects.equals(userEmail, that.userEmail)
                && Objects.equals(startedTime, that.startedTime)
                && Objects.equals(finishedTime, that.finishedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isApproved, necessaryAdjustments, techLeadUsername, userEmail, startedTime, finishedTime);
    }
}
