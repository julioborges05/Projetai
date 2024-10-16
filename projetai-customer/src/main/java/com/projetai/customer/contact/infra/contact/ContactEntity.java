package com.projetai.customer.contact.infra.contact;

import com.projetai.customer.contact.domain.contact.Contact;
import com.projetai.customer.contact.domain.contact.type.ContactType;
import com.projetai.customer.contact.infra.user.ClientEntity;
import com.projetai.customer.contact.infra.user.SupportEntity;
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
    @ManyToOne
    @JoinColumn(name = "support_entity_id")
    private SupportEntity supportEntity;

    public ContactEntity() {
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

    public SupportEntity getSupportEntity() {
        return supportEntity;
    }

    public void setSupportEntity(SupportEntity supportEntity) {
        this.supportEntity = supportEntity;
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
