package ru.micro.tickets.buyingtickets.repository.carrierRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.micro.tickets.buyingtickets.model.Carrier;

@Repository
@RequiredArgsConstructor
public class CarrierRepositoryImpl implements CarrierRepository {
    private final JdbcTemplate jdbcTemplate;

    private final String FIND_CARRIER_BY_ID = """
            SELECT *
            FROM CARRIER
            WHERE id = ?
            """;
    @Override
    public Carrier findCarrierById(Long id) {
        return jdbcTemplate.queryForStream(FIND_CARRIER_BY_ID, (rs, row) -> {
                    Carrier carrier = new Carrier();
                    carrier.setId(id);
                    carrier.setName(rs.getString("name"));
                    carrier.setPhone(rs.getString("phone"));
                    return carrier;

                },
                id).findFirst().orElseThrow();
    }
}
