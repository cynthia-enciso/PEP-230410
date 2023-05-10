-- DENORMALIZED
-- DROP TABLE IF EXISTS zookeepers;
-- 
-- CREATE TABLE zookeepers(
-- 	first_name varchar(100),
-- 	last_name varchar(100),
-- 	exhibit varchar(100),
-- 	animal_type1 varchar(100),
-- 	animal_type2 varchar(100),
-- 	animal_type3 varchar(100),
-- 	salary integer,
-- 	title varchar(100)
-- );
-- 
-- INSERT INTO zookeepers 
-- VALUES('Debra', 'Jones', 'Savannah Animals, Elephant Exhibit', 'Zebra', 'Elephant', 'Giraffe', 50000, 'Level 1 Zookeeper');
-- SELECT * FROM zookeepers;
-- ==========================================================================
-- 1NF
-- add a PK
-- cell values are atomic
-- remove redundant columns
-- DROP TABLE IF EXISTS zookeepers;
-- 
-- CREATE TABLE zookeepers(
-- 	id integer auto_increment PRIMARY KEY,
-- 	first_name varchar(100),
-- 	last_name varchar(100),
-- 	exhibit varchar(100),
-- 	animal_type varchar(100),
-- 	salary integer,
-- 	title varchar(100)
-- );
-- 
-- INSERT INTO zookeepers 
-- VALUES(default, 'Debra', 'Jones', 'Savannah Animals', 'Zebra', 50000, 'Level 1 Zookeeper');
-- SELECT * FROM zookeepers;

-- ==========================================================================
-- 2ND
-- removes any partial dependencies
-- any non-key columns must describe the key
-- DROP TABLE IF EXISTS zookeepers;
-- CREATE TABLE zookeepers(
-- 	id integer auto_increment PRIMARY KEY,
-- 	first_name varchar(100),
-- 	last_name varchar(100),
-- -- 	exhibit varchar(100)
-- -- 	animal_type varchar(100), -- functional dependency with exhibit
-- 	salary integer,
-- 	title varchar(100)
-- 	-- depends on exhibits
-- );
-- 
-- DROP TABLE IF EXISTS exhibits;
-- CREATE TABLE exhibits(
-- 	id integer auto_increment PRIMARY KEY, 
-- 	exhibit_name varchar(100)
-- );
-- 
-- DROP TABLE IF EXISTS animals;
-- CREATE TABLE animals(
-- 	id integer auto_increment PRIMARY KEY, 
-- 	species varchar(100)
-- 	-- depends on exhibits
-- );
-- 
-- INSERT INTO zookeepers VALUES (default, 'Brenda', 'Jackson', 50000, 'Level 1 Zookeeper');
-- INSERT INTO exhibits VALUES (default, 'Savannah Herbivores');
-- INSERT INTO exhibits VALUES (default, 'Elephant Exhibit');
-- INSERT INTO animals VALUES (default, 'Zebra');
-- INSERT INTO animals VALUES (default, 'Elephant');
-- INSERT INTO animals VALUES (default, 'Giraffe');
-- 
-- 
-- SELECT * FROM zookeepers;
-- SELECT * FROM exhibits;
-- SELECT * FROM animals;

-- ==========================================================================
-- 3RD
-- get rid of any transitive dependencies
-- if we look at one columns value, can we infer the value of another column?
-- DROP TABLE IF EXISTS zookeepers;
-- CREATE TABLE zookeepers(
-- 	id integer auto_increment PRIMARY KEY,
-- 	first_name varchar(100),
-- 	last_name varchar(100)
-- 	-- depends on exhibits
-- 	-- depends in titles
-- );
-- 
-- DROP TABLE IF EXISTS titles;
-- CREATE TABLE titles(
-- 	id integer auto_increment PRIMARY KEY,
-- 	title_name varchar(100),
-- 	salary integer
-- );
-- 
-- DROP TABLE IF EXISTS exhibits;
-- CREATE TABLE exhibits(
-- 	id integer auto_increment PRIMARY KEY, 
-- 	exhibit_name varchar(100)
-- );
-- 
-- DROP TABLE IF EXISTS animals;
-- CREATE TABLE animals(
-- 	id integer auto_increment PRIMARY KEY, 
-- 	species varchar(100)
-- 	-- depends on exhibits
-- );
-- 
-- INSERT INTO zookeepers VALUES (default, 'Brenda', 'Jackson');
-- INSERT INTO exhibits VALUES (default, 'Savannah Herbivores');
-- INSERT INTO exhibits VALUES (default, 'Elephant Exhibit');
-- INSERT INTO animals VALUES (default, 'Zebra');
-- INSERT INTO animals VALUES (default, 'Elephant');
-- INSERT INTO animals VALUES (default, 'Giraffe');
-- INSERT INTO titles VALUES (default, 'Level 1 Zookeeper', 50000);
-- 
-- SELECT * FROM zookeepers;
-- SELECT * FROM exhibits;
-- SELECT * FROM animals;
-- SELECT * FROM titles;


-- ==========================================================================
-- MULTIPLICITY
DROP TABLE if exists zookeepers_exhibits;
DROP TABLE IF EXISTS zookeepers;
DROP TABLE IF EXISTS titles;
DROP TABLE IF EXISTS animals;
DROP TABLE IF EXISTS exhibits;

CREATE TABLE titles(
	id integer auto_increment PRIMARY KEY,
	title_name varchar(100),
	salary integer
);

-- one to many, many to one
CREATE TABLE zookeepers(
	id integer auto_increment PRIMARY KEY,
	first_name varchar(100),
	last_name varchar(100),
	titles_id integer,
	FOREIGN KEY (titles_id) REFERENCES titles(id) ON DELETE CASCADE
	-- depends on exhibits
);


CREATE TABLE exhibits(
	id integer auto_increment PRIMARY KEY, 
	exhibit_name varchar(100)
);

DROP TABLE IF EXISTS animals;
CREATE TABLE animals(
	id integer auto_increment PRIMARY KEY, 
	species varchar(100),
	exhibit_id integer,
	FOREIGN KEY (exhibit_id) REFERENCES exhibits(id)
);

-- represents any relationships between zookeepers and exhibits
CREATE TABLE zookeepers_exhibits(
	zookeeper_id integer,
	exhibit_id integer,
	FOREIGN KEY (zookeeper_id) REFERENCES zookeepers(id) ON DELETE CASCADE,
	FOREIGN KEY (exhibit_id) REFERENCES exhibits(id) ON DELETE CASCADE,
	PRIMARY KEY (zookeeper_id, exhibit_id)
);


INSERT INTO titles VALUES (default, 'Level 1 Zookeeper', 50000);

INSERT INTO zookeepers VALUES (default, 'Brenda', 'Jackson', 1);

INSERT INTO exhibits VALUES (default, 'Savannah Herbivores');
INSERT INTO exhibits VALUES (default, 'Elephant Exhibit');

-- brenda is associated with both exhibits
INSERT INTO zookeepers_exhibits VALUES (1, 1);
INSERT INTO zookeepers_exhibits VALUES (1, 2);

INSERT INTO animals VALUES (default, 'Zebra', 1);
INSERT INTO animals VALUES (default, 'Elephant', 2);
INSERT INTO animals VALUES (default, 'Giraffe', 1);

DELETE FROM titles;


SELECT * FROM zookeepers;
SELECT * FROM exhibits;
SELECT * FROM animals;
SELECT * FROM titles;
SELECT * FROM zookeepers_exhibits;



-- ==========================================================================

-- REFERENTIAL INTEGRITY