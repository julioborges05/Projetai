package com.projetai.core.infra.notification;

import com.projetai.core.infra.user.UserEntity;
import com.projetai.core.infra.user.UserInterface;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "notification")
public class NotificationEntity<U extends UserEntity & UserInterface> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private String type;
    private Long userId;
    private boolean read = false;

    @Transient
    private U user;

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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public U getUser() {
        return user;
    }

    public void setUser(U user) {
        this.user = user;
        this.userId = user.getId();
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
