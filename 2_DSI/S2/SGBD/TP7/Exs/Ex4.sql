CREATE OR REPLACE PROCEDURE Affiche
IS
BEGIN
    FOR prod IN (SELECT Refp, Libp, PU FROM Produit) LOOP
        DBMS_OUTPUT.PUT_LINE('Reference : ' || prod.Refp || ', Libelle : ' || prod.Libp || ', Prix : ' || prod.PU);
    END LOOP;
END Affiche;
/


--EXEC Affiche;
