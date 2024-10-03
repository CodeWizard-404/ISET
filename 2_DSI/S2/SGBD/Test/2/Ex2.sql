DECLARE
    v_num_vol commande.numc%TYPE;
    v_date_vol commande.datec%TYPE;
    v_source client.ville%TYPE;
    v_destination client.ville%TYPE;
    v_nb_places_dispo NUMBER;
BEGIN
    BEGIN
        v_num_vol := '&v_vol';

        SELECT datec, client.ville AS source, (SELECT ville FROM client WHERE codc = commande.codc) AS destination
        INTO v_date_vol, v_source, v_destination
        FROM commande
        JOIN client ON commande.codc = client.codc
        WHERE numc = v_num_vol;

        SELECT COUNT(*)
        INTO v_nb_places_dispo
        FROM (
            SELECT l.numc, COUNT(*) AS nb_passagers
            FROM lig_cde l
            JOIN commande c ON l.numc = c.numc
            WHERE l.numc = v_num_vol
            GROUP BY l.numc, c.numc
        )
        WHERE nb_passagers < (SELECT COUNT(*) FROM lig_cde WHERE numc = v_num_vol);

        DBMS_OUTPUT.PUT_LINE('Date du vol : ' || TO_CHAR(v_date_vol, 'DD/MM/YYYY'));
        DBMS_OUTPUT.PUT_LINE('Source : ' || v_source);
        DBMS_OUTPUT.PUT_LINE('Destination : ' || v_destination);
        DBMS_OUTPUT.PUT_LINE('NB de places dispo : ' || v_nb_places_dispo);

        DBMS_OUTPUT.PUT_LINE('Liste des passagers :');
        FOR passager IN (SELECT l.numc, p.refp, p.libp
                        FROM lig_cde l
                        JOIN produit p ON l.refp = p.refp
                        WHERE l.numc = v_num_vol)
        LOOP
            DBMS_OUTPUT.PUT_LINE('Num commande : ' || passager.numc || ', Produit : ' || passager.libp);
        END LOOP;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Aucune donnee pour ce num de vol.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('ERROR : ' || SQLERRM);
    END;
END;
/
