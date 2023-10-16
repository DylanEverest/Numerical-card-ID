-- mysql

create database bank;

create table bankaccounttransaction (
    transaction_id serial primary key,
    card_id varchar(50) not null,
    amount double precision ,
    transaction_date TIMESTAMP default(now())
);

create table transfertransaction (
    transfertransaction_id serial ,
    card_id_sender varchar(50) not null,
    card_id_receiver varchar(50) not null
);


