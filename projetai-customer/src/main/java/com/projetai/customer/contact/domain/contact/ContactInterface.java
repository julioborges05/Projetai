package com.projetai.customer.contact.domain.contact;

import com.projetai.customer.contact.domain.user.support.Support;

public interface ContactInterface {

    void makeContactTo(Support support);

    void sendNotificationTo(Support support);

}
