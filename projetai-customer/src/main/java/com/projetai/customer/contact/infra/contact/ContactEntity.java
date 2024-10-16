package com.projetai.customer.contact.infra.contact;

import com.projetai.customer.contact.domain.contact.Contact;
import com.projetai.customer.contact.domain.contact.type.ContactType;
import com.projetai.customer.contact.infra.user.ClientEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private ContactType type;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity clientEntity;

    public ContactEntity() {
    }

    public ContactEntity(String title, String message, ContactType type, ClientEntity clientEntity) {
        this.title = title;
        this.message = message;
        this.type = type;
        this.clientEntity = clientEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public Contact toContact() {
        return new Contact(title, message, type, clientEntity.toClient());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ContactEntity that = (ContactEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(title, that.title)
                && Objects.equals(message, that.message)
                && type == that.type
                && Objects.equals(clientEntity, that.clientEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, message, type, clientEntity);
    }
}
