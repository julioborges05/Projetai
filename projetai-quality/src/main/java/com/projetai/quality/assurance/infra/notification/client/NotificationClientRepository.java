package com.projetai.quality.assurance.infra.notification.client;

import com.projetai.quality.assurance.infra.user.client.ClientEntity;
import com.projetai.quality.assurance.infra.notification.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationClientRepository extends JpaRepository<NotificationEntity<ClientEntity>, Long> {
}
