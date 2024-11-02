package com.projetai.development.refinement.infra.user.techLead;

import com.projetai.core.infra.user.UserEntity;
import com.projetai.core.infra.user.UserInterface;
import com.projetai.development.refinement.domain.user.TechLead;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "techLead")
public class TechLeadEntity extends UserEntity implements UserInterface {

    @Id
    @GeneratedValue(generator = "users_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    public TechLeadEntity() {
    }

    public TechLeadEntity(Long id, String name, String email) {
        super(name, email);
        this.id = id;
    }

    public TechLeadEntity(TechLead techLead) {
        super(techLead.getName(), techLead.getEmail());
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
