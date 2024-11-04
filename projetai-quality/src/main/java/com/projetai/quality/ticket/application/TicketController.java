package com.projetai.quality.ticket.application;

import com.projetai.quality.ticket.application.dto.GetAllTicketsData;
import com.projetai.quality.ticket.application.dto.TicketDetailData;
import com.projetai.quality.ticket.domain.parameters.TicketParametersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDetailData> detailTicket(@PathVariable Long id) {
        return ResponseEntity.ok(new TicketDetailData(ticketService.detailTicket(id)));
    }

    @GetMapping
    public ResponseEntity<Page<GetAllTicketsData>> getAllTickets(@PageableDefault(size = 10, sort = {"TicketStatus"})Pageable pageable) {
        return ResponseEntity.ok(ticketService.getAllTickets(pageable));
    }

    @PostMapping("/parameters")
    public ResponseEntity<String> createTicketParameters(@RequestBody TicketParametersDto parameters) {
        ticketService.createTicketParameters(parameters);
        return ResponseEntity.ok("Parameters set successfully");
    }

    @PutMapping("/finish/{id}")
    public ResponseEntity<String> ticketFinished(@PathVariable Long id){
        ticketService.setTicketAsFinished(id);
        return ResponseEntity.ok("Ticket has been finshed");
    }

}
