package com.projetai.customer.contact.infra.user.client;

import com.projetai.core.infra.user.UserEntity;
import com.projetai.customer.contact.domain.client.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity(name = "client")
public class ClientEntity extends UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ClientEntity() {
    }

    public ClientEntity(Client client) {
        super(client.getName(), client.getEmail());
    }

    public Client toClient() {
        return new Client(name, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        ClientEntity that = (ClientEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
