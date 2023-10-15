SELECT card_id, SUM(amount) AS total_amount
FROM bankaccounttransaction
WHERE card_id = 'ID'
GROUP BY card_id;
