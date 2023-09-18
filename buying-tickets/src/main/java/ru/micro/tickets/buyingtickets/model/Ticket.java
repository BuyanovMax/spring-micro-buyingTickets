package ru.micro.tickets.buyingtickets.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Ticket {
    public enum TicketСondition {
        SOLD,
        FREE

    }

    private long id;
    private Route route;
    private LocalDateTime dateTime;
    private String ticketСondition;
    private int place;
    private int cost;
}
