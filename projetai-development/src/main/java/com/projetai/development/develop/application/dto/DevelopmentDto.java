package com.projetai.development.develop.application.dto;

import com.projetai.development.develop.domain.development.status.DevelopmentStatus;
import com.projetai.development.develop.domain.development.type.DevelopmentType;

import java.time.LocalDateTime;

public record DevelopmentDto(Long id, DevelopmentType developmentType, DevelopmentStatus developmentStatus,
                             Long developerId, Long ticketId, Long techLeadId, LocalDateTime finishedTime,
                             Integer estimatedHours) {
}
