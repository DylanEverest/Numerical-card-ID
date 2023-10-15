
CREATE TABLE property (
    property_id INTEGER PRIMARY KEY,
    address VARCHAR(30)
);


CREATE TABLE property_person (
    property_person_id INTEGER PRIMARY KEY,
    property_id INTEGER REFERENCES property(property_id),
    card_id VARCHAR(50) NOT NULL,
    purchase_date TEXT -- Assurez-vous de spécifier le type de données pour la colonne purchase_date
);
