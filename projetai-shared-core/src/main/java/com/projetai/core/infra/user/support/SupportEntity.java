package com.projetai.core.infra.user.support;

import com.projetai.core.application.dto.SupportDto;
import com.projetai.core.domain.user.support.Support;
import com.projetai.core.infra.user.UserEntity;
import com.projetai.core.infra.user.UserInterface;
import jakarta.persistence.*;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Objects;
import java.util.Optional;

@Entity(name = "support")
public class SupportEntity extends UserEntity implements UserInterface {

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "is_available")
    private boolean isAvailable;

    public SupportEntity() {
    }


    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public SupportEntity(Support support) {
        super(support.getName(), support.getEmail());
        this.isAvailable = support.isAvailable();
        this.id = support.getId();
    }

    public SupportEntity(SupportDto supportDto) {
        super(supportDto.name(), supportDto.email());
        this.id = supportDto.id();
        this.isAvailable = supportDto.isAvailable();
    }
    public SupportEntity(SupportEntity supportEntity){
        super(supportEntity.getName(), supportEntity.getEmail());
        this.id = supportEntity.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        SupportEntity that = (SupportEntity) o;
        return isAvailable == that.isAvailable && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, isAvailable);
    }
}
