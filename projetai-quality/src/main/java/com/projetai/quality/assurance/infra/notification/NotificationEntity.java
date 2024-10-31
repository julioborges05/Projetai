package com.projetai.quality.assurance.infra.notification;

import com.projetai.quality.assurance.infra.user.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class NotificationEntity<U extends UserEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
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
                && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, message, user, read);
    }
}