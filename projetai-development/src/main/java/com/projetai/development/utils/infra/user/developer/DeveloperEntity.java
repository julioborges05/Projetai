package com.projetai.development.utils.infra.user.developer;

import com.projetai.core.infra.user.UserEntity;
import com.projetai.core.infra.user.UserInterface;
import com.projetai.development.develop.application.dto.DeveloperDto;
import com.projetai.development.utils.domain.user.developer.Developer;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "developer")
public class DeveloperEntity extends UserEntity implements UserInterface {

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    public DeveloperEntity() {
    }

    public DeveloperEntity(Developer developer) {
        super(developer.getName(), developer.getEmail());
    }

    public DeveloperEntity(DeveloperDto developerDto) {
        super(developerDto.name(), developerDto.email());
        this.id = developerDto.id();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Developer toDeveloper() {
        return new Developer(name, email);
    }

    @Override
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
