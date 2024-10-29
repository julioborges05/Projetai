package com.projetai.quality.assurance.infra.notification.support;

import com.projetai.quality.assurance.infra.user.support.SupportEntity;
import com.projetai.quality.assurance.infra.notification.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationSupportRepository extends JpaRepository<NotificationEntity<SupportEntity>, Long> {
}
