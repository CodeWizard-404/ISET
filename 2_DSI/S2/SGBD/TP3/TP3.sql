SET SERVEROUTPUT ON;


--1
DECLARE
    v_refp    Produit.refp%TYPE;
    v_prix    Produit.pu%TYPE;
    v_qte     Produit.qtes%TYPE;
BEGIN
    v_refp := '&refp';


    SELECT PU, Qtes 
    INTO v_prix, v_qte
    FROM Produit
    WHERE Refp = v_refp;


    DBMS_OUTPUT.PUT_LINE('prix' || v_prix); 
    DBMS_OUTPUT.PUT_LINE('quantite'||v_qte);


    IF v_qte = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Produit en rupture de stock');
    ELSIF v_qte < 5 THEN
        v_prix := v_prix * 1.15; 
        DBMS_OUTPUT.PUT_LINE('Produit nécessite un approvisionnement. Nouveau prix : ' || v_prix);
    ELSIF v_qte > 50 THEN
        v_prix := v_prix * 0.8; 
        DBMS_OUTPUT.PUT_LINE('Produit en promotion. Nouveau prix : ' || v_prix);
    END IF;
END;
/


--2



--3

DECLARE
    v_numc    Commande.numc%TYPE := &numc;
    v_datec   Commande.datec%TYPE;
    v_mntc    Commande.mntc%TYPE := 0; 
BEGIN
    SELECT datec, mntc 
    INTO v_datec, v_mntc
    FROM commande
    WHERE numc = v_numc;


    DBMS_OUTPUT.PUT_LINE('DATE : ' || v_datec);
    DBMS_OUTPUT.PUT_LINE('MONTANT TOTAL : ' || v_mntc);


END;
/


--4

DECLARE
    CURSOR clients_cursor IS
        SELECT codc, nomc, ville
        FROM client;
BEGIN
    FOR client_rec IN clients_cursor LOOP
        client_rec.nomc := INITCAP(client_rec.nomc);
        client_rec.ville := UPPER(client_rec.ville);

        UPDATE client
        SET nomc = client_rec.nomc, ville = client_rec.ville
        WHERE codc = client_rec.codc;
    END LOOP;
    COMMIT;
END;
/

--5
DECLARE
    v_codc     Cat_Cli.codc%TYPE := &codec;
    v_ca       Cat_Cli.ca%TYPE;
    v_cred     Cat_Cli.cred%TYPE;
    v_credmax  Cat_Cli.credmax%TYPE;
    v_categorie VARCHAR2(20);
    v_etat_cred VARCHAR2(20);
BEGIN
    SELECT ca, cred, credmax INTO v_ca, v_cred, v_credmax
    FROM client
    WHERE codc = v_codc;

    IF v_ca > 10000 THEN
        v_categorie := 'Client fidèle';
    ELSIF v_ca BETWEEN 5000 AND 10000 THEN
        v_categorie := 'Bon Client';
    ELSE
        v_categorie := 'Client passager';
    END IF;

    IF v_cred > v_credmax THEN
        v_etat_cred := 'Client douteux';
    ELSIF v_cred BETWEEN v_credmax * 0.5 AND v_credmax THEN
        v_etat_cred := 'Client doit régler';
    ELSE
        v_etat_cred := 'Client solvable';
    END IF;

    INSERT INTO Cat_Cli (Codc, Nomc, CA, Cred, CredMax, Categorie, Etat_Cred)
    VALUES (v_codc, (SELECT nomc FROM client WHERE codc = v_codc), v_ca, v_cred, v_credmax, v_categorie, v_etat_cred);

    COMMIT;
END;
/



--6


--7

DECLARE
    v_codc client.codc%TYPE;
    v_ca client.ca%TYPE;
    v_credmax client.credmax%TYPE;
BEGIN

    FOR client_rec IN (SELECT codc FROM client) LOOP
        v_ca := 0;

        FOR ca_rec IN (SELECT mntc FROM commande WHERE codc = client_rec.codc) LOOP
            v_ca := v_ca + ca_rec.mntc;
        END LOOP;

        UPDATE client
        SET ca = v_ca
        WHERE codc = client_rec.codc;

        v_credmax := v_ca * 0.10;

        UPDATE client
        SET credmax = v_credmax
        WHERE codc = client_rec.codc;
    END LOOP;

    COMMIT;

END;
/

