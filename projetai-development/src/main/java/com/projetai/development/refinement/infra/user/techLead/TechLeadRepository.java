package com.projetai.development.refinement.infra.user.techLead;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechLeadRepository extends JpaRepository<TechLeadEntity, Long> {
}
