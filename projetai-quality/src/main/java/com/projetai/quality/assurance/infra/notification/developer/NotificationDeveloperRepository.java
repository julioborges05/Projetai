package com.projetai.quality.assurance.infra.notification.developer;

import com.projetai.quality.assurance.infra.user.developer.DeveloperEntity;
import com.projetai.quality.assurance.infra.notification.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationDeveloperRepository extends JpaRepository<NotificationEntity<DeveloperEntity>, Long> {
}
