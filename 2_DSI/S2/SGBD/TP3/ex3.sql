DECLARE
    v_numc    Commande.numc%TYPE := &numc;
    v_datec   Commande.datec%TYPE;
    v_mntc    Commande.mntc%TYPE := 0; 
BEGIN
    SELECT datec, mntc 
    INTO v_datec, v_mntc
    FROM commande
    WHERE numc = v_numc;


    DBMS_OUTPUT.PUT_LINE('DATE : ' || v_datec);
    DBMS_OUTPUT.PUT_LINE('MONTANT TOTAL : ' || v_mntc);


END;
/