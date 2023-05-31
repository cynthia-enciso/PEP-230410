SELECT * from people;

-- aggregate functions
SELECT sum(age)
FROM people;

SELECT min(iq)
FROM people;

SELECT max(iq)
FROM people;

SELECT COUNT(*)
FROM people;

SELECT COUNT(state)
from people;

SELECT COUNT(DISTINCT state)
from people;

-- cannot return a nonaggregate column along with an aggregate function
SELECT id, count(state)
from people;

SELECT sum(age), count(state)
from people;

-- scalar functions: https://ramkedem.com/en/mysql-scalar-functions/
SELECT UCASE(first_name)
FROM people;

-- returns a substring
SELECT MID(first_name, 1, 2)
from people;

-- ciel() and floor()
SELECT ROUND(avg(iq))
FROM people;

SELECT avg(iq)
from people;

-- GROUP BY
SELECT COUNT(state)
from people
GROUP BY state;

SELECT state, COUNT(state)
from people
GROUP BY state;

-- ORDER BY VS GROUP BY
SELECT state, COUNT(state)
from people
GROUP BY state
ORDER BY state ASC;

-- HAVING
SELECT state, count(id)
from people
GROUP BY state;

SELECT state, count(id)
from people
WHERE state != 'TX'
GROUP BY state;

SELECT state, count(id)
from people
GROUP BY state
HAVING count(id) > 1;

SELECT state, count(id)
from people
GROUP BY state
HAVING state != 'TX';

SELECT state, count(id)
from people
WHERE state != 'TX'
GROUP BY state
HAVING count(id) > 1;

