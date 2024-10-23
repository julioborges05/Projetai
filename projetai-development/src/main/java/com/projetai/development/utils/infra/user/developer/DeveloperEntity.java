package com.projetai.development.utils.infra.user.developer;

import com.projetai.development.utils.domain.user.developer.Developer;
import com.projetai.development.utils.infra.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity(name = "developer")
public class DeveloperEntity extends UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public DeveloperEntity() {
    }

    public DeveloperEntity(Developer developer) {
        super(developer.getName(), developer.getEmail());
    }

    public Developer toDeveloper() {
        return new Developer(name, email);
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        DeveloperEntity that = (DeveloperEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
