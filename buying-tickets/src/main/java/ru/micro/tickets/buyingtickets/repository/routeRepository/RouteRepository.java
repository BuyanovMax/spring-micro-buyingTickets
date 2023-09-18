package ru.micro.tickets.buyingtickets.repository.routeRepository;


import ru.micro.tickets.buyingtickets.model.Route;

public interface RouteRepository {

    Route findById(Long id);
}
