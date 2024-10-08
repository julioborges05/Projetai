package com.projetai.Projetai.domain.entities.ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.projetai.Projetai.domain.idkyet.ServiceStatus.*;
import static com.projetai.Projetai.domain.idkyet.ServiceType.*;

public class TicketTest {
    @Test
    public void notPossibleToCreateTicketWithoutUsername(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ticket("Dnner", "mensagem qualquer", HOTFIX, OPEN));
    }
}
