DECLARE
    cl client%ROWTYPE;
    code client.codc%TYPE;
BEGIN
    code := '&code';
    
        SELECT * INTO cl FROM client WHERE codc = code;

        DELETE FROM Cat_Cli WHERE codc = code;
        INSERT INTO Cat_Cli (codc, nomc, ca, cred, credmax) VALUES (cl.codc, cl.nomc, cl.ca, cl.cred, cl.credmax);

        IF cl.ca > 10000 THEN
            UPDATE Cat_Cli SET Categorie = 'Client fidèle' WHERE codc = code;
        ELSIF cl.ca >= 5000 THEN
            UPDATE Cat_Cli SET Categorie = 'Bon Client' WHERE codc = code;
        ELSE
            UPDATE Cat_Cli SET Categorie = 'Client passager' WHERE codc = code;
        END IF;

        IF cl.cred > cl.credMax THEN
            UPDATE Cat_Cli SET Etat_Cred = 'Client douteux' WHERE codc = code;
        ELSIF cl.cred >= cl.credMax / 2 THEN
            UPDATE Cat_Cli SET Etat_Cred = 'Client doit régler' WHERE codc = code;
        ELSE
            UPDATE Cat_Cli SET Etat_Cred = 'Client solvable' WHERE codc = code;
        END IF;

        COMMIT;
        
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('client introuvable !');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Erreur : ' || SQLERRM);

END;
/
