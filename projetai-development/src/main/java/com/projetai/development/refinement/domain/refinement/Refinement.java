package com.projetai.development.refinement.domain.refinement;

import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.notification.NotificationEntityBuilder;
import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.development.refinement.infra.refinement.RefinementEntity;
import com.projetai.development.refinement.infra.refinement.RefinementEntityBuilder;

import java.time.LocalDateTime;

public class Refinement implements RefinementInterface {

    private Long id;

    private boolean isApproved;

    private String necessaryAdjustments;

    private Long techLeadId;

    private Long developerId;

    private LocalDateTime startedTime;

    private LocalDateTime finishedTime;

    private TicketEntity ticketEntity;

    private Long supportId;

    public Refinement(Long techLeadId, Long developerId,
                      LocalDateTime startedTime, TicketEntity ticketEntity, Long supportId) {
        this.techLeadId = techLeadId;
        this.developerId = developerId;
        this.startedTime = startedTime;
        this.ticketEntity = ticketEntity;
        this.supportId = supportId;
    }

    public Refinement(Long id, boolean isApproved, String necessaryAdjustments, Long techLeadId,
                      Long developerId, LocalDateTime startedTime, LocalDateTime finishedTime,
                      TicketEntity ticketEntity, Long supportId) {
        this.id = id;
        this.isApproved = isApproved;
        this.necessaryAdjustments = necessaryAdjustments;
        this.techLeadId = techLeadId;
        this.developerId = developerId;
        this.startedTime = startedTime;
        this.finishedTime = finishedTime;
        this.ticketEntity = ticketEntity;
        this.supportId = supportId;
    }

    @Override
    public RefinementEntity startRefinement() {
        return new RefinementEntityBuilder()
                .withTechLeadId(techLeadId)
                .withDeveloperId(developerId)
                .withStartedTimeAt(startedTime)
                .withTicket(ticketEntity)
                .build();
    }

    @Override
    public RefinementEntity completeRefinement() {
        return new RefinementEntityBuilder()
                .withId(id)
                .withApproval(isApproved)
                .withNecessaryAdjustments(necessaryAdjustments)
                .withTechLeadId(techLeadId)
                .withDeveloperId(developerId)
                .withStartedTimeAt(startedTime)
                .withFinishedTimeAt(finishedTime)
                .withTicket(ticketEntity)
                .build();
    }

    @Override
    public NotificationEntity<SupportEntity> makeNotificationToSupport() {
        String message = "Ticket is ready to quality";

        return new NotificationEntityBuilder<SupportEntity>()
                .withMessage(message)
                .withTitle("Ticket Approved!")
                .withUserId(supportId)
                .withType(ticketEntity.getTicketType().name())
                .build();
    }
}
