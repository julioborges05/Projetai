package com.projetai.customer.contact.domain.contact;

import com.projetai.customer.contact.domain.common.User;

public class Contact implements ContactInterface {

    @Override
    public<U extends User> void sendNotificationTo(U user) {
        // Implementation
    }

}
