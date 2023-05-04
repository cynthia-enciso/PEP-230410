-- this a comment
/*
 * DDL: data definition language
 * CREATE
 * DROP
 * ALTER
 * 
 */

-- CREATE DATABASE demo1;

DROP TABLE IF EXISTS pets;

CREATE TABLE pets(
	name VARCHAR(100),
	age INTEGER,
	vaccinated BOOLEAN,
	weight NUMERIC(5, 2), -- 5 places, 2 decimal place
	date_of_last_visit DATE -- YYYY-MM-DD
);



ALTER TABLE pets ADD COLUMN species VARCHAR(100);
-- ALTER TABLE pets MODIFY COLUMN species VARCHAR(150);

DESCRIBE pets;

INSERT INTO pets VALUES ('Charlie', 7, true, 20.5, '2022-05-01', 'Dog');
INSERT INTO pets VALUES ('Jerry', 3, true, 100.57, '2022-05-01', 'Dog');
INSERT INTO pets VALUES ('Pokey',5, true, 20.57, '2022-05-01', 'Cat');
SELECT * FROM pets;

-- TRUNCATE TABLE pets;


