package com.projetai.development.develop.domain.comment;

import com.projetai.core.infra.comment.CommentEntity;
import com.projetai.core.infra.comment.CommentEntityBuilder;
import com.projetai.core.infra.notification.NotificationEntity;
import com.projetai.core.infra.notification.NotificationEntityBuilder;
import com.projetai.core.infra.ticket.TicketEntity;
import com.projetai.core.infra.user.support.SupportEntity;
import com.projetai.development.refinement.infra.refinement.RefinementEntity;
import com.projetai.development.refinement.infra.refinement.RefinementEntityBuilder;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class Comment implements CommentInterface {

    private String message;

    private TicketEntity ticket;

    private Long userId;

    public Comment(String message, TicketEntity ticketEntity, Long userId) {
        this.message = message;
        this.ticket = ticketEntity;
        this.userId = userId;
    }

    @Override
    public CommentEntity addComment() {
        return new CommentEntityBuilder()
                .withMessage(message)
                .withTicket(ticket)
                .withUserId(userId)
                .build();
    }
}
