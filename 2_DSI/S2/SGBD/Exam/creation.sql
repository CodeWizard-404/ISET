drop table vente cascade constraints;
drop table billet cascade constraints;
drop table participer cascade constraints;
drop table spectacle cascade constraints;
drop table chanteur cascade constraints;
drop table salle cascade constraints;
drop table Modif_Salles;
drop table Supp_Salles;


create table Salle(
salleID number(4),
nom varchar2(30),
adresse varchar2(50),
capacite number(3),
constraint cp_salle primary key(salleID));

create table chanteur(
chanteurID number(5),
nomchanteur varchar2(50),
constraint cp_chanteur primary key(chanteurID));

create table spectacle(
spectacleID varchar2(6),
titre varchar2(60),
dateSpectacle date,
heure date,
salleID number(4),
constraint cp_spec primary key(spectacleID),
constraint ce_spec_salle foreign key(salleID) references salle(salleID),
constraint ck_id check (spectacleID like 'SP____'));

create table participer(
spectacleID varchar2(6),
chanteurID number(5),
constraint cp_part primary key(spectacleID,chanteurID),
constraint ce_spec_part foreign key(spectacleID) references spectacle(spectacleID),
constraint ce_chant_part foreign key(chanteurID) references chanteur(chanteurID));

create table billet(
billetID varchar2(12),
numPlace number(3),
prix number(10,3),
spectacleID varchar2(6),
constraint cp_billet primary key(billetID),
constraint ce_spec_billet foreign key(spectacleID) references spectacle(spectacleID));

create table vente(
venteID varchar2(10),
MoyenPaiement varchar2(50),
dateVente date,
billetID varchar2(12),
constraint cp_vente primary key(venteID),
constraint ce_vente_billet foreign key(billetID) references billet(billetID));

create table Modif_Salles(
salleID number(4),
nom varchar2(30),
adresse varchar2(50),
capacite number(3),
dateModif date);

create table Supp_Salles(
salleID number(4),
nom varchar2(30),
adresse varchar2(50),
capacite number(3),
dateSupp date);

