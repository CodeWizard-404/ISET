CREATE OR REPLACE FUNCTION Nbre_billets_vendus(spec IN spectacle.spectacleID%TYPE) RETURN NUMBER IS
    nb_billets NUMBER;
BEGIN
    SELECT COUNT(*) INTO nb_billets
    FROM vente v
    JOIN billet b ON v.billetID = b.billetID
    WHERE b.spectacleID = spec;
    
    RETURN nb_billets;
END;
/
