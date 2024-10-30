package com.projetai.core.infra.notification;

import com.projetai.core.infra.user.UserEntity;
import com.projetai.core.infra.user.UserInterface;
import com.projetai.core.infra.user.support.SupportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository<U extends UserEntity & UserInterface> extends JpaRepository<NotificationEntity<U>, Long> {
}
