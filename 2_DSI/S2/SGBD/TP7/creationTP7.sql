drop index i_nomc;
drop index i_libp;
drop index i_nomf;
drop table frs_prod cascade constraints;
drop table lig_cde cascade constraints;
drop table commande cascade constraints;
drop table fournisseur cascade constraints;
drop table produit cascade constraints;
drop table client cascade constraints;

create table client(
codc number(4),
nomc varchar2(20),
ville varchar2(20),
constraint pk_codc primary key(codc));

create table commande(
numc number(4),
datec date,
mntc number(10,3),
codc number(4),
constraint pk_numc primary key(numc));

create table produit(
refp varchar2(6),
libp varchar2(20),
pu number(10,3),
qtes number(4),
seuil number(4),
constraint pk_ref primary key(refp));

create table fournisseur(
codf number(4),
nomf varchar2(20),
villef varchar2(10),
constraint pk_codf primary key(codf));

create table lig_cde(
numc number(4),
refp varchar2(6),
qtec number(4),
constraint pk_nr primary key(numc,refp));

create table frs_prod(
codf number(4),
refp varchar2(6),
puf number(10,3),
qtef number(4),
constraint pk_cr primary key(codf,refp));

alter table commande
add
constraint fk_codc foreign key(codc) references client(codc);

alter table commande
modify
codc not null;

alter table lig_cde
add
(
constraint fk_numc foreign key(numc) references commande(numc),
constraint fk_refp foreign key(refp) references produit(refp)
);

alter table frs_prod
add
(
constraint fk_codf foreign key(codf) references fournisseur(codf),
constraint fk_reff foreign key(refp) references produit(refp)
);

alter table client
add
(
ca number(10,3),
cred number(10,3),
credmax number(10,3)
);

alter table client
modify
ville varchar2(10);

alter table client
add
constraint ck_cred check(cred<=credmax);

alter table produit
add
(
constraint ck_qtes check(qtes>=0),
constraint ck_seuil check(seuil>0)
);

alter table lig_cde
add
constraint ck_qtec check(qtec>0);

alter table frs_prod
add
constraint ck_qtef check(qtef>0);

create index i_nomc on client(nomc);

create index i_libp on produit(libp);

create index i_nomf on fournisseur(nomf);
