package com.projetai.development.refinement.application.refinement;

import com.projetai.development.refinement.application.dto.RefinementDto;
import com.projetai.development.refinement.application.user.TechLeadService;
import com.projetai.development.refinement.infra.refinement.RefinementEntity;
import com.projetai.development.refinement.infra.user.techLead.TechLeadEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RefinementService {

    private final TechLeadService techLeadService;

    public RefinementService(TechLeadService techLeadService) {
        this.techLeadService = techLeadService;
    }

    public void startRefinement(RefinementDto refinementDto) {
        Optional<TechLeadEntity> techLead = techLeadService.getTechLeadById(refinementDto.techLeadId());

        RefinementEntity refinement = new RefinementEntity();


    }
}
