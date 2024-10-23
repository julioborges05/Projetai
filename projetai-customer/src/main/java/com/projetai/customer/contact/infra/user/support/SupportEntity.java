package com.projetai.customer.contact.infra.user.support;

import com.projetai.customer.contact.domain.user.support.Support;
import com.projetai.customer.contact.infra.user.UserEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "support")
public class SupportEntity extends UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_available")
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
