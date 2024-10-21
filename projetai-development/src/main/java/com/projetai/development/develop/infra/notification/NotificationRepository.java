package com.projetai.development.develop.infra.notification;

import com.projetai.development.develop.infra.user.support.SupportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity<SupportEntity>, Long> {
}
