package com.projetai.quality.ticket.domain.parameters;

import com.projetai.core.infra.ticket.TicketEnum.TicketType;

public record TicketParametersDto(TicketType type, String title, String description, Long authorId, Long userNotifiedId,
                                  Long contactId) {

}
