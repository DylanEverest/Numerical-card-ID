create database health_check;

create table infos(
    card_id varchar(50) primary key,
    name varchar(20),
    firstname varchar(20),
    birthdate date
);


create table health(
    health_id serial primary key,
    card_id varchar(50) references infos (card_id),
    deseases varchar ,
    date_begin date not null ,
    date_end date
);


