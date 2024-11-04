package com.projetai.core.infra.comment;

import com.projetai.core.infra.ticket.TicketEntity;
import jakarta.persistence.*;

@Entity(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticket;

    @Column(name = "user_id")
    private Long userId;

    public CommentEntity() {}

    public CommentEntity(Long id, String message, TicketEntity ticket, Long userId) {
        this.id = id;
        this.message = message;
        this.ticket = ticket;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TicketEntity getTicket() {
        return ticket;
    }

    public void setTicket(TicketEntity ticket) {
        this.ticket = ticket;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}