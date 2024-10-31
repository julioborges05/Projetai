package com.projetai.quality.assurance.application.dto;

import com.projetai.quality.assurance.domain.assurance.status.AssuranceStatus;

public record AssuranceDto(Long id, String title, String message, AssuranceStatus status, Long developerId, Long supportId) {
}
