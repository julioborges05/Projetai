package com.projetai.development.develop.application.dto;

import java.time.LocalDateTime;

public record DevelopmentDto(Long id, Long developerId, Long ticketId, Long techLeadId, LocalDateTime finishedTime,
                             Integer estimatedHours) {
}
