package ru.micro.tickets.buyingtickets.repository.carrierRepository;


import ru.micro.tickets.buyingtickets.model.Carrier;

public interface CarrierRepository {

    Carrier findCarrierById(Long id);
}
