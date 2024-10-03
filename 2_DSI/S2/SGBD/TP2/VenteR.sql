-- ============================================================
--   Script pour le remplissage de la base
--   Nom de la base   :  VenteR                           
--   Nom de SGBD      :  ORACLE Version 10g
-- ============================================================

delete from PC;
delete from Facture;
delete from Commande;
delete from produit;
delete from Client;

Insert into Produit values (2,'Ecran',400,15,5);
Insert into Produit values (5,'Clavier',25,40,10);
Insert into Produit values (3,'CD-ROM',150,20,3);
Insert into Produit values (9,'Souris',5,100,20);
Insert into Produit values (10,'Imprimante',500,50,8);

Insert into Client (CodC,NomC,CreditC,AdresseC) values (1250,'Mohamed',50,'Tunis');
Insert into Client (CodC,NomC,CreditC,AdresseC) values (1360,'Ali',400,'Sousse');
Insert into Client (CodC,NomC,CreditC,AdresseC) values (1580,'Adel',250,'Adel');
Insert into Client (CodC,NomC,CreditC,AdresseC) values (1210,'Fatma',20,'Sfax');
Insert into Client (CodC,NomC,CreditC,AdresseC) values (1000,'Slim',120,'Kef');
Insert into Client (CodC,NomC,CreditC,AdresseC) values (1200,'Sami',50,'Monastir');
Insert into Client (CodC,NomC,CreditC,AdresseC) values (1400,'Mahmoud',200,'Zagouan');

Insert into Commande values (10,1250,0,to_date('14-07-1999','dd-mm-yyyy'));
Insert into Commande values (220,1210,0,to_date('10-11-2000','dd-mm-yyyy'));
Insert into Commande values (40,1200,0,to_date('15-08-2001','dd-mm-yyyy'));
Insert into Commande values (100,1400,NULL,to_date('20-10-2003','dd-mm-yyyy'));
Insert into Commande values (300,1250,NULL,to_date('20-11-2001','dd-mm-yyyy'));
Insert into Commande values (50,1400,NULL,to_date('12-09-2002','dd-mm-yyyy'));

Insert into Facture values (10,1250,NULL,to_date('16-07-1999','dd-mm-yyyy'));
Insert into Facture values (220,1210,NULL,to_date('12-11-2000','dd-mm-yyyy'));
Insert into Facture values (40,1200,NULL,to_date('17-08-2001','dd-mm-yyyy'));
Insert into Facture values (100,1400,NULL,to_date('22-10-2003','dd-mm-yyyy'));
Insert into Facture values (300,1250,NULL,to_date('22-11-2001','dd-mm-yyyy'));
Insert into Facture values (50,1400,NULL,to_date('14-09-2002','dd-mm-yyyy'));

Insert into PC values (2,10,200);
Insert into PC values (5,10,100);
Insert into PC values (9,10,300);
Insert into PC values (2,220,100);
Insert into PC values (9,40,500);
Insert into PC values (10,40,100);
Insert into PC values (3,40,300);
Insert into PC values (10,100,100);
Insert into PC values (5,300,70);
Insert into PC values (10,300,100);
Insert into PC values (3,50,40);






