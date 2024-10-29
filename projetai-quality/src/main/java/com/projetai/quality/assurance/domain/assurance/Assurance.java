package com.projetai.quality.assurance.domain.assurance;

import com.projetai.quality.assurance.domain.assurance.status.AssuranceStatus;
import com.projetai.quality.assurance.infra.user.support.SupportEntity;
import com.projetai.quality.assurance.infra.user.developer.DeveloperEntity;
import com.projetai.quality.assurance.infra.user.client.ClientEntity;
import com.projetai.quality.assurance.infra.notification.NotificationEntity;
import com.projetai.quality.assurance.infra.assurance.AssuranceEntityBuilder;

public class Assurance {
    private final Long id;
    private final String title;
    private final String message;
    private final AssuranceStatus status;
    private final DeveloperEntity developerEntity;
    private final SupportEntity supportEntity;

    public Assurance(Long id, String title, String message, AssuranceStatus status, DeveloperEntity developerEntity, SupportEntity supportEntity) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.status = status;
        this.developerEntity = developerEntity;
        this.supportEntity = supportEntity;
    }

    public AssuranceEntityBuilder startAssurance() {
        return new AssuranceEntityBuilder()
                .withProgress(AssuranceStatus.IN_PROGRESS)
                .withDeveloperEntity(developerEntity)
                .withSupportEntity(supportEntity);
    }

    public AssuranceEntityBuilder todoAssurance() {
        return new AssuranceEntityBuilder()
                .withProgress(AssuranceStatus.TODO)
                .withDeveloperEntity(developerEntity)
                .withSupportEntity(supportEntity);
    }

    public AssuranceEntityBuilder completeAssurance() {
        return new AssuranceEntityBuilder()
                .withProgress(AssuranceStatus.FINISHED)
                .withDeveloperEntity(developerEntity)
                .withSupportEntity(supportEntity);
    }

    public NotificationEntity<SupportEntity> makeNotificationSupport() {
        return null;
    }

    public NotificationEntity<DeveloperEntity> makeNotificationDeveloper() {
        return null;
    }

    public NotificationEntity<ClientEntity> makeNotificationClient() {
        return null;
    }
}
