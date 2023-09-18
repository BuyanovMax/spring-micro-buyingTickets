package ru.micro.tickets.buyingtickets.repository.routeRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.micro.tickets.buyingtickets.model.Route;
import ru.micro.tickets.buyingtickets.repository.carrierRepository.CarrierRepositoryImpl;

@Repository
@RequiredArgsConstructor
public class RouteRepositoryImpl implements RouteRepository {

    private final JdbcTemplate jdbcTemplate;
    private final CarrierRepositoryImpl carrierRepository;

    private final String FIND_ROUTE_BY_ID = """
            SELECT *
            FROM ROUTE
            WHERE id = ?
            """;
    @Override
    public Route findById(Long id) {
        return jdbcTemplate.queryForStream(FIND_ROUTE_BY_ID, (rs, row) -> {
                    Route route = new Route();
                    long carrierId = rs.getLong("carrier_id");
                    route.setCarrier(carrierRepository.findCarrierById(carrierId));
                    route.setDeparturePoint(rs.getString("departure_point"));
                    route.setArrivalPoint(rs.getString("arrival_point"));
                    route.setId(id);
                    route.setDurationInMinutes(rs.getInt("duration_in_minutes"));
                    return route;
                },
                id).findFirst().orElseThrow();

    }
}
