-- plsql (procedural language SQL): extends SQL to allow database to perform business logic and control flow operations
DROP FUNCTION IF EXISTS count_of_cheaper_items;
DROP TRIGGER IF EXISTS insert_item_trigger;
DROP PROCEDURE IF EXISTS get_max_price;

SHOW PROCEDURE STATUS WHERE db = 'demo4';
SHOW FUNCTION STATUS WHERE db = 'demo4';
SHOW TRIGGERS;
-- ====================================== FUNCTIONS =====================================
-- callable blocks of code that are used to perform a calculation and return a result
-- can take in params, must return a result or single value

-- create a function that takes in a price and returns the count of amount of items that are cheaper
-- https://stackoverflow.com/questions/26015160/deterministic-no-sql-or-reads-sql-data-in-its-declaration-and-binary-logging-i
DELIMITER //

CREATE FUNCTION count_of_cheaper_items(max_price NUMERIC) 
RETURNS INTEGER
READS SQL DATA -- for mysql, you need to specify what it does: https://dev.mysql.com/doc/refman/8.0/en/create-procedure.html
BEGIN 
	-- declare any variables
	DECLARE item_count INTEGER;

	-- performing operations
	SELECT COUNT(*) INTO item_count FROM items WHERE price < max_price;
	
	-- returning the result
	RETURN item_count;
END //

DELIMITER ;

SELECT count_of_cheaper_items(5.99);


-- ====================================== TRIGGERS =====================================

-- creating triggers: https://dev.mysql.com/doc/refman/8.0/en/create-trigger.html

-- create a trigger that responds to inserting into item table. 
-- It should update the count in aisles table

DELIMITER //
CREATE TRIGGER insert_item_trigger
-- before, after | insert, delete, update
AFTER INSERT ON items
FOR EACH ROW
BEGIN
	-- if inserted record is associated with aisle 1
	IF NEW.aisle_id = 1 THEN
		-- update aisle 1's count
		UPDATE aisles SET item_count = item_count + 1 WHERE id = 1;
	-- else if inserted record is associated with aisle 2
	ELSEIF NEW.aisle_id = 2 THEN
		-- update aisle 2's count
		UPDATE aisles SET item_count = item_count + 1 WHERE id = 2;
	-- else, update aisle 3
	ELSE
		UPDATE aisles SET item_count = item_count + 1 WHERE id = 3;
	END IF;
END //

DELIMITER ;

INSERT INTO items VALUES 	(default, 'Bandaids', 2.99, 99, 3),
							(default, 'Popsicles', 5.99, 50, 2),
							(default, 'Can of Soup', 0.99,99, 1),
							(default, 'Heat Pack', 8.99,55, 3),
							(default, 'Frozen Dinner', 4.99, 20, 2),
							(default, 'Crackers', 2.99,45, 1),
							(default, 'Medicine', 8.99, 20, 3),
							(default, 'Chicken Nuggets', 5.99,4, 2),
							(default, 'Hot Sauce', 1.99,10, 1),
							(default, 'Frozen Berries', 3.99, 20, 2),
							(default, 'Bottled Water', 4.99, 30, 1);
INSERT INTO items VALUES (default, 'Chips', 1.99, 99, 1);
SELECT * FROM aisles;


-- ======================================= STORED PROCEDURES ======================================

DELIMITER //

CREATE PROCEDURE restock_item_inventory(IN item_id INTEGER)
BEGIN
	UPDATE items SET inventory_count = 99 WHERE id = item_id;
END //

DELIMITER ;

CALL restock_item_inventory(5);

DELIMITER //

CREATE PROCEDURE get_max_price(OUT max_val NUMERIC(5, 2))
BEGIN
	SELECT MAX(price) INTO max_val FROM items;
END //

DELIMITER ;

CALL get_max_price(@max_price);

SELECT @max_price;

--  https://xpertdeveloper.com/transaction-mysql-stored-procedure/
















