package com.projetai.development.refinement.application.refinement;

import com.projetai.development.refinement.application.dto.RefinementDto;
import com.projetai.development.refinement.application.user.TechLeadService;
import com.projetai.development.refinement.domain.refinement.Refinement;
import com.projetai.development.refinement.infra.refinement.RefinementRepository;
import com.projetai.development.refinement.infra.user.techLead.TechLeadEntity;
import com.projetai.development.utils.application.developer.DeveloperService;
import com.projetai.development.utils.exceptions.UserNotFoundException;
import com.projetai.development.utils.infra.user.developer.DeveloperEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RefinementService {

    private final TechLeadService techLeadService;

    private final DeveloperService developerService;

    private final RefinementRepository refinementRepository;

    public RefinementService(TechLeadService techLeadService, DeveloperService developerService, RefinementRepository refinementRepository) {
        this.techLeadService = techLeadService;
        this.developerService = developerService;
        this.refinementRepository = refinementRepository;
    }

    public void startRefinement(RefinementDto refinementDto) {
        Optional<TechLeadEntity> techLead = techLeadService.getTechLeadById(refinementDto.techLeadId());
        Optional<DeveloperEntity> developer = developerService.getDeveloperById(refinementDto.developerId());

        if (techLead.isEmpty() || developer.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        Refinement refinement = new Refinement(techLead.get().getName(), developer.get().getName(), LocalDateTime.now());

        refinementRepository.save(refinement.startRefinement());

    }

    public void completeRefinement(RefinementDto refinementDto) {
        Optional<TechLeadEntity> techLead = techLeadService.getTechLeadById(refinementDto.techLeadId());
        Optional<DeveloperEntity> developer = developerService.getDeveloperById(refinementDto.developerId());

        if (techLead.isEmpty() || developer.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        //Buscar refinamento existente do banco e atualizar ele

        Refinement refinement = new Refinement(techLead.get().getName(), developer.get().getName(), LocalDateTime.now());

        refinementRepository.save(refinement.completeRefinement());

    }
}
