DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS aisles;

CREATE TABLE aisles(
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(100),
item_count integer
);

INSERT INTO aisles VALUES (default, 'Pantry', 0),
						(default, 'Freezer', 0),
						(default, 'Health', 0);
					
CREATE TABLE items(
id integer AUTO_INCREMENT PRIMARY KEY,
name varchar(100),
price numeric(5, 2),
inventory_count integer,
aisle_id integer,
FOREIGN KEY (aisle_id) REFERENCES aisles(id)
);


								
SELECT * FROM aisles;
SELECT * FROM items;