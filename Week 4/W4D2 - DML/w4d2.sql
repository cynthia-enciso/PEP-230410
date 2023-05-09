DROP TABLE IF EXISTS pets;
DROP TABLE IF EXISTS vet_specialists;

create table vet_specialists(
	id integer auto_increment primary key,
	name varchar(100) NOT NULL,
	species varchar(100) NOT NULL,
	wage integer default 50000 -- you don't need not null if default is used
);

CREATE TABLE pets(
	id integer auto_increment primary key,
	name varchar(100) NOT NULL,
	age integer,
	weight numeric(5, 1) check (weight > 0),
	vaccinated boolean NOT NULL,
	species varchar(100) NOT NULL,
	date_of_last_visit date,
	vet_id integer, 
	foreign key (vet_id) references vet_specialists(id) 
);



-- you can choose an id value BUT you should not
INSERT INTO vet_specialists(id, name, species, wage) values(default, 'John Doe', 'Dog', 56000);
-- INSERT INTO vet_specialists values(default, 'John Doe', 'Dog', 56000);
-- INSERT INTO vet_specialists(name, species, wage) values('John Doe', 'Dog', 56000);
-- INSERT INTO vet_specialists(species, wage) values('Dog', 56000); -- violates not null constraint
INSERT INTO vet_specialists(name, species) values('Freddie', 'Cat');

INSERT INTO pets(name, age, weight, vaccinated, species, date_of_last_visit, vet_id)
values('Charlie', 3, 0.1, true, 'Dog', '2022-05-03', 1);
INSERT INTO pets(name, age, weight, vaccinated, species, date_of_last_visit)
values('Polly', 5, 1, true, 'Parrot', '2022-05-03');

INSERT INTO pets(name, age, weight, vaccinated, species, date_of_last_visit)
values('Garfield', 6, 20, true, 'Cat', '2022-03-03'),
('Nemo', 1, .2, false, 'Fish', '2023-01-12'),
('Hopper', 3, 1, true, 'Rabbit', '2019-10-02');



delete from vet_specialists where id = 2;

update pets set vaccinated = false where name = 'Polly';
update pets set date_of_last_visit = '2023-05-02' where weight > 0.5 AND species != 'Cat';

select * from pets;
select * from vet_specialists;