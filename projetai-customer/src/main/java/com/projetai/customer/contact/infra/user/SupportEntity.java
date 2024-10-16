package com.projetai.customer.contact.infra.user;

import com.projetai.customer.contact.domain.user.support.Support;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class SupportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private boolean isAvailable;

    public SupportEntity() {
    }

    public SupportEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public SupportEntity(String name, String email, boolean isAvailable) {
        this.name = name;
        this.email = email;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Support toSupport() {
        return new Support(name, email, isAvailable);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SupportEntity that = (SupportEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(email, that.email)
                && Objects.equals(isAvailable, that.isAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, isAvailable);
    }
}
