package com.projetai.customer.contact.infra.user.support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupportRepository extends JpaRepository<SupportEntity, Long> {

    @Query("SELECT s FROM support s WHERE s.isAvailable = true")
    Optional<SupportEntity> findFirstByAvailableTrue();

}
