drop table passager;
drop table vol;
drop table avion;
drop table Archive_Passager;
drop table Stat;

create table avion(
codeAv varchar2(10),
marque varchar2(50),
nbrePlaces number(3),
constraint pk_avion primary key(codeAv));

create table vol(
numVol varchar2(10),
dateVol date,
source varchar2(60),
destination varchar2(60),
codeAv varchar2(10),
constraint pk_vol primary key(numVol),
constraint fk_vol_av foreign key (codeAv) references avion(codeAv));

create table passager(
codePass varchar2(20),
typePass varchar2(100),
nomPass varchar2(100),
prenomPass varchar2(100),
prixPaye number(5),
numVol varchar2(10),
constraint pk_pass primary key(codePass),
constraint fk_pass_vol foreign key (numVol) references vol(numVol),
constraint ck_type check(lower(typePass) in ('vip','fidele','normal')));

create table Stat(
numVol varchar2(10),
source varchar2(60),
destination varchar2(60),
NbPassager number,
CA number,
constraint pk_stat primary key(numVol));

create table Archive_Passager(
codePass varchar2(20),
typePass varchar2(100),
nomPass varchar2(100),
prenomPass varchar2(100),
prixPaye number(5),
numVol varchar2(10),
constraint pk_archive primary key(codePass));
