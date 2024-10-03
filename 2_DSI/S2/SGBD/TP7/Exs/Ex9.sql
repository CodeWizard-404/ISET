CREATE OR REPLACE FUNCTION Remise_cde(
    Num_Cde IN Commande.NumC%TYPE
) RETURN NUMBER
IS
    Montant NUMBER;
    Remise NUMBER := 0;
BEGIN
    SELECT mntc INTO Montant
    FROM Commande
    WHERE numc = Num_Cde;

    IF Montant < 500 THEN
        Remise := 0;
    ELSIF Montant >= 500 AND Montant < 1500 THEN
        Remise := 0.05;
    ELSE
        Remise := 0.1;
    END IF;

    RETURN Remise;
END Remise_cde;
/


DECLARE
    v_NumCde Commande.NumC%TYPE;
    v_DateCde Commande.DateC%TYPE;
    v_CodCde Commande.CodC%TYPE;
    v_MntCde Commande.MntC%TYPE;
    v_Remise NUMBER;
    v_MntApresRemise NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Numc | Datec    | Codc | Mntc   | Remise | MntApresRemise');
    DBMS_OUTPUT.PUT_LINE('--------------------------------------------------------');

    FOR cde IN (SELECT NumC, DateC, CodC, MntC FROM Commande) LOOP
        v_NumCde := cde.NumC;
        v_DateCde := cde.DateC;
        v_CodCde := cde.CodC;
        v_MntCde := cde.MntC;
        v_Remise := Remise_cde(v_NumCde);
        v_MntApresRemise := v_MntCde * (1 - v_Remise);

        DBMS_OUTPUT.PUT_LINE(v_NumCde || ' | ' || v_DateCde || ' | ' || v_CodCde || ' | ' || v_MntCde || ' | ' || v_Remise || ' | ' || v_MntApresRemise);
    END LOOP;
END;
/
