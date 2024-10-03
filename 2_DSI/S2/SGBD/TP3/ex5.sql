DECLARE
    v_codc     Cat_Cli.codc%TYPE := &codec;
    v_ca       Cat_Cli.ca%TYPE;
    v_cred     Cat_Cli.cred%TYPE;
    v_credmax  Cat_Cli.credmax%TYPE;
    v_categorie VARCHAR2(20);
    v_etat_cred VARCHAR2(20);
BEGIN
    SELECT ca, cred, credmax INTO v_ca, v_cred, v_credmax
    FROM client
    WHERE codc = v_codc;

    IF v_ca > 10000 THEN
        v_categorie := 'Client fidèle';
    ELSIF v_ca BETWEEN 5000 AND 10000 THEN
        v_categorie := 'Bon Client';
    ELSE
        v_categorie := 'Client passager';
    END IF;

    IF v_cred > v_credmax THEN
        v_etat_cred := 'Client douteux';
    ELSIF v_cred BETWEEN v_credmax * 0.5 AND v_credmax THEN
        v_etat_cred := 'Client doit régler';
    ELSE
        v_etat_cred := 'Client solvable';
    END IF;

    INSERT INTO Cat_Cli (Codc, Nomc, CA, Cred, CredMax, Categorie, Etat_Cred)
    VALUES (v_codc, (SELECT nomc FROM client WHERE codc = v_codc), v_ca, v_cred, v_credmax, v_categorie, v_etat_cred);

    COMMIT;
END;
/