package com.projetai.development.utils.infra.user.developer;

import com.projetai.development.develop.infra.user.developer.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<DeveloperEntity, Long> {
}
