delete from passager;
delete from vol;
delete from avion;

insert into avion values('A251','AirBus',180);
insert into avion values('A252','Boeing',220);
insert into avion values('A253','AirBus',300);

insert into vol values('TU701',to_date('22/07/2020','DD/MM/YYYY'),'Tunis','Paris','A251');
insert into vol values('TU702',to_date('25/07/2020','DD/MM/YYYY'),'Tunis','Paris','A253');
insert into vol values('TU703',to_date('26/07/2020','DD/MM/YYYY'),'Paris','Tunis','A251');
insert into vol values('TU704',to_date('23/07/2020','DD/MM/YYYY'),'Berlin','Tunis','A252');
insert into vol values('TU705',to_date('21/07/2020','DD/MM/YYYY'),'Djerba','Rome','A253');

insert into passager values('P401','VIP','Makni','Salah',1302,'TU701');
insert into passager values('P402','VIP','Tounsi','Mahmoud',1342,'TU701');
insert into passager values('P403','VIP','Kefi','Ali',1211,'TU701');
insert into passager values('P404','NORMAL','Amiri','Omar',678,'TU702');
insert into passager values('P405','NORMAL','Ben Salah','Mehdi',552,'TU702');
insert into passager values('P406','FIDELE','Ben Fraj','Houda',897,'TU705');
insert into passager values('P407','VIP','Melki','Ranim',442,'TU705');
insert into passager values('P408','NORMAL','Ayari','Yessine',1450,'TU705');
insert into passager values('P409','FIDELE','Romdhani','Amine',645,'TU703');
insert into passager values('P410','NORMAL','Hammami','Meriem',889,'TU703');


