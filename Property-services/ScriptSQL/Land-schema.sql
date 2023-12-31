-- Création de la table property
CREATE TABLE property (
    property_id serial PRIMARY KEY,
    address VARCHAR(30)
);

-- Création de la table property_person
CREATE TABLE property_person (
    property_person_id serial PRIMARY KEY,
    property_id INTEGER,
    card_id VARCHAR(50) NOT NULL,
    purchase_date DATE,
    sold DATE,
    FOREIGN KEY (property_id) REFERENCES property(property_id)
);

CREATE VIEW property_view AS
SELECT
    pp.property_person_id,
    p.property_id,
    p.address,
    pp.card_id,
    pp.purchase_date,
    pp.sold
FROM property p
JOIN property_person pp ON p.property_id = pp.property_id;


-- create table currency (
--
--     currency_id varchar(50) primary key
-- ) ;
-- create table currencyequivalence(
--     pk_id serial primary key ,
--     currency_id_ariary varchar(50) default('Ariary') REFERENCES currency(currency_id) ,
--     amount_Ariary double precision default(1) ,
--     amount_Ariary_achat double precision default(1) ,
--     amount_Ariary_vente double precision default(1) ,
--     currency_id_Euro varchar(50) default('Euro') REFERENCES currency(currency_id) ,
--     amount_Euro double precision ,
--     currency_id_Dollar varchar(50) default('Dollar') REFERENCES currency(currency_id) ,
--     amount_dollar double precision ,
--     dateBegin timestamp not null default(now()),
--     dateEnd timestamp
-- );



CREATE table property_geometry
(
    property_geometry_id serial primary key,
    property_id INTEGER REFERENCES property(property_id),
    property_latitude DECIMAL ,
    property_longitude DECIMAL
);

