package com.projetai.quality.assurance.infra.assurance;

import com.projetai.quality.assurance.domain.assurance.status.AssuranceStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssuranceRepository extends JpaRepository<AssuranceEntity, Long> {
   @Query("SELECT a FROM assurance a WHERE a.status = :status")
   Page<AssuranceEntity> findByAssuranceStatus(AssuranceStatus status, Pageable pageable);
}
