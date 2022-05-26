create table fly_reservation(
	Id INTEGER PRIMARY KEY AUTOINCREMENT,
	Reservation integer default null,
	Fly_Time varchar(255) default null,
	Update_Time timestamp '0000-00-00 00:00:00' null,
	Record_Time timestamp default CURRENT_TIMESTAMP null
);

insert into fly_reservation(Id, Reservation, Fly_Time) values(1, 0, "16:35");
insert into fly_reservation(Reservation, Fly_Time) values(0, "16:35");
insert into fly_reservation(Reservation, Fly_Time) values(0, "16:35");
insert into fly_reservation(Reservation, Fly_Time) values(0, "16:35");
insert into fly_reservation(Reservation, Fly_Time) values(0, "16:35");