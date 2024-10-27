package com.projetai.customer.contact.infra.contact;

import com.projetai.customer.contact.domain.contact.type.ContactType;
import com.projetai.customer.contact.infra.user.client.ClientEntity;
import com.projetai.core.infra.user.support.SupportEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "contact")
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
    @JoinColumn(name = "support_id")
    private SupportEntity supportEntity;

    public ContactEntity() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public void setSupportEntity(SupportEntity supportEntity) {
        this.supportEntity = supportEntity;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", type=" + type +
                ", clientEntity=" + clientEntity +
                ", supportEntity=" + supportEntity +
                '}';
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
