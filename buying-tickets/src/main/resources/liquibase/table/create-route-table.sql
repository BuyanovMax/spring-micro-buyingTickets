--liquibase formatted sql

-- changeset create-route-table mbuyanov:1


create table route
(
    id bigSerial primary key ,
    arrival_point varchar(32) not null ,
    departure_point varchar(32) not null,
    duration_in_minutes int not null ,
    carrier_id bigint unique references carrier(id) not null
);