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
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;
    @ManyToOne
    @JoinColumn(name = "support_id")
    private SupportEntity supportEntity;
    @Column(name = "closed")
    private boolean isClosed;
    @Column(name = "is_replied")
    private boolean isReplied;

    public ContactEntity() {
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public void setReplied(boolean replied) {
        isReplied = replied;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public ContactType getType() {
        return type;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public SupportEntity getSupportEntity() {
        return supportEntity;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public boolean isReplied() {
        return isReplied;
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
