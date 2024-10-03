DECLARE
    refprod frs_prod.refp%TYPE;
    prix frs_prod.puf%TYPE;
    Ref_Inexistante exception;
BEGIN
    refprod := '&refprod';
    

        SELECT AVG(puf) INTO prix FROM frs_prod WHERE refp = refprod;
        
        IF prix IS NOT NULL THEN
            DBMS_OUTPUT.PUT_LINE('Le prix moyen d''achat du produit : ' || refprod ||' est ' || prix);
        ELSE
            RAISE Ref_Inexistante;
        END IF;
        
    EXCEPTION
        WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE('Plusier Produit Trouver !');        
        WHEN Ref_Inexistante THEN 
            DBMS_OUTPUT.PUT_LINE('Reference inexistante !'); 
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Erreur: ' || SQLERRM);

END;
/
