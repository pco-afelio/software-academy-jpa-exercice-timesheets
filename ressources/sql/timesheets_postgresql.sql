create table employee (
     id serial primary key,
     firstname varchar(60) not null,
     name varchar(60) not null,
     login varchar(20) not null unique,
     password varchar(11) not null,
     unique (name, firstname)
);

create table project (
     id serial primary key,
     name varchar(50) not null unique,
     description varchar(100),
     startdate date not null,
     enddate date,
     manager integer not null references employee(id)
);

create table prestation (
     id serial primary key,
     day date not null,
     employee integer not null references employee(id),
     project integer not null references project(id) ,
     duration integer not null,
     comment varchar(200)
);

insert into employee(id, firstname, name, login, password) values(1, 'bruce', 'wayne', 'batman', 'I am Batman');
insert into employee(id, firstname, name, login, password) values(2, 'diana', 'prince', 'wonder', 'woman');
insert into employee(id, firstname, name, login, password) values(3, 'clark', 'kent', 'superman', 'kal-el');

insert into project(id, name, description, startdate, enddate, manager)
	values(1, 'Justice League', 'Superheros League', '2017-06-21', null, 1);
insert into project(id, name, description, startdate, enddate, manager)
	values(2, 'Fortress of Solitude', 'Be alone', '2017-06-21', null, 3);
	
insert into prestation(id, day, employee, project, duration, comment)
	values(1, '2017-06-22', 1, 1, 2, 'Send email');
insert into prestation(id, day, employee, project, duration, comment)
	values(2, '2017-06-23', 2, 1, 1, 'Read email');
insert into prestation(id, day, employee, project, duration, comment)
	values(3, '2017-06-23', 2, 1, 1, 'Send response');
	
select setval('prestation_id_seq', 4, true);

