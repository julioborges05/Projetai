package com.projetai.quality.ticket.infra.user.dev;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DevRepository extends JpaRepository<DevEntity, Long> {
}
