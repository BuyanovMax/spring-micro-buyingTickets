package ru.micro.tickets.buyingtickets.repository.userRepository;


import ru.micro.tickets.buyingtickets.model.User;

public interface UserRepository {
    User save(User user);
}
