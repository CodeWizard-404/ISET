SET SERVEROUTPUT ON

DECLARE
    v_codc client.codc%TYPE;
    v_nomc client.nomc%TYPE;
    v_ville client.ville%TYPE;
    v_nb_commandes NUMBER;
    v_montant_total NUMBER;
BEGIN
    v_codc := &v_codc;
    
    BEGIN
        SELECT nomc, ville
        INTO v_nomc, v_ville
        FROM client
        WHERE codc = v_codc;

        SELECT COUNT(*), NVL(SUM(mntc), 0)
        INTO v_nb_commandes, v_montant_total
        FROM commande
        WHERE codc = v_codc;

        DBMS_OUTPUT.PUT_LINE('Nom du client : ' || v_nomc);
        DBMS_OUTPUT.PUT_LINE('Ville du client : ' || v_ville);
        DBMS_OUTPUT.PUT_LINE('Nombre de commandes : ' || v_nb_commandes);
        DBMS_OUTPUT.PUT_LINE('Montant total des commandes : ' || v_montant_total);
    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Client introuvable.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Erreur : ' || SQLERRM);
    END;
END;
/
