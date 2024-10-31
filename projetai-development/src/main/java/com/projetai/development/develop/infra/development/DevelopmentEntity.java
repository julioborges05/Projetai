package com.projetai.development.develop.infra.development;

import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.development.develop.domain.development.Development;
import com.projetai.development.develop.domain.development.status.DevelopmentStatus;
import com.projetai.development.develop.domain.development.type.DevelopmentType;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import jakarta.persistence.*;

@Entity
public class DevelopmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private DevelopmentType type;
    private DevelopmentStatus status;

    @ManyToOne
    @JoinColumn(name = "developer_entity_id")
    private DeveloperEntity developerEntity;

    @ManyToOne
    @JoinColumn(name = "support_entity_id")
    private SupportEntity supportEntity;

    public Development toDevelopment() {
        Long idDeveloper = developerEntity.getId();
        Long idSupport = supportEntity.getId();
        return new Development(id, title, message, type, status, idDeveloper, idSupport);
    }
}
