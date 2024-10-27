package com.projetai.development.refinement.application.user;

import com.projetai.development.refinement.infra.user.techLead.TechLeadEntity;
import com.projetai.development.refinement.infra.user.techLead.TechLeadRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechLeadService {

    private final TechLeadRepository techLeadRepository;

    public TechLeadService(TechLeadRepository techLeadRepository) {
        this.techLeadRepository = techLeadRepository;
    }

    public Optional<TechLeadEntity> getTechLeadById(Long id) {
        return techLeadRepository.findById(id);
    }
}
