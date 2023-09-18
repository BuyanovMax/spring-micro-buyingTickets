package ru.micro.tickets.buyingtickets.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.micro.tickets.buyingtickets.model.Ticket;
import ru.micro.tickets.buyingtickets.service.TicketService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<Ticket>> findAllFreeTickets() {
        return ResponseEntity.ok(ticketService.findAllTickets());
    }
    @PostMapping
    public  ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.saveTicket(ticket));
    }

    @GetMapping({"{id}"})
    public ResponseEntity<Optional<Ticket>> findAllFreeTickets(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }
}
