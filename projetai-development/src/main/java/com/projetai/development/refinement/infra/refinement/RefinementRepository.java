package com.projetai.development.refinement.infra.refinement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefinementRepository extends JpaRepository<RefinementEntity, Long> {
}
