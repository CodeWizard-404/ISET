DECLARE
    v_codc client.codc%TYPE;
    v_ca client.ca%TYPE;
    v_credmax client.credmax%TYPE;
BEGIN

    FOR client_rec IN (SELECT codc FROM client) LOOP
        v_ca := 0;

        FOR ca_rec IN (SELECT mntc FROM commande WHERE codc = client_rec.codc) LOOP
            v_ca := v_ca + ca_rec.mntc;
        END LOOP;

        UPDATE client
        SET ca = v_ca
        WHERE codc = client_rec.codc;

        v_credmax := v_ca * 0.10;

        UPDATE client
        SET credmax = v_credmax
        WHERE codc = client_rec.codc;
    END LOOP;

    COMMIT;

END;
/
