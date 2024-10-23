package com.projetai.quality.ticket.infra.notification;


import com.projetai.quality.ticket.infra.user.dev.DevEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//ARRUMAR
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
}
