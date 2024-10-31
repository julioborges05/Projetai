package com.projetai.quality.assurance.infra.assurance;

import com.projetai.quality.assurance.domain.assurance.status.AssuranceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuranceRepository extends JpaRepository<AssuranceEntity, Long> {
    Page<AssuranceEntity> findByAssuranceStatus(AssuranceStatus assuranceStatus, Pageable pageable);
}
