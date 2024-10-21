package com.projetai.development.develop.domain.development;

import com.projetai.development.develop.application.dto.DevelopmentDto;
import com.projetai.development.develop.domain.development.status.DevelopmentStatus;
import com.projetai.development.develop.domain.development.type.DevelopmentType;

public class Development implements DevelopmentInterface {

    private final Long id;
    private final String title;
    private final String message;
    private final DevelopmentType type;
    private final DevelopmentStatus status;
    private final Long developerId;
    private final Long supportId;

    public Development(Long id,
                       String title,
                       String message,
                       DevelopmentType type,
                       DevelopmentStatus status,
                       Long developerId,
                       Long supportId) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.type = type;
        this.status = status;
        this.developerId = developerId;
        this.supportId = supportId;
    }

    @Override
    public Development startDevelopment(DevelopmentDto developmentDto) {
        return null;
    }
}
