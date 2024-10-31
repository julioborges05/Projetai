package com.projetai.development.utils.application.developer;

import com.projetai.core.infra.user.developer.DeveloperEntity;
import com.projetai.core.infra.user.developer.DeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Optional<DeveloperEntity> getDeveloperById(Long id) {
        return developerRepository.findById(id);
    }
}
