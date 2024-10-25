package com.projetai.development.refinement.domain.refinement;

import com.projetai.development.refinement.infra.refinement.RefinementEntity;
import com.projetai.development.utils.infra.notification.NotificationEntity;
import com.projetai.development.utils.infra.user.support.SupportEntity;

public interface RefinementInterface {

    RefinementEntity startRefinement();

    RefinementEntity completeRefinement();

    NotificationEntity<SupportEntity> makeNotification();
}
