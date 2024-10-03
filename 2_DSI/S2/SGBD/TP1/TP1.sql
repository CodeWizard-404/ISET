--1
create table
    client (
        Codc number(4) primary key,
        Nomc varchar(20),
        Ville varchar(20),
        constraint pk_Codc primary key (Codc)
    );

create table
    commande (
        Numc number(4) primary key,
        Datec Date,
        Mntc number(4),
        constraint pk_Numc primary key (Numc),
        constraint fk_Codc foreign key (Codc) references Client (Codc)
    );

create table
    produit (
        RefP varchar(6) primary key,
        Libp varchar(20),
        PU number(10.3),
        Qtes number(4),
        seuil number(4),
        constraint pk_RefP primary key (refP)
    );

create table
    fournisseur (
        Codf number(4),
        Nomf varchar(20),
        Villef varchar(10),
        constraint pk_codf primary key (codf),
    );

create table
    Lig_cde (
        Numc number(4),
        RefP varchar(6),
        Qtec number(4),
        constraint pk_nr primary key (Numc, RefP),
        constraint fk_nr_Numc foreign key (Numc) references Commande (Numc),
        constraint fk_nr_RefP foreign key (RefP) references Produit (RefP)
    );

create table
    Frs_Prod (
        Codf number(4),
        RefP varchar(6),
        PUf number(10.3),
        Qted number(4),
        constraint pk_Frs_Prod primary key (Codf, RefP),
        constraint fk_frs_Codf foreign key (Codf) references Fournisseur (Codf),
        constraint fk_frs_RefP foreign key (RefP) references Produit (RefP)
    );

--2
alter table commande drop constraint fk_Codc;

alter table commande
add constraint fk_Codc foreign key (Codc) references client (Codc) on delete cascade NOT NULL;

--3
alter table Lig_cde drop constraint fk_nr_Numc;

alter table Lig_cde
add constraint fk_Numc foreign key (Numc) references commande (Numc) on delete cascade;

alter table Lig_cde drop constraint fk_nr_RefP;

alter table Lig_cde
add constraint fk_RefP foreign key (RefP) references produit (RefP) on delete cascade;

--4
alter table Frs_Prod drop constraint fk_frs_Codf;

alter table Frs_Prod
add constraint fk_Codf foreign key (Codf) references Fournisseur (Codf) on delete cascade;

alter table Frs_Prod drop constraint fk_frs_RefP;

alter table Frs_Prod
add constraint fk_RefPf foreign key (RefP) references produit (RefP) on delete cascade;

--5
alter table client
add (
    CA number(10, 3),
    Cred number(10, 3),
    CredMax (10, 3)
);

--6
alter table client
modify Ville varchar(10);

--7
alter table client
add constraint ck_Cred check (Cred <= CredMax);

--8
alter table Produit
add constraint ck_Qtes check (Qtes > 0);

alter table Produit
add constraint ck_Seuil check (Seuil > 0);

alter table Lig_cde
add constraint ck_Qtec check (Qtec > 0);

alter table Frs_Prod
add constraint ck_Qtef check (Qtef > 0);

--9-10-11
create index i_Nomc ON client (Nomc);

create index i_Libp ON produit (Lipb);

create index i_Nomf ON fournisseur (Nomf);

--12
insert into
    client (Codc, Nomc, Ville)
values
    (100, 'STS', 'Sousse');

insert into
    client (Codc, Nomc, Ville)
values
    (200, 'STIP', 'Sousse');

insert into
    client (Codc, Nomc, Ville)
values
    (300, 'AMS', 'Monastir');

insert into
    client (Codc, Nomc, Ville)
values
    (400, 'TOTAL', 'Sousse');

insert into
    client (Codc, Nomc, Ville)
values
    (500, 'METS', 'Bizerte');

insert into
    client (Codc, Nomc, Ville)
values
    (600, 'TOUTA', 'Bizerte');

insert into
    client (Codc, Nomc, Ville)
values
    (700, 'STB', 'Sousse');

insert into
    client (Codc, Nomc, Ville)
values
    (800, 'COMAR', 'Tunis');

insert into
    client (Codc, Nomc, Ville)
values
    (900, 'INFOPLUS', 'Tunis');

insert into
    client (Codc, Nomc, Ville)
values
    (1000, 'BIAT', 'Tunis');

insert into
    Commande (Numc, Datec, Codc)
values
    (10, TO_DATE('2010-01-02', 'YYYY-MM-DD'), 100);

insert into
    Commande (Numc, Datec, Codc)
values
    (20, TO_DATE('2010-01-02', 'YYYY-MM-DD'), 200);

insert into
    Commande (Numc, Datec, Codc)
values
    (30, TO_DATE('2010-01-04', 'YYYY-MM-DD'), 100);

insert into
    Commande (Numc, Datec, Codc)
values
    (40, TO_DATE('2010-01-15', 'YYYY-MM-DD'), 300);

insert into
    Commande (Numc, Datec, Codc)
values
    (50, TO_DATE('2010-01-15', 'YYYY-MM-DD'), 100);

insert into
    Commande (Numc, Datec, Codc)
values
    (60, TO_DATE('2010-01-23', 'YYYY-MM-DD'), 500);

insert into
    Commande (Numc, Datec, Codc)
values
    (70, TO_DATE('2010-02-01', 'YYYY-MM-DD'), 600);

insert into
    Commande (Numc, Datec, Codc)
values
    (80, TO_DATE('2010-02-05', 'YYYY-MM-DD'), 300);

insert into
    Commande (Numc, Datec, Codc)
values
    (90, TO_DATE('2010-02-10', 'YYYY-MM-DD'), 500);

--13

/*---------------------- Script d'insertion de donn�es ---------------*/
/*-------- Produit --- Fournisseur --- Lig_Cde --- Frs_Prod ----------*/
/**********************************************************************/
delete from lig_cde;
delete from frs_prod;
delete from fournisseur;
delete from produit;

/*--------------------------------------------------------------------*/
/* Insertion des tuples au niveau de la table Produit */
/*--------------------------------------------------------------------*/
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('MI11','Clavier',25,200);
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('MI22','Ecran 15''',250.700,100);
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('MI33','Carte Son',120,150);
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('MI44','Ordinateur IBM',1950,30);
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('MI55','Imprimante HP 840',300,50);
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('CO11','Cartouche HP Deskjet',45,400);
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('CO22','Paquet Disquette 3M',5,940);
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('CO33','CD-Rom R HP',1.200,1450);
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('CO44','Ruban Epson',10.500,758);
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('BU11','Rame Listing 80L',7.500,450);
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('BU22','Feutre Tableau Blanc',4.500,1250);
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('BU33','Bo�te Archive',3.200,1600);
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('BU44','Transprents Laser',32,550);

/*--------------------------------------------------------------------*/
/* Insertion des tuples au niveau de la table Fournisseur */
/*--------------------------------------------------------------------*/
INSERT INTO Fournisseur (Codf,Nomf,Villef) VALUES (1,'HP','Tunis');
INSERT INTO Fournisseur (Codf,Nomf,Villef) VALUES (2,'Tunisie Electronique','Sousse');
INSERT INTO Fournisseur (Codf,Nomf,Villef) VALUES (3,'IBM','Tunis');
INSERT INTO Fournisseur (Codf,Nomf,Villef) VALUES (4,'Epson','Nabeul');
INSERT INTO Fournisseur (Codf,Nomf,Villef) VALUES (5,'NetCom','Tunis');
INSERT INTO Fournisseur (Codf,Nomf,Villef) VALUES (6,'S2i','Tunis');
INSERT INTO Fournisseur (Codf,Nomf,Villef) VALUES (7,'3Com','Nabeul');
INSERT INTO Fournisseur (Codf,Nomf,Villef) VALUES (8,'Ibureau','Sfax');


/*--------------------------------------------------------------------*/
/* Insertion des tuples au niveau de la table Lig_Cde */
/*--------------------------------------------------------------------*/
INSERT INTO Lig_Cde VALUES (10,'MI11',15);
INSERT INTO Lig_Cde VALUES (10,'MI22',5);
INSERT INTO Lig_Cde VALUES (10,'MI55',4);
INSERT INTO Lig_Cde VALUES (20,'CO11',25);
INSERT INTO Lig_Cde VALUES (30,'MI44',2);
INSERT INTO Lig_Cde VALUES (30,'MI55',2);
INSERT INTO Lig_Cde VALUES (40,'MI44',6);
INSERT INTO Lig_Cde VALUES (40,'MI55',3);
INSERT INTO Lig_Cde VALUES (40,'CO11',30);
INSERT INTO Lig_Cde VALUES (40,'CO33',100);
INSERT INTO Lig_Cde VALUES (40,'CO22',50);
INSERT INTO Lig_Cde VALUES (50,'BU11',30);
INSERT INTO Lig_Cde VALUES (60,'BU11',20);
INSERT INTO Lig_Cde VALUES (60,'BU44',50);
INSERT INTO Lig_Cde VALUES (60,'CO44',24);
INSERT INTO Lig_Cde VALUES (70,'MI22',4);
INSERT INTO Lig_Cde VALUES (70,'MI11',12);
INSERT INTO Lig_Cde VALUES (70,'MI55',2);
INSERT INTO Lig_Cde VALUES (70,'CO11',10);
INSERT INTO Lig_Cde VALUES (70,'CO33',80);
INSERT INTO Lig_Cde VALUES (70,'CO22',25);
INSERT INTO Lig_Cde VALUES (70,'BU44',10);
INSERT INTO Lig_Cde VALUES (80,'BU11',13);
INSERT INTO Lig_Cde VALUES (80,'BU44',15);


/*--------------------------------------------------------------------*/
/* Insertion des tuples au niveau de la table Frs_Prod */
/*-------------------------------------------------------------------*/
INSERT INTO Frs_Prod VALUES (1,'MI11',20,50);
INSERT INTO Frs_Prod VALUES (6,'MI22',230.700,30);
INSERT INTO Frs_Prod VALUES (1,'MI33',110,50);
INSERT INTO Frs_Prod VALUES (3,'MI11',22,10);
INSERT INTO Frs_Prod VALUES (3,'MI44',1650,5);
INSERT INTO Frs_Prod VALUES (1,'MI55',160,20);
INSERT INTO Frs_Prod VALUES (1,'CO11',35,100);
INSERT INTO Frs_Prod VALUES (8,'CO22',3,500);
INSERT INTO Frs_Prod VALUES (8,'CO33',0.400,50);
INSERT INTO Frs_Prod VALUES (8,'BU11',5.500,250);
INSERT INTO Frs_Prod VALUES (7,'BU22',3.500,650);
INSERT INTO Frs_Prod VALUES (8,'BU33',2.100,550);
INSERT INTO Frs_Prod VALUES (6,'BU44',29,200);
INSERT INTO Frs_Prod VALUES (2,'MI44',1710,15);


/*-------------------------------------------------------------------*/

commit;



--14

update client
set CA=0,Cred=0,CredMax=1000;

--15

update commande set Mntc=0;

--16

update produit set seuil=Qtes/10;

--17

create view v_clientSousse as select * from client where upper(CVille)='SOUSSE';

--18

insert into v_clientSousse values(1111,'Randa','Tunis',0,0,1000);

--19

insert into v_clientSousse values(2222,'Epi d''or','Sousse',0,0,1000);


--20

create view v_frsReel as select distinct a.Codf,Nomf from fournisseur a,Frs_Prod b where a.Codf=b.Codf;

commit;

--21

SELECT * FROM produit;

--22

SELECT * FROM produit WHERE PU <= 100;

--23

SELECT Numc, Codc FROM Commande WHERE Datec > TO_DATE('2010-01-31', 'YYYY-MM-DD');

--24

SELECT RefP, Libp, Qtes FROM Produit WHERE Qtes < seuil;

--25

SELECT * FROM Client WHERE Ville <> 'Tunis' AND Cred > CredMax;

--26

SELECT * FROM Produit WHERE PU > 250 ORDER BY PU ASC;

--27

SELECT COUNT(DISTINCT Codc) FROM Commande WHERE EXTRACT(MONTH FROM Datec) = 1 AND EXTRACT(YEAR FROM Datec) = 2010;

--28

SELECT SUM(Qtec) AS TotP FROM Lig_cde WHERE RefP = 'BU44';

--29

SELECT * FROM client WHERE CA > (SELECT AVG(CA) FROM client);

--30

SELECT * FROM produit WHERE PU = (SELECT MAX(PU) FROM produit);

--31

SELECT p.RefP, p.Libp, p.PU 
FROM Produit p 
INNER JOIN Lig_cde lc ON p.RefP = lc.RefP 
WHERE lc.Numc = 70 
ORDER BY p.Libp ASC;

--32

SELECT Codc, Nomc, Ville, CA 
FROM client 
WHERE Codc IN (SELECT DISTINCT Codc FROM commande) 
ORDER BY CA DESC;

--33

SELECT * FROM produit WHERE PU > (SELECT PU FROM produit WHERE RefP = 'MI33');

--34

SELECT Codf, SUM(Qted) AS TotQute 
FROM Frs_Prod 
GROUP BY Codf;

--35

SELECT p.RefP, p.Libp, p.PU, lc.Qtec, c.Numc, c.Datec, c.Codc, cl.Nomc 
FROM Lig_cde lc 
JOIN commande c ON lc.Numc = c.Numc 
JOIN client cl ON c.Codc = cl.Codc 
JOIN produit p ON lc.RefP = p.RefP 
WHERE cl.Ville = 'Sousse';

--36

SELECT Codc, COUNT(Numc) AS NombreCommandes 
FROM Commande 
GROUP BY Codc;

--37

SELECT Numc, COUNT(RefP) AS NbProduits 
FROM Lig_cde 
GROUP BY Numc;

--38

SELECT * FROM produit WHERE RefP NOT IN (SELECT DISTINCT RefP FROM Lig_cde);

--39

SELECT DISTINCT f.Codf, f.Nomf 
FROM fournisseur f 
JOIN Frs_Prod fp ON f.Codf = fp.Codf 
JOIN Lig_cde lc ON fp.RefP = lc.RefP 
JOIN commande c ON lc.Numc = c.Numc 
JOIN client cl ON c.Codc = cl.Codc 
WHERE cl.Ville = 'Tunis';

--40

SELECT RefP, COUNT(Codf) AS NbFournisseurs
FROM Frs_Prod 
GROUP BY RefP;

--41

SELECT * 
FROM client 
WHERE Codc IN (SELECT Codc FROM commande WHERE Numc IN (SELECT Numc FROM Lig_cde WHERE RefP IN (SELECT RefP FROM Lig_cde WHERE Numc IN (SELECT Numc FROM commande WHERE Codc = 100))));

--42

SELECT Numc, Datec, COUNT(RefP) AS Nbrp 
FROM Lig_cde 
GROUP BY Numc, Datec 
ORDER BY Nbrp DESC;

--43

SELECT Numc, Datec, SUM(PU * Qtec) AS Totalc 
FROM produit 
JOIN Lig_cde ON produit.RefP = Lig_cde.RefP 
GROUP BY Numc, Datec 
ORDER BY Totalc DESC;

--44

SELECT Codc, Nomc, COUNT(Numc) AS Nbc, SUM(Mntc) AS Totc 
FROM commande 
GROUP BY Codc, Nomc 
HAVING COUNT(Numc) >= 3;

--45

SELECT Codc, Nomc, Ville 
FROM client 
WHERE NOT EXISTS (SELECT * FROM produit WHERE NOT EXISTS (SELECT * FROM Lig_cde WHERE Client.Codc = Lig_cde.Numc AND produit.RefP = Lig_cde.RefP));

--46

SELECT RefP, Libp 
FROM produit 
WHERE NOT EXISTS (SELECT * FROM client WHERE NOT EXISTS (SELECT * FROM Lig_cde WHERE client.Codc = Lig_cde.Numc AND produit.RefP = Lig_cde.RefP));

--47

SELECT DISTINCT f.Codf, f.Nomf 
FROM fournisseur f 
JOIN Frs_Prod fp ON f.Codf = fp.Codf 
WHERE fp.RefP NOT IN (SELECT RefP FROM Lig_cde WHERE Numc IN (SELECT Numc FROM commande WHERE Codc IN (SELECT Codc FROM client WHERE Ville = 'Sousse')));

--48

SELECT RefP, COUNT(Codf) AS NbFournisseurs 
FROM Frs_Prod 
GROUP BY RefP 
HAVING COUNT(Codf) > 1;

--49

SELECT RefP, AVG(PUf) AS MoyPFournisseur 
FROM Frs_Prod 
GROUP BY RefP;


