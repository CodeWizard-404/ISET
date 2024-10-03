DECLARE
    CURSOR reap_cursor IS
        SELECT p.refp, p.libp, 
            SUM(l.qtec) AS Q_tot_com, 
            p.qtes, p.seuil, p.pu
        FROM lig_cde l
        JOIN produit p ON l.refp = p.refp
        GROUP BY p.refp, p.libp, p.qtes, p.seuil, p.pu;
    v_refp Reapp.refp%TYPE;
    v_libp Reapp.libp%TYPE;
    v_Q_reap Reapp.Q_reap%TYPE;
    v_Mnt_reap Reapp.Mnt_reap%TYPE;
    v_New_Stock Reapp.New_Stock%TYPE;
    v_Q_tot_com NUMBER;
    v_Qtes NUMBER;
    v_Seuil NUMBER;
    v_PU NUMBER;
BEGIN
    FOR reap_rec IN reap_cursor LOOP
        v_refp := reap_rec.refp;
        v_libp := reap_rec.libp;
        v_Q_tot_com := reap_rec.Q_tot_com;
        v_Qtes := reap_rec.qtes;
        v_Seuil := reap_rec.seuil;
        v_PU := reap_rec.pu;
        
        IF v_Q_tot_com > (4 * (v_Qtes - v_Seuil)) THEN
            v_Q_reap := (v_Q_tot_com - v_Qtes) * 1.4;
        ELSIF v_Q_tot_com > (3 * (v_Qtes - v_Seuil)) THEN
            v_Q_reap := (v_Q_tot_com - v_Qtes) * 1.3;
        ELSIF v_Q_tot_com > (2 * (v_Qtes - v_Seuil)) THEN
            v_Q_reap := (v_Q_tot_com - v_Qtes) * 1.2;
        ELSE
            v_Q_reap := (v_Q_tot_com - v_Qtes);
        END IF;
        
        v_Mnt_reap := v_Q_reap * v_PU;
        v_New_Stock := v_Qtes + v_Q_reap;
        
        INSERT INTO Reapp (refp, libp, Q_reap, Mnt_reap, New_Stock)
        VALUES (v_refp, v_libp, v_Q_reap, v_Mnt_reap, v_New_Stock);
    END LOOP;
    COMMIT;
END;
/
