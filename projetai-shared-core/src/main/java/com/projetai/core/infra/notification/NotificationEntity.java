package com.projetai.core.infra.notification;

import com.projetai.core.infra.user.UserEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "notification")
public class NotificationEntity<U extends UserEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private String type;
    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id")
    private U user;
    private boolean read = false;

    public NotificationEntity() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(String type) {
        this.type = type;
    }

    public U getUser() {
        return user;
    }

    public void setUser(U user) {
        this.user = user;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "NotificationEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", type=" + type +
                ", user=" + user +
                ", read=" + read +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        NotificationEntity<?> that = (NotificationEntity<?>) o;
        return read == that.read
                && Objects.equals(id, that.id)
                && Objects.equals(title, that.title)
                && Objects.equals(message, that.message)
                && Objects.equals(type, that.type)
                && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, message, type, user, read);
    }
}
