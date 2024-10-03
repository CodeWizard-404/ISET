drop table ligne cascade constraints;
drop table client cascade constraints;

create table client
(
idclient number(3),
Nomclient varchar2(20),
Ville   varchar2(20),
Constraint cp_client primary key (idclient)) ;

insert into client values (10,'salem','tunis') ;
insert into client values (20,'midouni','kef') ;
insert into client values (30,'masmoudi','gabes') ;
insert into client values (40,'kassem','tunis') ;
insert into client values (50,'lamine','sfax') ;
insert into client values (60,'salah','tunis') ;
insert into client values (70,'Ahmed','tunis') ;


Create table ligne 
(numligne number (8),
Datechargement date,
Montantdisponible number,
etat varchar2(20),
dateepuisement date,
idclient number(3),
Constraint cp_ligne primary key (numligne), 
Constraint ce_ligne_client foreign key (idclient) references client(idclient)) ;

insert into ligne values(97888444,to_date('01/02/2020','dd/mm/yyyy'),2,'normal',to_date('01/05/2020','dd/mm/yyyy'),10) ;
insert into ligne values(99555321,to_date('05/12/2019','dd/mm/yyyy'),0,'reception',to_date('05/02/20','dd/mm/yyyy'),10) ;
insert into ligne values(93454545,to_date('30/01/2020','dd/mm/yyyy'),7,'normal',to_date('30/04/2020','dd/mm/yyyy'),10) ;
insert into ligne values(98700077,to_date('13/02/2020','dd/mm/yyyy'),11,'normal',to_date('13/05/2020','dd/mm/yyyy'),20) ;
insert into ligne values(95444565,to_date('05/06/2017','dd/mm/yyyy'),1,'reception',to_date('05/09/2017','dd/mm/yyyy'),30) ;
insert into ligne values(97555634,to_date('09/05/2017','dd/mm/yyyy'),0,'bloque',to_date('09/08/2017','dd/mm/yyyy'),40) ;
insert into ligne values(97890000,to_date('07/10/2017','dd/mm/yyyy'),0,'reception',to_date('07/01/2017','dd/mm/yyyy'),40) ;
insert into ligne values(97807807,to_date('02/03/2019','dd/mm/yyyy'),0,'bloque',to_date('09/05/2019','dd/mm/yyyy'),40) ;
insert into ligne values(95565670,to_date('07/12/2017','dd/mm/yyyy'),0,'bloque',to_date('07/03/2017','dd/mm/yyyy'),40) ;
insert into ligne values(97303004,to_date('07/12/2017','dd/mm/yyyy'),0,'reception',to_date('09/08/2017','dd/mm/yyyy'),40) ;
insert into ligne values(96212134,to_date('09/10/2022','dd/mm/yyyy'),0,'bloque',to_date('09/01/2023','dd/mm/yyyy'),40);
insert into ligne values(98888401,to_date('19/02/2020','dd/mm/yyyy'),22,'normal',to_date('19/05/2020','dd/mm/yyyy'),20) ;
insert into ligne values(95334343,to_date('05/01/2020','dd/mm/yyyy'),23,'normal',to_date('05/04/2020','dd/mm/yyyy'),50) ;
insert into ligne values(94335456,to_date('14/02/2020','dd/mm/yyyy'),50,'normal',to_date('14/05/2020','dd/mm/yyyy'),60) ;
insert into ligne values(93565000,to_date('03/03/2020','dd/mm/yyyy'),25,'normal',to_date('03/06/2020','dd/mm/yyyy'),60) ;
commit;