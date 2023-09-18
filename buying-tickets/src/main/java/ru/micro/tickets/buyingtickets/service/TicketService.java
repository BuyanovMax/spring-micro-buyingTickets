package ru.micro.tickets.buyingtickets.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.micro.tickets.buyingtickets.model.Ticket;
import ru.micro.tickets.buyingtickets.repository.ticket.TicketRepositoryImpl;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class TicketService {

    private final TicketRepositoryImpl ticketRepository;
    public List<Ticket> findAllTickets() {
        return ticketRepository.findAllFreeTickets();
    }

    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Optional<Ticket> findById(Long id) {
        return ticketRepository.findByTicketId(id);
    }
}
