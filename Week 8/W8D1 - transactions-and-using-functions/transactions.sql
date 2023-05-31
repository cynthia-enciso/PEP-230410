-- https://dev.mysql.com/doc/refman/8.0/en/commit.html

START TRANSACTION;
SELECT * FROM people;
COMMIT;

-- atomic (all should succeed or else none do)
START TRANSACTION;
UPDATE people set state = 'AL' WHERE id = 1;
UPDATE poeple set age = 'AL' WHERE id = 1;
COMMIT;

-- consistent (changes made by transaction make sense given previous state of the data)
START TRANSACTION;
SELECT avg(age) from people;
INSERT INTO people VALUES (default, 'Jacob', 'McGuire', 'TN', 8, 100, 2);
COMMIT;

START TRANSACTION;
SELECT avg(age) from people;
SAVEPOINT my_savepoint;
INSERT INTO people VALUES (default, 'Jacob', 'McGuire', 'TN', 8, 100, 2);
ROLLBACK TO my_savepoint;
COMMIT;

SELECT avg(age) from people;

-- isolated
-- instead of two separate transactions where one depends on the other...
START TRANSACTION;
UPDATE people set iq = 100 WHERE id = 1;
COMMIT;

START TRANSACTION;
UPDATE people set iq_type = 2 WHERE id = 1;
COMMIT;

-- create one single transaction
START TRANSACTION;
UPDATE people set iq = 100 WHERE id = 1;
UPDATE people set iq_type = 2 WHERE id = 1;
COMMIT;

-- durability

