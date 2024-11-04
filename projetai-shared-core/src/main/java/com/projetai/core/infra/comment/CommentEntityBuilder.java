package com.projetai.core.infra.comment;

import com.projetai.core.infra.ticket.TicketEntity;

public class CommentEntityBuilder {

    private final CommentEntity commentEntity = new CommentEntity();

    public CommentEntityBuilder withMessage(String message) {
        commentEntity.setMessage(message);
        return this;
    }

    public CommentEntityBuilder withTicket(TicketEntity ticketEntity) {
        commentEntity.setTicket(ticketEntity);
        return this;
    }

    public CommentEntityBuilder withUserId(Long userId) {
        commentEntity.setUserId(userId);
        return this;
    }

    public CommentEntity build() {
        return commentEntity;
    }
}
