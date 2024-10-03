DECLARE
    v_codc commande.codc%TYPE;
    v_nomc client.nomc%TYPE;
    v_numc commande.numc%TYPE;
    v_datec commande.datec%TYPE;
    v_mntc commande.mntc%TYPE;
    v_pourcent_red VARCHAR2(5);
    v_mntc_reduit NUMBER;

    CURSOR c_red_tunis_2010 IS
        SELECT c.codc, cl.nomc, c.numc, c.datec, c.mntc
        FROM commande c
        INNER JOIN client cl ON c.codc = cl.codc
        WHERE cl.ville = 'Tunis' AND EXTRACT(YEAR FROM c.datec) = 2010;

    v_cred client.cred%TYPE;
BEGIN
    FOR rec IN c_red_tunis_2010 LOOP
        v_codc := rec.codc;
        v_nomc := rec.nomc;
        v_numc := rec.numc;
        v_datec := rec.datec;
        v_mntc := rec.mntc;

        SELECT cred
        INTO v_cred
        FROM client
        WHERE codc = v_codc;

        IF v_cred >= 10000 THEN
            v_pourcent_red := '0%';
            v_mntc_reduit := v_mntc;
        ELSIF v_cred < 10000 AND v_cred >= 5000 THEN
            v_pourcent_red := '5%';
            v_mntc_reduit := v_mntc * 0.95;
        ELSIF v_cred < 5000 AND v_cred >= 1000 THEN
            v_pourcent_red := '10%';
            v_mntc_reduit := v_mntc * 0.90;
        ELSIF v_cred < 1000 THEN
            v_pourcent_red := '15%';
            v_mntc_reduit := v_mntc * 0.85;
        END IF;

        IF v_pourcent_red <> '0%' THEN
            INSERT INTO Red_Tunis_2010 (Codc, Nomc, Numc, Datec, Mntc, Pourc_Red, Mntc_reduit)
            VALUES (v_codc, v_nomc, v_numc, v_datec, v_mntc, v_pourcent_red, v_mntc_reduit);
        END IF;
    END LOOP;
    COMMIT;
END;
/
