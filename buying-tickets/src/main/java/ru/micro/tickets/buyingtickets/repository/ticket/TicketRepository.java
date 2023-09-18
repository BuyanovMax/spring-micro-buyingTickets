package ru.micro.tickets.buyingtickets.repository.ticket;



import ru.micro.tickets.buyingtickets.model.Ticket;

import java.util.List;
import java.util.Optional;


public interface TicketRepository {

        Optional<Ticket> findByTicketId(Long id);
        Ticket save(Ticket ticket);
        List<Ticket> findAllFreeTickets();

}
