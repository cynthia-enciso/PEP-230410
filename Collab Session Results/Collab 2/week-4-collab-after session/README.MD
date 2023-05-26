SELECT * FROM ramen_shop 
WHERE name NOT LIKE 'F%' 
AND dessert != 'Cake' 
AND seat_number < 15 
AND entree = 'Udon'
AND seat_number % 2 = 0;

SELECT * FROM ramen_shop 
WHERE shirt_color NOT IN ('Black', 'Blue')
AND entree != 'Sushi Roll' 
AND name LIKE '%i%' 
AND seat_number != 11 AND seat_number != 13 
AND name != 'Elvis';

SELECT * FROM ramen_shop 
WHERE dessert != 'ice cream' 
AND payment_type != 'card'
AND name LIKE '____%' 
AND entree LIKE '%noodle%' 
AND name NOT LIKE 'j%' AND name NOT LIKE 'k%';