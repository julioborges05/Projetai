package com.projetai.quality.ticket.infra.notification;


import com.projetai.quality.ticket.infra.user.UserEntity;

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


    public NotificationEntityBuilder<U> withUserEntity(U user) {
        notification.setUser(user);
        return this;
    }

    public NotificationEntity<U> build() {
        return notification;
    }

}
