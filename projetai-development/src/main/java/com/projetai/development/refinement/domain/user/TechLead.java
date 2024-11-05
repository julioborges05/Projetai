package com.projetai.development.refinement.domain.user;

import com.projetai.core.domain.user.User;
import com.projetai.development.refinement.application.dto.TechLeadDto;
import com.projetai.development.refinement.infra.user.techLead.TechLeadEntity;

public class TechLead extends User {

    public TechLead(String name, String email) {
        super(name, email);
    }

    public static TechLeadDto dbEntityToDto(TechLeadEntity techLead) {
        return new TechLeadDto(techLead.getId(), techLead.getName(), techLead.getEmail());
    }

    public static TechLeadEntity dtoToEntity(TechLeadDto techLead) {
        return new TechLeadEntity(techLead.id(), techLead.name(), techLead.email());
    }
}
