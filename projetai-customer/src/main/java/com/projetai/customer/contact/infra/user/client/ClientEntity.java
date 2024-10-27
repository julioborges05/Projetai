package com.projetai.customer.contact.infra.user.client;

import com.projetai.core.infra.user.UserEntity;
import com.projetai.core.infra.user.UserInterface;
import com.projetai.customer.contact.application.dto.ClientDto;
import com.projetai.customer.contact.domain.client.Client;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.util.Objects;

@Entity(name = "client")
public class ClientEntity extends UserEntity implements UserInterface {

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "users_id_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    public ClientEntity() {
    }

    public ClientEntity(Client client) {
        super(client.getName(), client.getEmail());
    }

    public ClientEntity(ClientDto clientDto) {
        super(clientDto.name(), clientDto.email());
        this.id = clientDto.id();
    }

    public Client toClient() {
        return new Client(name, email);
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

        ClientEntity that = (ClientEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
