--1
CREATE OR REPLACE PROCEDURE Prix_Qte(
    refProd IN VARCHAR2,
    Prix OUT NUMBER,
    Qte OUT NUMBER
)
AS
    v_seuil NUMBER := 5;
    v_promotion NUMBER := 50;
BEGIN
    SELECT PU, Qtes INTO Prix, Qte
    FROM Produit
    WHERE Refp = refProd;
    
    IF Qte = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Produit en rupture de stock');
    ELSIF Qte < v_seuil THEN
        DBMS_OUTPUT.PUT_LINE('Produit nécessite un approvisionnement');
    ELSIF Qte > v_promotion THEN
        DBMS_OUTPUT.PUT_LINE('Produit en promotion');
    END IF;
END Prix_Qte;
/

--2

DECLARE
    v_refProd VARCHAR2(6);
    v_Prix NUMBER;
    v_Qte NUMBER;
BEGIN
    v_refProd := '&refProd'; 
    
    Prix_Qte(v_refProd, v_Prix, v_Qte);
    
    DBMS_OUTPUT.PUT_LINE('Reference du produit : ' || v_refProd);
    DBMS_OUTPUT.PUT_LINE('Prix : ' || v_Prix );
    DBMS_OUTPUT.PUT_LINE('Quantite en stock : ' || v_Qte);
    
    IF v_Qte < 5 THEN
        v_Prix := v_Prix * 1.15;
        DBMS_OUTPUT.PUT_LINE('Majore de 15%');
    END IF;
    
    IF v_Qte > 50 THEN
        v_Prix := v_Prix * 0.8; 
        DBMS_OUTPUT.PUT_LINE('Diminue de 20%');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('Nouveau prix : ' || v_Prix ||);
END;
/
