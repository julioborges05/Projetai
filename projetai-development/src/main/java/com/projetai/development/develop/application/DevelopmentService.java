package com.projetai.development.develop.application;

import com.projetai.core.infra.notification.NotificationRepository;
import com.projetai.development.develop.application.dto.DeveloperDto;
import com.projetai.development.develop.application.dto.DevelopmentDto;
import com.projetai.development.develop.domain.development.Development;
import com.projetai.development.develop.infra.development.DevelopmentEntity;
import com.projetai.development.develop.infra.development.DevelopmentRepository;
import com.projetai.development.utils.domain.user.developer.Developer;
import com.projetai.development.utils.infra.user.developer.DeveloperEntity;
import com.projetai.development.utils.infra.user.developer.DeveloperRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevelopmentService {

    private final DevelopmentRepository developmentRepository;
    private final DeveloperRepository developerRepository;
    private final NotificationRepository notificationRepository;

    @Autowired
    public DevelopmentService(DevelopmentRepository developmentRepository, DeveloperRepository developerRepository, NotificationRepository notificationRepository) {
        this.developmentRepository = developmentRepository;
        this.developerRepository = developerRepository;
        this.notificationRepository = notificationRepository;
    }

    @Transactional
    public DeveloperDto createDeveloper(DeveloperDto developerDto) {
        DeveloperEntity developer = new DeveloperEntity(developerDto);
        developer.setId(null);

        return Developer.dbEntityToDto(developerRepository.save(developer));
    }

    public void startDevelopment(DevelopmentDto developmentDto) {
        Development development = getDevelopmentById(developmentDto.id());

//        developmentRepository.save(development.startDevelopment(developmentDto));
//        notificationRepository.save(development.makeNotification());
    }

    private Development getDevelopmentById(Long id) {
        return developmentRepository.findById(id)
                .map(DevelopmentEntity::toDevelopment)
                .orElseThrow(() -> new RuntimeException("Development not found"));
    }

    public Development addDetails(DevelopmentDto developmentDto) {
        return null;
    }

    public Development completeDevelopment(DevelopmentDto developmentDto) {
        return null;
    }
}
