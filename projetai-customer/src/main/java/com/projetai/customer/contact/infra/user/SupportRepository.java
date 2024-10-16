package com.projetai.customer.contact.infra.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupportRepository extends JpaRepository<SupportEntity, Long> {

    Optional<SupportEntity> findFirstByAvailableTrue();

}
