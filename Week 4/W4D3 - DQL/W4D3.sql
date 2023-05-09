-- DQL or data query LANGUAGE 

-- select ALL 
SELECT * FROM pets;

-- select a column or multiple
SELECT name FROM pets;
SELECT name, species FROM pets;

-- where clause - allows us to filter the information before return a resultset

-- comparison operators
-- =, <, >, <=, >=, <> or !=
SELECT * FROM pets WHERE age > 2;
SELECT * FROM pets WHERE id = 3;
SELECT * FROM pets WHERE id <> 3;
select * from pets WHERE age != 4;

-- logical operators
-- AND, OR, NOT 
SELECT * FROM pets WHERE age <= 5 AND vaccinated;
SELECT * FROM pets WHERE age <= 5 OR vaccinated;
-- Java will look for the 1st logical operator and then group from there. 
SELECT * FROM pets WHERE NOT age <= 5 OR NOT vaccinated AND species = 'Dog';
SELECT * FROM pets WHERE NOT age <= 5 OR (NOT vaccinated AND species = 'Dog');
SELECT * FROM pets WHERE (NOT age <= 5 OR NOT vaccinated) AND species = 'Dog';


-- more comparison operators
-- BETWEEN, IN, NULL
SELECT * FROM pets WHERE weight BETWEEN 3 AND 15;
SELECT * FROM pets WHERE weight NOT BETWEEN 3 AND 15;
SELECT * FROM pets WHERE weight IN (4, 12, 1);
SELECT * FROM pets WHERE weight NOT IN (4, 12, 1);
SELECT * FROM pets WHERE date_of_last_visit IS NOT NULL;
SELECT * FROM pets WHERE date_of_last_visit IS NULL;

-- can be used to match values to a pattern
SELECT * FROM pets WHERE name LIKE 'b%';
SELECT * FROM pets WHERE name LIKE '%e';
SELECT * FROM pets WHERE weight LIKE '2%';
SELECT * FROM pets WHERE name LIKE 'Mi_o';
SELECT * FROM pets WHERE name LIKE 'Mi_';

-- starts with Mi and could have more characters, but doesn't need to have more characters
SELECT * FROM pets WHERE name LIKE 'Mi%';

-- starts with Mi, requires a third letter, and could be longer than 3 characters
SELECT * FROM pets WHERE name LIKE 'Mi_%'; 

INSERT INTO pets(name, age, weight, vaccinated, date_of_last_visit, species, vet_id)
VALUES('Mi', 4, .5, true, '2021-10-03', 'Cat', 5);

-- dintinct
SELECT DISTINCT age FROM pets;
SELECT DISTINCT age, weight FROM pets;

-- alias
SELECT DISTINCT species AS pet_type FROM pets;

-- limit
SELECT * FROM pets WHERE weight > 5; -- cosmo, gopher, felix, milo, barry
SELECT * FROM pets WHERE weight > 5 LIMIT 3; -- comso, gopher, felix
SELECT * FROM pets WHERE weight > 5 LIMIT 3 OFFSET 1; -- gopher, felix, milo
