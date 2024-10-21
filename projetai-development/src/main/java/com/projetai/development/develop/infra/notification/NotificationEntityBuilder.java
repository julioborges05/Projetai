package com.projetai.development.develop.infra.notification;

import com.projetai.development.develop.domain.development.status.DevelopmentStatus;
import com.projetai.development.develop.infra.user.UserEntity;

public class NotificationEntityBuilder<U extends UserEntity> {

    private final NotificationEntity<U> notification = new NotificationEntity<>();

    public NotificationEntityBuilder<U> withTitle(String title) {
        notification.setTitle(title);
        return this;
    }

    public NotificationEntityBuilder<U> withMessage(String message) {
        notification.setMessage(message);
        return this;
    }

    public NotificationEntityBuilder<U> withStatus(DevelopmentStatus status) {
        notification.setStatus(status);
        return this;
    }

    public NotificationEntityBuilder<U> withUserEntity(U user) {
        notification.setUser(user);
        return this;
    }

    public NotificationEntity<U> build() {
        return notification;
    }

}
