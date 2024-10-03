
CREATE OR REPLACE PROCEDURE Affiche_Com(
    NumCde IN Commande.Numc%TYPE
)
IS
    DateCmd Commande.Datec%TYPE;
    CodCli Commande.Codc%TYPE;
    LibCli Client.Nomc%TYPE;
    Refp Lig_Cde.RefP%TYPE;
    QteCmd Lig_Cde.Qtec%TYPE;
    PU Produit.PU%TYPE;
    Total NUMBER;
BEGIN
    SELECT Datec, Codc INTO DateCmd, CodCli
    FROM Commande
    WHERE Numc = NumCde;

    SELECT Nomc INTO LibCli
    FROM Client
    WHERE Codc = CodCli;

    DBMS_OUTPUT.PUT_LINE('|********************************************************************|');
    DBMS_OUTPUT.PUT_LINE('|*   Commande n : ' || NumCde || '  * Date : ' || TO_CHAR(DateCmd, 'DD/MM/YYYY') || ' * Client : ' || CodCli || '   ****|');
    DBMS_OUTPUT.PUT_LINE('|********************************************************************|');
    DBMS_OUTPUT.PUT_LINE('******|**  Reference  **|** Qte Cdeee **|**   PU   **|** Total   **|');

    FOR cmd IN (SELECT Refp, Qtec
                FROM Lig_Cde
                WHERE Numc = NumCde) LOOP
        SELECT PU INTO PU
        FROM Produit
        WHERE Refp = cmd.Refp;

        Total := cmd.Qtec * PU;

        DBMS_OUTPUT.PUT_LINE('******|**' || cmd.Refp || '  **|** ' || cmd.Qtec || '   **|*' || PU || ' **|*' || Total || '   *|');
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('|********************************************************************|');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Aucune commande trouvee pour le numero ' || NumCde);
END Affiche_Com;
/


DECLARE
    v_NumCde Commande.Numc%TYPE;
BEGIN
    FOR cmd IN (SELECT Numc FROM Commande) LOOP
        Affiche_Com(cmd.Numc);
    END LOOP;
END;
/
