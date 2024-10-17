package com.projetai.customer.contact.infra.notification;

import com.projetai.customer.contact.domain.contact.type.ContactType;
import com.projetai.customer.contact.infra.user.UserEntity;

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

    public NotificationEntityBuilder<U> withType(ContactType type) {
        notification.setType(type);
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
