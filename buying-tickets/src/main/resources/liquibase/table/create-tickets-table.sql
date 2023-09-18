--liquibase formatted sql

-- changeset create-route-table mbuyanov:1


create table ticket
(
    id bigSerial primary key ,
    date_time TIMESTAMP not null ,
    place int not null,
    cost int not null,
    ticket_condition varchar(4) not null default 'free',
    route_id bigint unique references route(id) not null
);