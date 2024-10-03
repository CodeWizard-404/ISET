/*---------------------- Script d'insertion de données ---------------*/
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
INSERT INTO Produit (Refp,Libp,PU,Qtes) VALUES ('BU33','Boîte Archive',3.200,1600);
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