package com.projetai.quality.ticket.domain.parameters;

import com.projetai.core.infra.ticket.TicketEnum.TicketStatus;
import com.projetai.core.infra.ticket.TicketEnum.TicketType;

public record TicketParametersDto(
        Long userNotifiedId,
        TicketType type,
        TicketStatus status,
        String title,
        String description,
        Long clientId,
        Long contactId
        ) {


}
