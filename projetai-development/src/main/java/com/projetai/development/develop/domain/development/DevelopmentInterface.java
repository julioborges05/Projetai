package com.projetai.development.develop.domain.development;

import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.development.develop.infra.development.DevelopmentEntity;
import com.projetai.development.refinement.infra.user.techLead.TechLeadEntity;

public interface DevelopmentInterface {

    DevelopmentEntity startDevelopment();

    DevelopmentEntity makeAdjustments();

    DevelopmentEntity completeDevelopment();

    DevelopmentEntity addEstimatedHours();

    NotificationEntity<DeveloperEntity> makeNotificationToDev(String necessaryAdjustments, DeveloperEntity developer);

    NotificationEntity<TechLeadEntity> makeNotificationToTechLead();

    NotificationEntity<TechLeadEntity> makeNotificationToClient();
}
