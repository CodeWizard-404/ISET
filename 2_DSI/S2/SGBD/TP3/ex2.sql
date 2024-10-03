DECLARE
    v_refp VARCHAR2(6) := '&refp';
    v_avg_price NUMBER;
BEGIN
    SELECT AVG(puf)
    INTO v_avg_price
    FROM frs_prod
    WHERE refp = v_refp;
    
    IF v_avg_price IS NULL THEN
        v_avg_price := 0;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(' prix moyen dachat de ce produit ' || v_refp || ': ' || TO_CHAR(v_avg_price));
END;
/
