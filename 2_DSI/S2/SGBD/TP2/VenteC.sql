-- ============================================================
--   Script pour la création de la base
--   Nom de la base   :  VenteC                           
--   Nom de SGBD      :  ORACLE version 10g
-- ============================================================
drop table PC cascade constraints;
drop table Facture cascade constraints;
drop table Commande cascade constraints;
drop table Produit cascade constraints;
drop table Client cascade constraints;

-- ============================================================
--   Table : Prodit
-- ============================================================
create table Produit
(
    CodP                          NUMBER(4)      not null,
    Lib                           VARCHAR2(20),
    PU                            NUMBER(8,3),
    QteS                          NUMBER(6),
    Seuil			  NUMBER(4),	 
    constraint cp_CodP primary key (CodP)
);

-- ============================================================
--   Table : Client
-- ============================================================
create table Client
(
    CodC                          NUMBER(4)      not null,
    NomC                          VARCHAR2(20),
    CreditC                       NUMBER(8,3),
    AdresseC                      VARCHAR2(15),
    constraint cp_CodC primary key (CodC)
);

-- ============================================================
--   Table : Commande
--   Avec une clé étrangère CodC 
-- ============================================================
create table Commande
(
    NumC                         NUMBER(4)     not null,
    CodC                         NUMBER(4)     not null,
    MontC				   NUMBER(7,3),		
    DATC                         DATE,
    constraint cp_NumC primary key (NumC),
	constraint cp_Commande_CodC foreign key (CodC) references Client (CodC)
);


-- ============================================================
--   Table : Facture            
--   Avec une clé étrangère CodC 
-- ============================================================
create table Facture
(
    NumF                 NUMBER(4)     not null,
    CodC                 NUMBER(4)      not null,
    MontF	  		 NUMBER(8,3),
    DATF                         DATE,
    constraint cp_NumF primary key (NumF),
	constraint cp_Facture_CodC foreign key (CodC) references Client (CodC)
);

-- ============================================================
--   Table : PC                      
-- ============================================================
create table PC
(
    CodP                      NUMBER(4)        not null,
    NumC                      NUMBER(4)        not null,
    QteC                      NUMBER(4),
    constraint cp_PC primary key (CodP, NumC),
	constraint ce_PC_CodP foreign key (CodP) references Produit (CodP),
	constraint ce_PC_NumC foreign key (NumC) references Commande (NumC)
);

-- ============================================================
--   Index :                                           
-- ============================================================
 Create index iClient on Client (NomC asc);
