package com.projetai.quality.ticket.application;

import com.projetai.quality.ticket.application.dto.GetAllTicketsData;
import com.projetai.quality.ticket.application.dto.TicketDetailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}")
    public ResponseEntity detailTicket(@PathVariable Long id) {
        return ResponseEntity.ok(new TicketDetailData(ticketService.DetailTicket(id)));
    }

    @GetMapping
    public ResponseEntity<Page<GetAllTicketsData>> getAllTickets(@PageableDefault(size = 10, sort = {"TicketStatus"})Pageable pageable) {
        return ResponseEntity.ok(ticketService.GetAllTickets(pageable));
    }



}
