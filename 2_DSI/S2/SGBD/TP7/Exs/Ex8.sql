
CREATE OR REPLACE FUNCTION CA_entre_Date(
    codclient IN Client.Codc%TYPE,
    debut IN DATE,
    fin IN DATE
) RETURN NUMBER
IS
    CA_client NUMBER := 0;
BEGIN
    SELECT SUM(mntc)
    INTO CA_client
    FROM Commande
    WHERE codc = codclient
    AND datec BETWEEN debut AND fin;

    RETURN NVL(CA_client, 0);
END CA_entre_Date;
/


CREATE OR REPLACE PROCEDURE Affiche_Cli(
    CodClient IN NUMBER,
    debut IN DATE,
    fin IN DATE
)
IS
    NomClient Client.Nomc%TYPE;
    VilleClient Client.Ville%TYPE;
    CA_client NUMBER;
BEGIN
    SELECT Nomc, Ville
    INTO NomClient, VilleClient
    FROM Client
    WHERE Codc = CodClient;

    CA_client := CA_entre_Date(CodClient, debut, fin);

    DBMS_OUTPUT.PUT_LINE('|************************************************************|');
    DBMS_OUTPUT.PUT_LINE('|* Client : ' || CodClient || '  * ' || NomClient || '  *  ' || VilleClient || '  *  CA : ' || CA_client || '  *********|');
    DBMS_OUTPUT.PUT_LINE('|************************************************************|');
    DBMS_OUTPUT.PUT_LINE('********|** Num Cde **|**   Date   **|**  Montant  **|*******|');

    FOR cmd IN (SELECT numc, datec, mntc
                FROM Commande
                WHERE codc = CodClient
                AND datec BETWEEN debut AND fin) LOOP
        DBMS_OUTPUT.PUT_LINE('********|**   ' || cmd.numc || '    **|** ' || TO_CHAR(cmd.datec, 'DD/MM/YY') || ' **|**   ' || cmd.mntc || '  **|*******|');
    END LOOP;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Aucune commande trouvée pour le client ' || CodClient || ' entre ' || debut || ' et ' || fin);
END Affiche_Cli;
/


DECLARE
    v_CodClient Client.Codc%TYPE;
    v_Debut DATE := TO_DATE('01/01/2024', 'DD/MM/YYYY'); 
    v_Fin DATE := TO_DATE('31/12/2024', 'DD/MM/YYYY'); 
BEGIN
    FOR client IN (SELECT Codc FROM Client) LOOP
        Affiche_Cli(client.Codc, v_Debut, v_Fin);
    END LOOP;
END;
/
