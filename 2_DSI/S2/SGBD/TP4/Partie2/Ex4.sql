DECLARE
    v_numc commande.numc%TYPE;
    v_datec commande.datec%TYPE;
    v_mntc commande.mntc%TYPE;
    v_min_date DATE;
BEGIN

    SELECT MIN(datec)
    INTO v_min_date
    FROM commande;

    SELECT numc, datec, mntc
    INTO v_numc, v_datec, v_mntc
    FROM commande
    WHERE datec = v_min_date;

    DBMS_OUTPUT.PUT_LINE('Numero de commande : ' || v_numc);
    DBMS_OUTPUT.PUT_LINE('Date de commande : ' || TO_CHAR(v_datec, 'DD-MON-YYYY'));
    DBMS_OUTPUT.PUT_LINE('Montant de la commande : ' || v_mntc);

EXCEPTION
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('Erreur : ' || SQLERRM);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Erreur : ' || SQLERRM);
END;
/
