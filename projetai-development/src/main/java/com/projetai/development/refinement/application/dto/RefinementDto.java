package com.projetai.development.refinement.application.dto;

import com.projetai.development.develop.domain.development.status.DevelopmentStatus;
import com.projetai.development.develop.domain.development.type.DevelopmentType;

import java.time.LocalDateTime;

public record RefinementDto(Long id, boolean isApproved, String necessaryAdjustments,
                            Long techLeadId, LocalDateTime spendedTime, Long developerId) {
}
