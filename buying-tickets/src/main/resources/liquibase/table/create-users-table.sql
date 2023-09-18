--liquibase formatted sql

-- changeset create-users-table mbuyanov:1


create table users
(
    id bigSerial primary key ,
    login varchar(16) unique not null ,
    password_hash varchar(36) not null,
    name varchar(16) not null ,
    surname varchar(32) not null ,
    patronymic_name varchar(16) not null
);