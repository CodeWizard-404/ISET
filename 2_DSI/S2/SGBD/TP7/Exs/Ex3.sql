--1
CREATE OR REPLACE PROCEDURE Moins_Cher(
    RefProd IN Produit.Refp%TYPE,
    Prix OUT Frs_Prod.Puf%TYPE,
    CodFour OUT Frs_Prod.Codf%TYPE
)
AS
BEGIN
    SELECT puf, codf
    INTO Prix, CodFour
    FROM Frs_Prod
    WHERE (Refp, puf) IN (
        SELECT Refp, MIN(puf)
        FROM Frs_Prod
        WHERE Refp = RefProd
        GROUP BY Refp
    );

END Moins_Cher;
/

--3

DECLARE
    v_RefProd Produit.Refp%TYPE;
    v_Prix Frs_Prod.Puf%TYPE;
    v_CodFour Frs_Prod.Codf%TYPE;
BEGIN
    v_RefProd := '&RefProd'; 
    
    Moins_Cher(v_RefProd, v_Prix, v_CodFour);
    
    IF v_Prix IS NOT NULL THEN
        DBMS_OUTPUT.PUT_LINE('Produit ' || v_RefProd || ', le prix d achat le moins cher est : ' || v_Prix );
        DBMS_OUTPUT.PUT_LINE('Fournisseur correspondant (Codf) : ' || v_CodFour);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Aucun prix d achat trouve pour le produit ' || v_RefProd);
    END IF;
END;
/
