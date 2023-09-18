package ru.micro.tickets.buyingtickets.repository.ticket;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.micro.tickets.buyingtickets.model.Route;
import ru.micro.tickets.buyingtickets.model.Ticket;
import ru.micro.tickets.buyingtickets.repository.routeRepository.RouteRepositoryImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class TicketRepositoryImpl implements TicketRepository{

    private final JdbcTemplate jdbcTemplate;
    private final RouteRepositoryImpl routeRepository;

    private static final String FIND_TICKET_BY_ID_SQL = """
            SELECT route_id,
                ticket_condition,
                date_Time,
                place,
                cost
            FROM ticket
            where ticket.id = ?
            """;

    private static final String FIND_ALL_FREE_TICKETS_SQL = """
            SELECT *
            FROM ticket
            where ticket.ticket_condition = 'free'
            """;

    private static final String SAVE_TICKET_SQL = """
            INSERT INTO ticket(
                date_time, place, cost, ticket_condition, route_id) 
            VALUES (?, ?, ?, ?, ?)    
            """;

    @Override
    public Optional<Ticket> findByTicketId(Long id) {
        return jdbcTemplate.queryForStream(FIND_TICKET_BY_ID_SQL, (rs, row) -> {
                    long routeId1 = rs.getLong("route_id");
                    Ticket ticket = new Ticket();
                    ticket.setRoute(routeRepository.findById(routeId1));
                    ticket.setTicketСondition(rs.getString("ticket_condition"));
                    ticket.setDateTime(rs.getTimestamp("date_time").toLocalDateTime());
                    ticket.setPlace(rs.getInt("place"));
                    ticket.setCost(rs.getInt("cost"));
                    return ticket;

                },
                id).findAny();
    }

    @Override
    public Ticket save(Ticket ticket) {
        System.out.println(ticket);
        int place = ticket.getPlace();
        LocalDateTime dateTime = ticket.getDateTime();
        int cost = ticket.getCost();
        String ticketСondition = ticket.getTicketСondition();
        long id = ticket.getRoute().getId();
        String format = String.format("INSERT INTO ticket(date_time, place, cost, ticket_condition, route_id) VALUES (%s, %s, %s, %s, %s)", dateTime, place, cost, ticketСondition, id);
        System.out.println(format);
        jdbcTemplate.update(SAVE_TICKET_SQL,
                dateTime,
                place,
                cost,
                ticketСondition,
                id
        );
        return ticket;

    }
    @Override
    public List<Ticket> findAllFreeTickets() {
        return jdbcTemplate.query(FIND_ALL_FREE_TICKETS_SQL, (rs, row) -> {
            Ticket ticket = new Ticket();
            ticket.setRoute(rs.getObject("route_id", Route.class));
            ticket.setDateTime(rs.getTimestamp("date_time").toLocalDateTime());
            ticket.setPlace(rs.getInt("place"));
            ticket.setCost(rs.getInt("cost"));
            return ticket;
        }
        );
    }
}
