DECLARE
    v_ville credi_cli.ville%TYPE ; 
    v_codc credi_cli.codc%TYPE;
    v_cred credi_cli.cred%TYPE;
    v_CA NUMBER;
    v_credmax credi_cli.cred%TYPE;
    v_PourcentCredCA credi_cli.pourcentcredca%TYPE;
    v_PourcentCredCredMax credi_cli.pourcentcredcredmax%TYPE;

    CURSOR c_clients (v_ville VARCHAR2) IS
        SELECT c.codc, c.ville, c.cred, cl.ca, c.credmax
        FROM client c
        JOIN commande cm ON c.codc = cm.codc
        JOIN client cl ON c.codc = cl.codc
        WHERE c.ville = v_ville AND c.cred > 0
        GROUP BY c.codc, c.ville, c.cred, cl.ca, c.credmax;
BEGIN

    v_ville := '&ville';
    FOR rec IN c_clients(v_ville) LOOP
        v_codc := rec.codc;
        v_cred := rec.cred;
        v_CA := rec.ca;
        v_credmax := rec.credmax;
        
        v_PourcentCredCA := TO_CHAR((v_cred / v_CA) * 100) || '% sur ' || TO_CHAR(v_CA);
        v_PourcentCredCredMax := TO_CHAR((v_cred / v_credmax) * 100) || '% sur ' || TO_CHAR(v_credmax);
        
        INSERT INTO credi_cli (codc, ville, cred, pourcentcredca, pourcentcredcredmax)
        VALUES (v_codc, v_ville, v_cred, v_PourcentCredCA, v_PourcentCredCredMax);
    END LOOP;
    COMMIT;
END;
/
