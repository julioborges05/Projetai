package com.projetai.development.develop.application.dto;

import com.projetai.development.develop.domain.development.status.DevelopmentStatus;
import com.projetai.development.develop.domain.development.type.DevelopmentType;

public record DevelopmentDto(Long id, String title, String message, DevelopmentType developmentType, DevelopmentStatus developmentStatus, Long developerId) {
}
