package com.projetai.quality.assurance.domain.assurance;

import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.quality.assurance.infra.assurance.AssuranceEntity;

public interface AssuranceInterface {
    AssuranceEntity startAssurance();

    AssuranceEntity todoAssurance();

    AssuranceEntity completeAssurance();

    NotificationEntity<SupportEntity> makeNotificationSupport();

    NotificationEntity<DeveloperEntity> makeNotificationDeveloper();
}