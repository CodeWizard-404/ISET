DECLARE
    CURSOR c_fournisseur IS
        SELECT f.codf, f.nomf, COUNT(fp.refp) AS nbProd, SUM(fp.puf * fp.qtef) AS CA
        FROM fournisseur f
        JOIN frs_prod fp ON f.codf = fp.codf
        GROUP BY f.codf, f.nomf;

    v_nbProd cat_four.nbprod%TYPE;
    v_CA cat_four.CA%TYPE;
    v_Categorie cat_four.categorie%TYPE;
BEGIN
    FOR rec IN c_fournisseur LOOP
        v_nbProd := rec.nbProd;
        v_CA := rec.CA;
        
        IF v_CA < 1000 THEN
            v_Categorie := 'Fournisseur passager';
        ELSIF v_CA < 10000 THEN
            v_Categorie := 'Fournisseur Moyen';
        ELSE
            v_Categorie := 'Fournisseur important';
        END IF;

        INSERT INTO cat_four (codf, nomf, nbProd, CA, categorie)
        VALUES (rec.codf, rec.nomf, v_nbProd, v_CA, v_Categorie);
    END LOOP;
    COMMIT;
END;
/

