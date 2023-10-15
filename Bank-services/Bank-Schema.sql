-- mysql

create database bank;

create table bankaccounttransaction (
    transaction_id serial primary key,
    card_id varchar(50) not null,
    amount double precision ,
    transaction_date TIMESTAMP
);


