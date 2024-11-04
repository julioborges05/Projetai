package com.projetai.development.refinement.infra.refinement;

import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.development.refinement.application.dto.RefinementDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "refinement")
public class RefinementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_approved")
    private boolean isApproved;

    @Column(name = "necessary_adjustments")
    private String necessaryAdjustments;

    @Column(name = "tech_lead_id")
    private Long techLeadId;

    @Column(name = "developer_id")
    private Long developerId;

    @Column(name = "started_time")
    private LocalDateTime startedTime;

    @Column(name = "finished_time")
    private LocalDateTime finishedTime;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticketEntity;

    public RefinementEntity() {}

    public RefinementEntity(Long id, boolean isApproved, String necessaryAdjustments, Long techLeadId,
                            Long developerId, LocalDateTime startedTime, LocalDateTime finishedTime,
                            TicketEntity ticketEntity) {
        this.id = id;
        this.isApproved = isApproved;
        this.necessaryAdjustments = necessaryAdjustments;
        this.techLeadId = techLeadId;
        this.developerId = developerId;
        this.startedTime = startedTime;
        this.finishedTime = finishedTime;
        this.ticketEntity = ticketEntity;
    }

    public RefinementEntity(RefinementDto refinementDto) {
        this.id = refinementDto.id();
        this.isApproved = refinementDto.isApproved();
        this.necessaryAdjustments = refinementDto.necessaryAdjustments();
        this.techLeadId = refinementDto.techLeadId();
        this.developerId = refinementDto.developerId();
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

    public Long getTechLeadId() {
        return techLeadId;
    }

    public void setTechLeadId(Long techLeadId) {
        this.techLeadId = techLeadId;
    }

    public Long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
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

    public TicketEntity getTicketEntity() {
        return ticketEntity;
    }

    public void setTicketEntity(TicketEntity ticketEntity) {
        this.ticketEntity = ticketEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RefinementEntity that = (RefinementEntity) o;

        return isApproved == that.isApproved
                && Objects.equals(id, that.id)
                && Objects.equals(necessaryAdjustments, that.necessaryAdjustments)
                && Objects.equals(techLeadId, that.techLeadId)
                && Objects.equals(developerId, that.developerId)
                && Objects.equals(startedTime, that.startedTime)
                && Objects.equals(finishedTime, that.finishedTime)
                && Objects.equals(ticketEntity, that.ticketEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isApproved, necessaryAdjustments, techLeadId,
                developerId, startedTime, finishedTime, ticketEntity);
    }
}
