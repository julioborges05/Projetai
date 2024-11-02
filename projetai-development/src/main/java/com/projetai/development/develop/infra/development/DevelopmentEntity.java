package com.projetai.development.develop.infra.development;

import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.development.develop.domain.development.Development;
import com.projetai.development.develop.domain.development.status.DevelopmentStatus;
import com.projetai.development.develop.domain.development.type.DevelopmentType;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class DevelopmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DevelopmentType type;
    private DevelopmentStatus status;

    private Long developerId;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticketEntity;

    private LocalDateTime startedTime;

    private LocalDateTime finishedTime;

    public DevelopmentEntity() {}

    public DevelopmentEntity(Long id, DevelopmentType type, DevelopmentStatus status, Long developerId,
                             TicketEntity ticketEntity, LocalDateTime startedTime, LocalDateTime finishedTime) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.developerId = developerId;
        this.ticketEntity = ticketEntity;
        this.startedTime = startedTime;
        this.finishedTime = finishedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DevelopmentType getType() {
        return type;
    }

    public void setType(DevelopmentType type) {
        this.type = type;
    }

    public DevelopmentStatus getStatus() {
        return status;
    }

    public void setStatus(DevelopmentStatus status) {
        this.status = status;
    }

    public Long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public TicketEntity getTicketEntity() {
        return ticketEntity;
    }

    public void setTicketEntity(TicketEntity ticketEntity) {
        this.ticketEntity = ticketEntity;
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

}
