package ru.micro.tickets.buyingtickets.repository.userRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.micro.tickets.buyingtickets.model.User;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String SAVE_USER_SQL = """
            INSERT INTO buying_tickets.user(
                login, passwordHash, name, surname,patronymicName) 
            VALUES (?, ?, ?, ?, ?)    
            """;


    @Override
    public User save(User user) {
        jdbcTemplate.update(SAVE_USER_SQL,
                user.getLogin(),
                user.getPasswordHash(),
                user.getName(),
                user.getSurname(),
                user.getPatronymicName()
        );
        return user;
    }
}
