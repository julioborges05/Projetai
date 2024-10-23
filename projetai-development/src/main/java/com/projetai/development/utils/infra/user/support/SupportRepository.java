package com.projetai.development.utils.infra.user.support;

import com.projetai.development.develop.infra.user.support.SupportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<SupportEntity, Long> {
}
