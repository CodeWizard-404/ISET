DECLARE
    v_refp    Produit.refp%TYPE;
    v_prix    Produit.pu%TYPE;
    v_qte     Produit.qtes%TYPE;
BEGIN
    v_refp := '&refp';


    SELECT PU, Qtes 
    INTO v_prix, v_qte
    FROM Produit
    WHERE Refp = v_refp;


    DBMS_OUTPUT.PUT_LINE('prix' || v_prix); 
    DBMS_OUTPUT.PUT_LINE('quantite'||v_qte);


    IF v_qte = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Produit en rupture de stock');
    ELSIF v_qte < 5 THEN
        v_prix := v_prix * 1.15; 
        DBMS_OUTPUT.PUT_LINE('Produit nécessite un approvisionnement. Nouveau prix : ' || v_prix);
    ELSIF v_qte > 50 THEN
        v_prix := v_prix * 0.8; 
        DBMS_OUTPUT.PUT_LINE('Produit en promotion. Nouveau prix : ' || v_prix);
    END IF;
END;
/