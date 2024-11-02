package com.projetai.development.refinement.infra.refinement;

import com.projetai.core.infra.ticket.TicketEntity;

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

    public RefinementEntityBuilder withTechLeadId(Long techLeadId) {
        refinementEntity.setTechLeadId(techLeadId);
        return this;
    }

    public RefinementEntityBuilder withDeveloperId(Long developerId) {
        refinementEntity.setDeveloperId(developerId);
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

    public RefinementEntityBuilder withTicket(TicketEntity ticketEntity) {
        refinementEntity.setTicketEntity(ticketEntity);
        return this;
    }

    public RefinementEntity build() {
        return refinementEntity;
    }
}
