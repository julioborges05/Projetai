package com.projetai.quality.assurance.domain.assurance;

import com.projetai.quality.assurance.infra.assurance.AssuranceEntity;
import com.projetai.quality.assurance.infra.user.support.SupportEntity;
import com.projetai.quality.assurance.infra.user.developer.DeveloperEntity;
import com.projetai.quality.assurance.infra.user.client.ClientEntity;
import com.projetai.quality.assurance.infra.notification.NotificationEntity;

public interface AssuranceInterface {
    AssuranceEntity startAssurance();

    AssuranceEntity todoAssurance();

    AssuranceEntity completeAssurance();

    NotificationEntity<SupportEntity> makeNotificationSupport();

    NotificationEntity<DeveloperEntity> makeNotificationDeveloper();

    NotificationEntity<ClientEntity> makeNotificationClient();
}