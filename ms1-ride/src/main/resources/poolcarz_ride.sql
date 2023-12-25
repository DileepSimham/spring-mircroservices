drop database if exists poolcarz_ride;
create database poolcarz_ride;
use poolcarz_ride;

create table ride_details(
	ride_id integer not null auto_increment,
    car_type varchar(50),
    source varchar(50),
    destination varchar(50),
    seats_available integer,
    primary key(ride_id)
);

create table booking_details(
	booking_id integer not null auto_increment,
    ride_id integer,
    user_email varchar(50),
    booking_status varchar(50),
    primary key(booking_id)
);

insert into `ride_details` values(1, 'Economy', 'Canal Street', 'Modison',3);
insert into `ride_details` values(2, 'Sedan', 'Houston Street', 'Manhattan',0);
insert into `ride_details` values(3, 'Premier', 'Stienway Street', 'Christopher Street',4);
insert into `ride_details` values(4, 'Economy', 'Bourbon Street', 'Broadway',2);
insert into `ride_details` values(5, 'Sedan', 'Bourbon Street', 'Broadway',4);
insert into `ride_details` values(6, 'Premier', 'Canal Street', 'Modison',4);
insert into `ride_details` values(7, 'Economy', 'Canal Street', 'Manhattan',4);

insert into `booking_details` values(601,1,'John@infy.com','Booked');
insert into `booking_details` values(602,4,'Bob@infy.com','Completed');
insert into `booking_details` values(603,4,'Bob@infy.com','Booked');
insert into `booking_details` values(604,4,'Ken@infy.com','Booked');
insert into `booking_details` values(605,2,'Jack@infy.com','Booked');
insert into `booking_details` values(606,2,'Ria@infy.com','Booked');
insert into `booking_details` values(607,2,'Paul@infy.com','Booked');
insert into `booking_details` values(608,2,'Liz@infy.com','Booked');


