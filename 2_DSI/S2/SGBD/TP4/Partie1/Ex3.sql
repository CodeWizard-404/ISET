DECLARE
    numCom commande.numc%TYPE;
    datecom DATE;
    mnt commande.numc%TYPE;
BEGIN
    numCom := '&numCom';
    
        SELECT datec, mntc INTO datecom, mnt FROM commande WHERE numc = numCom;
        
        IF mnt IS NULL THEN
            DBMS_OUTPUT.PUT_LINE('Date de la commande : ' || TO_CHAR(datecom, 'DD-MON-YYYY'));
            DBMS_OUTPUT.PUT_LINE('Montant non calculé !!!');
            UPDATE commande SET mntc = 0 WHERE numc = numCom;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Date de la commande : ' || TO_CHAR(datecom, 'DD-MON-YYYY'));
            DBMS_OUTPUT.PUT_LINE('Montant commande : ' || mnt);
        END IF;
        
    EXCEPTION
        WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE('Plusier Commande Trouver !');       
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('commande introuvable !');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Erreur : ' || SQLERRM);

END;
/
