--1
CREATE OR REPLACE FUNCTION CA_Frs(
    CodFour IN Fournisseur.Codf%TYPE
) RETURN NUMBER
AS
    totalCA NUMBER := 0;
BEGIN
    SELECT SUM(l.qtec * f.puf)
    INTO totalCA
    FROM Lig_Cde l
    JOIN Frs_Prod f ON l.refp = f.refp
    WHERE f.codf = CodFour;

    RETURN totalCA;

END CA_Frs;
/

--2
DECLARE
    v_CodFour Fournisseur.Codf%TYPE;
    v_CA NUMBER;
BEGIN
    v_CodFour := '&v_CodFour'; 
    
    v_CA := CA_Frs(v_CodFour);
    
    DBMS_OUTPUT.PUT_LINE('Le chiffre d affaires du fournisseur ' || v_CodFour || ' est : ' || v_CA);
END;
/
