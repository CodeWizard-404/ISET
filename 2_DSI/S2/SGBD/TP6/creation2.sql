drop table cat_four;

create table cat_four(
codf number(4),
nomf varchar2(20),
nbProd number(4),
CA number(10,3),
categorie varchar2(30),
constraint pk_catf_codf primary key(codf));

drop table Reapp;

create table Reapp(
refp varchar2(6),
libp varchar2(20),
Q_reap number(4),
Mnt_reap number(10,3),
New_Stock number(4),
constraint pk_reap_ref primary key(refp));

drop table credi_cli;

create table credi_cli(
codc number(4),
ville varchar2(20),
cred number(10,3),
pourcentCredCA varchar2(20),
PourcentCredCredMax varchar2(20));
