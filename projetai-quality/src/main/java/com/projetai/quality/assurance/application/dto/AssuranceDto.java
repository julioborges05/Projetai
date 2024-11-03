package com.projetai.quality.assurance.application.dto;

import com.projetai.quality.assurance.domain.assurance.status.AssuranceStatus;
import com.projetai.quality.assurance.infra.assurance.AssuranceEntity;

public record AssuranceDto(Long id, String title, String message, AssuranceStatus status, Long developerId, Long supportId) {
    public AssuranceDto(AssuranceEntity assuranceEntity){
        this(assuranceEntity.getId(), assuranceEntity.getTitle(), assuranceEntity.getMessage(), assuranceEntity.getStatus(), assuranceEntity.getDeveloperEntity().getId(), assuranceEntity.getSupportEntity().getId());
    }
}
