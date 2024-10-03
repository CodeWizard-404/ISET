DECLARE
    v_libp produit.libp%TYPE;
    v_prix produit.pu%TYPE;
    v_total_quantites NUMBER;
    v_refp produit.refp%TYPE;
BEGIN
    v_libp := '&v_libp';

        SELECT refp 
        INTO v_refp
        FROM produit
        WHERE libp = v_libp ;
    
        SELECT pu 
        INTO v_prix
        FROM produit
        WHERE libp = v_libp;

        SELECT NVL(SUM(qtec), 0)
        INTO v_total_quantites
        FROM lig_cde
        WHERE refp = v_refp;

        DBMS_OUTPUT.PUT_LINE('Prix du produit ' || v_libp || ' : ' || v_prix);
        DBMS_OUTPUT.PUT_LINE('Total des quantites commandees : ' || v_total_quantites);
    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Produit introuvable.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Erreur : ' || SQLERRM);
END;
/
