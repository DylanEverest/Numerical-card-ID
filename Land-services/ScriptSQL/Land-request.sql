 
-- Création d'une vue pour relier les tables property et property_person
CREATE VIEW property_view AS
SELECT
    p.property_id,
    p.address,
    pp.property_person_id,
    pp.card_id,
    pp.purchase_date
FROM property p
JOIN property_person pp ON p.property_id = pp.property_id;
