package com.projetai.customer.contact.infra.notification;

import com.projetai.customer.contact.infra.user.support.SupportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationEntity<SupportEntity>, Long> {
}
