create database health_check;

create table health(
    health_id serial primary key,
    card_id varchar(50),
    deseases varchar
);