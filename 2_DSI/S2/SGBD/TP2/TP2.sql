--1

select * from Client where length(NomC)>5;

--2 

select SUBSTR(NomC, 1, 3) as TPC
from Client;

--3

select *
from Produit
where SUBSTR(Lib, 4, 1) = 'a'
or SUBSTR(Lib, 3, 1) = 'a'
or SUBSTR(Lib, 7, 1) = 'a';


--4



--5

SELECT REPLACE(AdresseC, ' ', '') AS AD
FROM Client;


--6

SELECT CONCAT(UPPER(SUBSTR(AdresseC, 1, 1)), LOWER(SUBSTR(AdresseC, 2))) AS AD
FROM Client;

--7

SELECT *
FROM Client
WHERE UPPER(AdresseC) LIKE '%UNIS%';

--8

SELECT SUBSTR(Lib, 2, 1) AS L, ASCII(SUBSTR(Lib, 2, 1)) AS c_ASCII
FROM Produit;


--Partie |||

SELECT MOD (5,2)* TRUNC(4.258,2) + TRUNC(3.258,0)
FROM DUAL;

SELECT ABS(FLOOR(10.256)*(ROUND(-4.258,2)-SQRT(4)))
FROM DUAL;

--Partie |V

--1

SELECT NVL(AdresseC, 'Client Sans Adresse..!') AS adresse_client
FROM Client;


--2

SELECT *
FROM Client
WHERE LENGTH(NomC) = LENGTH(AdresseC);


--Partie V

--1

SELECT NEXT_DAY(TRUNC(SYSDATE) + 7, 'TUESDAY') AS mardi_prochain FROM DUAL;

--2

SELECT SYSDATE + 7 AS date_apres_une_semaine FROM DUAL;

--3

SELECT LAST_DAY(SYSDATE) AS dernier_jour_du_mois_en_cours FROM DUAL;

--4

SELECT ADD_MONTHS(SYSDATE, 4) AS rendez_vous_dans_4_mois FROM DUAL;

--5

SELECT TO_CHAR(ADD_MONTHS(SYSDATE, -65), 'MM') AS numero_du_mois FROM DUAL;

--6

SELECT EXTRACT(YEAR FROM SYSDATE) AS annee_en_cours FROM DUAL;


--Partie V|

--1

SELECT TO_CHAR(SYSDATE, 'DD Month YYYY') AS DA
FROM DUAL;

--2

SELECT TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI:SS') AS date_heure_complete FROM DUAL;

--3

SELECT (SYSDATE - DATE '2002-08-28') AS age_en_nombre_de_jours FROM DUAL;

--4

SELECT MONTHS_BETWEEN(SYSDATE, DATE '2002-08-28') AS age_en_nombre_de_mois FROM DUAL;

--5

SELECT TO_CHAR(DATE '2002-08-28', 'DAY') AS jour_de_naissance FROM DUAL;

--6

SELECT * FROM Commande WHERE DATC BETWEEN TO_DATE('2000-01-01', 'YYYY-MM-DD') AND TO_DATE('2010-12-31', 'YYYY-MM-DD');

--7

SELECT NVL(TO_CHAR(MontF), 'Montant vide') AS montant_affiche
FROM Facture;