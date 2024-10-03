DECLARE
    v_numc commande.numc%TYPE;
    v_total_mntc commande.mntc%TYPE;
BEGIN
    FOR c IN (SELECT numc FROM commande) LOOP
        v_total_mntc := 0; 
        
        FOR l IN (SELECT qtec, refp FROM lig_cde WHERE numc = c.numc) LOOP
            SELECT pu * l.qtec INTO v_total_mntc
            FROM produit
            WHERE refp = l.refp;
            
            v_total_mntc := v_total_mntc + v_total_mntc;
        END LOOP;
        
        UPDATE commande SET mntc = v_total_mntc WHERE numc = c.numc;
        
        DBMS_OUTPUT.PUT_LINE('Le montant de la commande ' || c.numc || ' mis a jour.');
    END LOOP;
    
    COMMIT;

END;
/
