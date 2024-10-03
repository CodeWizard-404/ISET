DECLARE
    v_refp produit.refp%TYPE;
    v_codf frs_prod.codf%TYPE;
    v_nomf fournisseur.nomf%TYPE;
    v_villef fournisseur.villef%TYPE;
BEGIN
    v_refp := '&v_refp';

        SELECT codf
        INTO v_codf
        FROM frs_prod
        WHERE refp = v_refp;

        SELECT nomf,Villef
        INTO v_nomf,v_villef
        FROM fournisseur
        WHERE codf = v_codf;

        DBMS_OUTPUT.PUT_LINE('Code du fournisseur : ' || v_codf);
        DBMS_OUTPUT.PUT_LINE('Nom du fournisseur : ' || v_nomf);
        DBMS_OUTPUT.PUT_LINE('Ville du fournisseur : ' || v_villef);

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Produit introuvable');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Erreur : ' || SQLERRM);
END;
/
