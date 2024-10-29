package com.projetai.quality.assurance.infra.assurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuranceRepository extends JpaRepository<AssuranceEntity, Long> {
}
