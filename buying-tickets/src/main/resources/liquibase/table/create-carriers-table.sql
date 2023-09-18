--liquibase formatted sql

-- changeset create-carriers-table mbuyanov:1


create table carrier
(
    id bigSerial primary key ,
    name varchar(16) not null ,
    phone varchar(16) not null
);