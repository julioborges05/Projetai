package com.projetai.development.develop.application;

import com.projetai.core.infra.notification.NotificationRepository;
import com.projetai.development.develop.application.dto.DevelopmentDto;
import com.projetai.development.develop.domain.development.Development;
import com.projetai.development.develop.infra.development.DevelopmentEntity;
import com.projetai.development.develop.infra.development.DevelopmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevelopmentService {

    private final DevelopmentRepository developmentRepository;
    private final NotificationRepository notificationRepository;

    @Autowired
    public DevelopmentService(DevelopmentRepository developmentRepository, NotificationRepository notificationRepository) {
        this.developmentRepository = developmentRepository;
        this.notificationRepository = notificationRepository;
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
