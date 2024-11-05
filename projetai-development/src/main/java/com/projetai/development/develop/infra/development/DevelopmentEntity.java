package com.projetai.development.develop.infra.development;

import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.development.develop.domain.development.status.DevelopmentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "development")
public class DevelopmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DevelopmentStatus status;

    @Column(name = "developer_id")
    private Long developerId;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticketEntity;

    @Column(name = "started_time")
    private LocalDateTime startedTime;

    @Column(name = "finished_time")
    private LocalDateTime finishedTime;

    @Column(name = "estimated_hours")
    private Integer estimatedHours;

    public DevelopmentEntity() {}

    public DevelopmentEntity(Long id, DevelopmentStatus status, Long developerId, TicketEntity ticketEntity,
                             LocalDateTime startedTime, LocalDateTime finishedTime, Integer estimatedHours) {
        this.id = id;
        this.status = status;
        this.developerId = developerId;
        this.ticketEntity = ticketEntity;
        this.startedTime = startedTime;
        this.finishedTime = finishedTime;
        this.estimatedHours = estimatedHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(Integer estimatedHours) {
        this.estimatedHours = estimatedHours;
    }
}
