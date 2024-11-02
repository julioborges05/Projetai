package com.projetai.quality.ticket.domain.parameters;

import com.projetai.core.infra.ticket.TicketEnum.TicketStatus;
import com.projetai.core.infra.ticket.TicketEnum.TicketType;
import jakarta.validation.constraints.NotBlank;

public record TicketParametersDto(

        TicketType type,
        TicketStatus status,
        String title,
        String message,
        String description,
        Long authorId,
        Long userNotifiedId,
        Long contactId) {

}
