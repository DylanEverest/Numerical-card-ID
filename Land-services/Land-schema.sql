-- postgre


create database property ;

create table property (

    property_id serial primary key,
    adress varchar(30)

);

CREATE table property_person (
    property_person_id serial primary key ,
    property_id int references property(property_id),
    card_id varchar(50) not null,
    purchase_date
) ;
