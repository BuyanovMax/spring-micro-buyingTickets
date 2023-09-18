package ru.micro.tickets.buyingtickets.model;

import lombok.Data;

@Data
public class Route {

    private long id;
    private String arrivalPoint;
    private String departurePoint;
    private Carrier carrier;
    private int durationInMinutes;
}
