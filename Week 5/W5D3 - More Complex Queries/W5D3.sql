SELECT * FROM memberships;
SELECT * FROM books;
SELECT * FROM dvds;

-- ====================================================================
-- JOIN
/*
 * SELECT <which columns>
 * FROM <table1>
 * JOIN <table2>
 * ON <which condition>;
 * 
 * */

-- INNER JOIN: returns matches (can omit 'inner' keyword)
-- get information about members who have checked out books
-- SELECT * FROM memberships WHERE book_checked_out IS NOT NULL;
-- 
-- SELECT *
-- FROM memberships AS m 
-- INNER JOIN books b -- ' books b' is just like 'books AS b' 
-- ON m.book_checked_out = b.isbn;

-- SELECT m.first_name, m.last_name, b.title 
-- FROM memberships AS m 
-- INNER JOIN books b 
-- ON m.book_checked_out = b.isbn;

-- LEFT JOIN / LEFT OUTER JOIN
-- lets get all the members and see whether or not they've checked out a book
-- SELECT m.first_name, m.last_name, b.title 
-- FROM memberships m 
-- LEFT JOIN books b 
-- ON m.book_checked_out = b.isbn;

-- RIGHT JOIN
-- lets get all dvds and see whether or not they've been checked out and by whom
-- SELECT d.title, d.genre, m.first_name , m.last_name 
-- FROM memberships m
-- RIGHT JOIN dvds d 
-- ON d.id = m.dvd_checked_out;

-- SELECT *
-- FROM memberships m
-- RIGHT JOIN dvds d 
-- ON d.id = m.dvd_checked_out;

-- CROSS JOIN (cartesian product or join) can omit cross keyword
-- I want to see all possible combinations of books and dvds I can rent
SELECT b.title , d.title
FROM books AS b 
CROSS JOIN dvds d;


-- ==========================================================
-- SET Operators
-- select same amount of columns
-- selected columns datatypes must match
-- selected columns order must match

-- UNION 
-- give me all items I can check out
SELECT title
FROM books
UNION
SELECT title 
FROM dvds;

-- INTERSECT
-- return common genres from both books and dvds
SELECT genre
FROM books
INTERSECT
SELECT genre 
FROM dvds;

-- EXCEPT (minus)
-- return unique genres from books that aren't listed in dvds
SELECT genre
FROM books
EXCEPT
SELECT genre 
FROM dvds;

-- SELF
-- give me combinations of two books where they are NOT the same book but have the same genre
SELECT a.title, b.title 
FROM books a, books b
WHERE a.isbn != b.isbn AND a.genre = b.genre;

-- Thanks, Fatima!
SELECT b1.title, b1.genre, b2.title, b2.genre
FROM books b1, books b2
WHERE b1.title <> b2.title
AND b1.genre = b2.genre
LIMIT 1;

-- FULL JOIN
SELECT m.first_name , m.last_name , b.title 
FROM memberships m 
LEFT JOIN books b 
ON m.book_checked_out = b.isbn 
UNION
SELECT m.first_name , m.last_name , b.title 
FROM memberships m 
RIGHT JOIN books b
ON m.book_checked_out = b.isbn;

-- view
CREATE VIEW full_join AS
SELECT *
FROM memberships m 
LEFT JOIN books b 
ON m.book_checked_out = b.isbn 
UNION
SELECT *
FROM memberships m 
RIGHT JOIN books b
ON m.book_checked_out = b.isbn;

SELECT * FROM full_join;

SELECT * FROM full_join WHERE page_count > 500;

-- DROP VIEW full_join;

-- CROSS JOIN using membership and books COMBINED WITH WHERE to rule out any not null (or unavailable books) 
-- create view that JUST contains available books
CREATE VIEW availabe_books AS 
SELECT b.title
FROM memberships m 
RIGHT JOIN books b 
ON m.book_checked_out = b.isbn WHERE book_checked_out IS NULL;

DROP VIEW availabe_books;

CREATE VIEW availabe_dvds AS 
SELECT d.title
FROM memberships m 
RIGHT JOIN dvds d
ON m.dvd_checked_out = d.id WHERE dvd_checked_out IS NULL;

SELECT *
FROM availabe_books
CROSS JOIN availabe_dvds;


