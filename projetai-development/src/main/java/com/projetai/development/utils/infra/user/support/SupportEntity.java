package com.projetai.development.utils.infra.user.support;

import com.projetai.development.utils.domain.user.support.Support;
import com.projetai.development.utils.infra.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class SupportEntity extends UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isAvailable;

    public SupportEntity() {
    }

    public SupportEntity(Support support) {
        super(support.getName(), support.getEmail());
        this.isAvailable = support.isAvailable();
    }

    public Support toSupport() {
        return new Support(name, email, isAvailable);
    }

    public Long getId() {
        return id;
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
