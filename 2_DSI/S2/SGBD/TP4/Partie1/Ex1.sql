SET SERVEROUTPUT ON
DECLARE
    refprod produit.refp%TYPE;
    qte produit.qtes%TYPE;
    prix produit.pu%TYPE;
BEGIN
    refprod := '&refprod';
    
 
        SELECT qtes, pu INTO qte, prix FROM produit WHERE refp = refprod;
        
        DBMS_OUTPUT.PUT_LINE('Le prix est ' || prix);
        DBMS_OUTPUT.PUT_LINE('La quantite est ' || qte);
        
        IF qte = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Produit en rupture de stock');
        ELSIF qte <= 5 THEN
            DBMS_OUTPUT.PUT_LINE('Produit nécessite un approvisionnement');
            UPDATE produit SET pu = pu * 1.15 WHERE refp = refprod;
        ELSIF qte > 50 THEN
            DBMS_OUTPUT.PUT_LINE('Produit en promotion');
            UPDATE produit SET pu = pu * 0.8 WHERE refp = refprod;
        END IF;
        
        COMMIT;
        
    EXCEPTION
        WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE('Plusier Produit Trouver !');
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('produit introuvable !');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Erreur: ' || SQLERRM);

END;
/
