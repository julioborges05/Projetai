package com.projetai.development.refinement.infra.user.techLead;

import com.projetai.development.refinement.domain.user.TechLead;
import com.projetai.development.utils.infra.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity(name = "techLead")
public class TechLeadEntity extends UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public TechLeadEntity() {
    }

    public TechLeadEntity(TechLead techLead) {
        super(techLead.getName(), techLead.getEmail());
    }

    public TechLead toTechLead() {
        return new TechLead(name, email);
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        TechLeadEntity that = (TechLeadEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
