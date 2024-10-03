CREATE OR REPLACE PROCEDURE Generer_Billets(spec IN spectacle.spectacleID%TYPE, pr IN billet.prix%TYPE) IS
    v_capacite salle.capacite%TYPE;
BEGIN
    SELECT capacite INTO v_capacite
    FROM salle
    WHERE salleID = (SELECT salleID FROM spectacle WHERE spectacleID = spec);

    FOR i IN 1..v_capacite LOOP
        INSERT INTO billet (billetID, numPlace, prix, spectacleID)
        VALUES ('SP' || spec || 'BL_' || TO_CHAR(i, 'FM000'), i, pr, spec);
    END LOOP;
    
    COMMIT;
END;
/