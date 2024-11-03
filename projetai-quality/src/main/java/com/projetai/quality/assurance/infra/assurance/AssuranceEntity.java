package com.projetai.quality.assurance.infra.assurance;

import com.projetai.quality.assurance.domain.assurance.Assurance;
import com.projetai.quality.assurance.domain.assurance.status.AssuranceStatus;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.support.SupportEntity;
import jakarta.persistence.*;

@Entity(name="assurance")
public class AssuranceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AssuranceStatus status;

    @ManyToOne
    @JoinColumn(name = "developer_entity_id")
    private DeveloperEntity developerEntity;

    @ManyToOne
    @JoinColumn(name = "support_entity_id")
    private SupportEntity supportEntity;

    public Assurance toAssurance() {
        return new Assurance(id, title, message, status, developerEntity, supportEntity);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AssuranceStatus getStatus() {
        return status;
    }

    public void setStatus(AssuranceStatus status) {
        this.status = status;
    }

    public DeveloperEntity getDeveloperEntity() {
        return developerEntity;
    }

    public void setDeveloperEntity(DeveloperEntity developerEntity) {
        this.developerEntity = developerEntity;
    }

    public SupportEntity getSupportEntity() {
        return supportEntity;
    }

    public void setSupportEntity(SupportEntity supportEntity) {
        this.supportEntity = supportEntity;
    }
}