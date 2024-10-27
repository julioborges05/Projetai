package com.projetai.core.infra.notification;

import com.projetai.core.infra.user.support.SupportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity<SupportEntity>, Long> {
}
