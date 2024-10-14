package com.projetai.development.develop.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopmentRepository extends JpaRepository<DevelopmentEntity, Long> {
}
