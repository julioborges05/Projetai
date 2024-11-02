package com.projetai.core.infra.user.developer;

import com.projetai.core.infra.user.UserEntity;
import com.projetai.core.infra.user.UserInterface;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "developer")
public class DeveloperEntity extends UserEntity implements UserInterface {

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    public DeveloperEntity(Long id, String name, String email) {
        super(name, email);
        this.id = id;
    }
    public DeveloperEntity(DeveloperEntity developerEntityEntity) {
        super(developerEntityEntity.getName(), developerEntityEntity.getEmail());
        this.id = developerEntityEntity.getId();
    }

    public DeveloperEntity(String name, String email) {
        super(name, email);
        this.id = id;
    }
    public DeveloperEntity() {

    }

    public DeveloperEntity toEntity() {
        return new DeveloperEntity(this.getName(), this.getEmail());
    }

    public DeveloperEntity() { }

    public void setId(Long id) {
        this.id = id;
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
