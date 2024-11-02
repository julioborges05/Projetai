package com.projetai.development.refinement.domain.refinement;

import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.development.refinement.infra.refinement.RefinementEntity;
public interface RefinementInterface {

    RefinementEntity startRefinement();

    RefinementEntity completeRefinement();

    NotificationEntity<SupportEntity> makeNotificationToSupport();
}
