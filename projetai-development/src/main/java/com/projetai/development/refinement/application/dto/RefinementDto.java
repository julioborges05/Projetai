package com.projetai.development.refinement.application.dto;

import java.time.LocalDateTime;

public record RefinementDto(Long id, boolean isApproved, String necessaryAdjustments,
                            Long techLeadId, LocalDateTime spendedTime, Long developerId) {
}
