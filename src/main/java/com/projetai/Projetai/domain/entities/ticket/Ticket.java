package com.projetai.Projetai.domain.entities.ticket;

public class Ticket {
    private Long ticketId;
    private String title;
    private String userName;
    private String userEmail;
    private String description;
    private TicketType ticketType;
    private TicketStatus ticketStatus;


    public String getUserName() {
        return userName;
    }

    public String getDescription() {
        return description;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public String getTitle() {
        return title;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Ticket(CreateTicketData data){
        this.title = data.title();
        this.userName = data.userName();
        this.userEmail = data.userEmail();
        this.description = data.description();
        this.ticketType = data.ticketType();
        this.ticketStatus = data.ticketStatus();
    }

    public void UpdateTicket(UpdateTicketData data){

    }

    public void DeleteTicket(){
    }

}

//        Throw error for tests
//        if(){
//            throw new IllegalArgumentException("Username required!");
//        }