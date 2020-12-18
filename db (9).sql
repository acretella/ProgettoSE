drop table if exists Planner cascade;
drop table if exists Activity cascade;
drop table if exists Material cascade;
drop table if exists Material_for_Activity cascade;
drop table if exists Procedura cascade;
drop table if exists Competence cascade;
drop table if exists Competence_for_Procedure cascade;
drop table if exists Maintainer cascade;
drop table if exists Availability cascade;
drop table if exists DISPONIBILITA_MANUTENTORE cascade;
drop table if exists Competence_for_Maintainer cascade;
drop table if exists Maintainer_for_Activity cascade;
drop table if exists Site cascade;
drop table if exists FactorySite cascade;
drop table if exists Area cascade;



create table Planner (
	username varchar(15) primary key,
	psw varchar(15) not null
);

create table Procedura(
	id_ integer primary key,
	smp_path varchar(200) null
);
create table FactorySite(factory_site varchar(20) primary key);
create table Area(area varchar(20) primary key);

create table Site(
	factory_site varchar(20) references FactorySite(factory_site) on delete cascade on update cascade,
	area varchar(20) references Area(area) on delete cascade on update cascade,
	primary key(factory_site,area)
);

create table Activity (
	id_ integer,
	factorySite varchar(20) not null references FactorySite(factory_site) on delete cascade on update cascade,
	area varchar(20) not null references Area(area) on delete cascade on update cascade,
	typology varchar(15) not null,
	description varchar(150) ,
	estimatedTime integer not null,
	week integer not null ,
	interruptable bool not null,
	workSpaceNotes varchar(150),
	activityType integer not null check(activityType >=0 and activityType <= 2),
	procedura integer references Procedura(id_) on delete set null on update cascade,
	giorno integer null check(giorno >=1 and giorno<=31),
	constraint check_week check(week>=1 and week<=52),
	constraint check_id primary key(id_)
);


create table Material(
	materialName varchar(20) primary key
);

create table Material_for_Activity(
	activity integer references Activity(id_) on delete cascade on update cascade,
	material varchar(20) references Material(materialName) on delete cascade on update cascade,
	primary key (activity,material)
);

create table Competence(
	skill varchar(30) primary key
);

create table Competence_for_Procedure(
	competence varchar(20) references Competence(skill) on delete cascade on update cascade,
	procedura int references Procedura(id_) on delete cascade on update cascade,
	primary key(competence,procedura)
);

create  table Maintainer 
(
   Nome             varchar(50)         not null,
   ID_MAN               		   integer         not null,
   constraint PK_MANUTENTORE primary key (ID_MAN)
);

create table DISPONIBILITA_MANUTENTORE 
(
   ID_MAN              integer                   not null,
   ID_DISPONIBILITA     integer                    not null,
   constraint PK_DISPONIBILITA_MANUTENTORE primary key  (ID_MAN, ID_DISPONIBILITA)
);

create table Availability
(
   Giorno              integer                        not null check(Giorno>=0 and Giorno<=6),
   Settimana           integer                        not null check(Settimana>=1 and Settimana<=52),
   Ora                  integer                        not null check (Ora>=0 and Ora<=6),
   Minuti              integer                        not null check (minuti>=0 and minuti<=60),
   ID_DISPONIBILITA     integer                     not null,
   constraint PK_DISPONIBILITA primary key  (ID_DISPONIBILITA)
);

 create table Competence_for_Maintainer
(
   ID_MAN               integer                     not null,
   NOMECOMPETENZA       varchar(20)                    not null,
   constraint PK_COMPETENZE_MANUTENTORE primary key (ID_MAN, NOMECOMPETENZA)
);

create table Maintainer_for_Activity(
	maintainer integer,
	activity integer,
	day_of_week integer,
	hour_of_day integer,
	minutes_first_cell integer,
	constraint maintainer_for_activity_pkey primary key(maintainer,activity)
);

alter table Maintainer_for_Activity
	add constraint FK_MAINTAINER foreign key (maintainer) references Maintainer(ID_MAN) on delete cascade on update cascade,
	add constraint FK_ACTIVITY foreign key (activity) references Activity(id_) on delete cascade on update cascade;


alter table Competence_for_Maintainer
   add constraint FK_COMPETEN_COMPETENZ_MANUTENT foreign key (ID_MAN)
      references Maintainer (ID_MAN)
      on update cascade
      on delete cascade;

alter table Competence_for_Maintainer
   add constraint FK_COMPETEN_COMPETENZ_COMPETEN foreign key (NOMECOMPETENZA)
      references Competence (skill)
      on update cascade
      on delete cascade;


alter table DISPONIBILITA_MANUTENTORE
   add constraint FK_DISPONIB_DISPONIBI_MANUTENT foreign key (ID_MAN)
      references Maintainer (ID_MAN)
      on update cascade
      on delete cascade;

alter table DISPONIBILITA_MANUTENTORE
   add constraint FK_DISPONIB_DISPONIBI_DISPONIB foreign key (ID_DISPONIBILITA)
      references Availability (ID_DISPONIBILITA)
      on update cascade
      on delete cascade;



-- insert into Planner(username,psw) values 
-- 	('Consalvo','nello'),
-- 	('Aniella','DeViva');

--insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,interruptable,workSpaceNotes,activityType) values 
--	(1,'branch office','department','electrical','aaaaaaaa',100,1,true,'ddddddddd',1),
--	(2,'fffff','dddddd','mechanic','hhhhhhhh',100,2,false,'eeeeee',1);

-- insert into Material(materialName) values ('martello'),('forbici');
-- insert into Material_for_Activity(activity,material) values (1,'martello'),(1,'forbici');
	
-- select * from Material_for_Activity,Activity where activity = id_;	

drop user if exists Alessio;
create user Alessio with password '12345';
grant all privileges on Planner to Alessio;
grant all privileges on Activity to Alessio;
grant all privileges on Material to Alessio;
grant all privileges on Material_for_Activity to Alessio;
grant all privileges on Procedura to Alessio;
grant all privileges on Competence to Alessio;
grant all privileges on Competence_for_Procedure to Alessio;
grant all privileges on Maintainer to Alessio;
grant all privileges on Competence_for_Maintainer to Alessio;
grant all privileges on Availability to Alessio;
grant all privileges on DISPONIBILITA_MANUTENTORE to Alessio;
grant all privileges on Maintainer_for_Activity to Alessio;
grant all privileges on Site to Alessio;
grant all privileges on FactorySite to Alessio;
grant all privileges on Area to Alessio;

--revoke all privileges on Planner from Alessio;
--revoke all privileges on Activity from Alessio;
--revoke all privileges on Material from Alessio;
--revoke all privileges on Material_for_Activity from Alessio;
--revoke all privileges on Procedura from Alessio;
--revoke all privileges on Competence from Alessio;
--revoke all privileges on Competence_for_Procedure from Alessio;
--revoke all privileges on Competence_for_Procedure from Alessio;
--revoke all privileges on Maintainer from Alessio;
--revoke all privileges on Competence_for_Maintainer from Alessio;
--revoke all privileges on Availability from Alessio;
--revoke all privileges on Maintainer_for_Activity from Alessio;
--revoke all privileges on Site from Alessio;
--revoke all privileges on FactorySite from Alessio;
--revoke all privileges on Area from Alessio;

--select * from Maintainer
--Select * from Competence_for_Maintainer
--select * from Availability


insert into Maintainer(nome,ID_MAN) values ('Antonio Rossi',1);
insert into Maintainer(nome,ID_MAN) values ('Giovanni Verdi',2);
insert into Maintainer(nome,ID_MAN) values ('Zlatan Ibrahimovic',3);

insert into Availability(giorno,settimana,ora,minuti,ID_DISPONIBILITA) values
	(1,1,1,20,1),(1,1,2,60,2),(1,1,3,30,3),(5,1,3,60,4),(5,1,4,40,5),
	(3,2,2,20,6),(3,2,3,60,7),(3,2,4,30,8),(4,2,4,60,9),(4,2,5,30,10),
	(4,3,1,20,11),(4,3,2,50,12),(2,3,5,60,13),(2,3,6,60,14),(4,3,1,20,15),(5,3,5,40,16),--m1
	(2,1,4,40,17),(2,1,5,60,18),(2,1,6,60,19),(3,1,1,60,20),(3,1,2,60,21),(5,1,4,60,22),(5,1,6,40,23),(6,1,4,30,24),
	(3,2,5,30,25),(3,2,6,60,26),(5,2,0,60,27),(5,2,1,60,28),(5,2,2,30,29),(6,2,0,60,30),(6,2,1,60,31),(6,2,2,20,32),
	(5,3,3,20,33),(5,3,4,60,34),(6,3,0,60,35),(6,3,1,60,36),(6,3,2,60,37),(6,3,1,20,38),--m2
	(4,1,0,60,39),(4,1,1,60,40),(4,1,2,60,41),(4,1,0,60,42),(5,1,3,60,43),(5,1,4,60,44),(5,1,5,20,45),
	(6,2,3,60,46),(6,2,4,60,47),(6,2,5,60,48),(6,2,6,60,49),
	(0,3,0,60,50),(0,3,3,60,51),(2,3,3,60,52),(2,3,4,10,53),(4,3,2,50,54),(4,3,3,15,55),(5,3,5,60,56),(6,3,0,60,57),--m3
	(1,50,1,20,58),(1,50,2,60,59),(1,50,3,30,60),(5,50,3,60,61),(5,50,4,40,62),
	(3,50,2,20,63),(3,50,3,60,64),(3,50,4,30,65),(4,50,4,60,66),(4,50,5,30,67),
	(4,50,1,20,68),(4,50,2,50,69),(2,50,5,60,70),(2,50,6,60,71),(4,50,1,20,72),(5,50,5,40,73),--m1
	(2,50,4,40,74),(2,50,5,60,75),(2,50,6,60,76),(3,50,1,60,77),(3,50,2,60,78),(5,50,4,60,79),(5,50,6,40,80),(6,50,4,30,81),
	(3,50,5,30,82),(3,50,6,60,83),(5,50,0,60,84),(5,50,1,60,85),(5,50,2,30,86),(6,50,0,60,87),(6,50,1,60,88),(6,50,2,20,89),
	(5,50,3,20,90),(5,50,4,60,91),(6,50,0,60,92),(6,50,1,60,93),(6,50,2,60,94),(6,50,1,20,95),--m2
	(4,50,0,60,96),(4,50,1,60,97),(4,50,2,60,98),(4,50,0,60,99),(5,50,3,60,100),(5,50,4,60,101),(5,50,5,20,102),
	(6,50,3,60,103),(6,50,4,60,104),(6,50,5,60,105),(6,50,6,60,106),
	(0,50,0,60,107),(0,50,3,60,108),(2,50,3,60,109),(2,50,4,10,110),(4,50,2,50,111),(4,50,3,15,112),(5,50,5,60,113),(6,50,0,60,114);--m3
	
insert into DISPONIBILITA_MANUTENTORE(ID_MAN, ID_DISPONIBILITA) values
	(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),
	(1,58),(1,59),(1,60),(1,61),(1,62),(1,63),(1,64),(1,65),(1,66),(1,67),(1,68),(1,69),(1,70),(1,71),(1,72),(1,73);
insert into DISPONIBILITA_MANUTENTORE(ID_MAN, ID_DISPONIBILITA) values
	(2,17),(2,18),(2,19),(2,20),(2,21),(2,22),(2,23),(2,24),(2,25),(2,26),(2,27),(2,28),(2,29),(2,30),(2,31),
	(2,32),(2,33),(2,34),(2,35),(2,36),(2,37),(2,38),
	(2,74),(2,75),(2,76),(2,77),(2,78),(2,79),(2,80),(2,81),(2,82),(2,83),(2,84),(2,85),(2,86),(2,87),(2,88),
	(2,89),(2,90),(2,91),(2,92),(2,93),(2,94),(2,95);
insert into DISPONIBILITA_MANUTENTORE(ID_MAN, ID_DISPONIBILITA) values
	(3,39),(3,40),(3,41),(3,42),(3,43),(3,44),(3,45),(3,46),(3,47),(3,48),(3,49),(3,50),
	(3,51),(3,52),(3,53),(3,54),(3,55),(3,56),(3,57),
	(3,96),(3,97),(3,98),(3,99),(3,100),(3,101),(3,102),(3,103),(3,104),(3,105),(3,106),(3,107),
	(3,108),(3,109),(3,110),(3,111),(3,112),(3,113),(3,114);
	
	
insert into Competence(skill) values 
	('B2 English'),('Electrician'),('carpenter'),('skilltest1'),('skilltest2');

insert into Procedura(id_,smp_path) values(1,'C:\Users\Daniele\OneDrive\Desktop\Progetto SE\SMP NUMERO 1.pdf');

insert into Competence_for_Procedure (procedura,competence) values 
	(1,'B2 English'), (1,'Electrician'),(1,'skilltest1'),(1,'skilltest2');

insert into FactorySite values('branch office');
insert into Area values('departement');
insert into Site(factory_site,area) values('branch office','departement');

insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,interruptable,workSpaceNotes,activityType,procedura) values 
	(1,'branch office','departement','electrical','aaaaaaaa',100,1,true,'ddddddddd',0,1);
	
insert into Activity(id_,factorySite,area,typology,description,estimatedTime,week,interruptable,workSpaceNotes,activityType,procedura,giorno) values 
	(2,'branch office','departement','electrical','aaa',20,1,true,'ddddddddd',1,1,16);

insert into Competence_for_Maintainer(ID_MAN,NOMECOMPETENZA) values
	(1,'Electrician'),(1,'skilltest1'),(1,'skilltest2'),
	(2,'B2 English'),(2,'skilltest1'),
	(3,'Electrician'),(3,'B2 English'),(3,'skilltest1'),(3,'skilltest2');

insert into Material(materialName) values ('martello'),('cacciavite'),('tenaglia');

--update Availability set minuti = 20 where ID_DISPONIBILITA in 
--	(select ID_DISPONIBILITA from DISPONIBILITA_MANUTENTORE where ID_MAN = 1)
--	and settimana =1 and giorno=1 and ora=1;
--select * from DISPONIBILITA_MANUTENTORE as a inner join Availability as b on a.ID_DISPONIBILITA=b.ID_DISPONIBILITA

--select * from Activity
--delete from Activity where id_=99;
--select * from Maintainer_for_Activity

--update Activity set workSpaceNotes='1111asds' where id_=78

--select * from material_for_activity
--delete from Activity where id_ =2;
--delete from Procedura;
--select * from Procedura;
--select max(id_) from Procedura
--select * from Competence_for_Procedure

create or replace function manage_create_update_site() returns trigger as $$
begin
	if(not exists(select * from FactorySite where factory_site = new.factory_site)) then
		insert into FactorySite values(new.factory_site);
	end if;
	if(not exists(select area from Area where area = new.area)) then
		insert into Area values(new.area);
	end if;
	return new;
end $$ language plpgsql;

create or replace function manage_delete_site() returns trigger as $$
begin
	if(not exists(select * from Site where factory_site = old.factory_site)) then
		delete from FactorySite where factory_site = old.factory_site;
	end if;
	if(not exists(select area from Site where area = old.area)) then
		delete from area where area = old.area;
	end if;
	return null;
end $$ language plpgsql;

create trigger manage_site
	before insert or update on Site for each row
	execute procedure manage_create_update_site();

create trigger manage2_site
	after delete on Site for each row
	execute procedure manage_delete_site();
	
