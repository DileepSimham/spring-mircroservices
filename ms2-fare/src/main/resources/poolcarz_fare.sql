drop database if exists poolcarz_fare;
create database poolcarz_fare;
use poolcarz_fare;

create table fare_details(
	fare_id integer not null,
    source varchar(50),
    destination varchar(50),
    fare integer,
    primary key(fare_id)
);

insert into `fare_details` values(1, 'Canal Street', 'Madison',1200);
insert into `fare_details` values(2, 'Houston Street', 'Manhatan',800);
insert into `fare_details` values(3, 'Stienway Street', 'Christopher Street',950);
insert into `fare_details` values(4, 'Bourbon Street', 'Broadway',900);
insert into `fare_details` values(5, 'Christopher Street', 'Canal Street',750);


