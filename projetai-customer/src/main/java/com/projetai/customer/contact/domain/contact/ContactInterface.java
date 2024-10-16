package com.projetai.customer.contact.domain.contact;

import com.projetai.customer.contact.domain.common.User;

public interface ContactInterface {

    <U extends User> void sendNotificationTo(U user);

}
