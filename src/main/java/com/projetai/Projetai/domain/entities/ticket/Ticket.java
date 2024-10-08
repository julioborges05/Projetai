package com.projetai.Projetai.domain.entities.ticket;

import com.projetai.Projetai.domain.idkyet.ServiceType;
import com.projetai.Projetai.domain.idkyet.ServiceStatus;

public class Ticket {
    private String userName;
    private String userMessage;
    private ServiceType serviceType;
    private ServiceStatus serviceStatus;

    public String getUserName() {
        return userName;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public Ticket(String userName, String userMessage, ServiceType serviceType, ServiceStatus serviceStatus) {
//        if(!Objects.equals(userName, "Denner")){
//            throw new IllegalArgumentException("Username required!");
//        }
        this.userName = userName;
        this.userMessage = userMessage;
        this.serviceType = serviceType;
        this.serviceStatus = serviceStatus;
    }
}
