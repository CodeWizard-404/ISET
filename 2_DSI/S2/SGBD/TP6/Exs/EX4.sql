SET SERVEROUTPUT ON

DECLARE
    v_numc commande.numc%TYPE;
    v_datec commande.datec%TYPE;
    v_codc commande.codc%TYPE;
    v_nomc client.nomc%TYPE;
    v_refp lig_cde.refp%TYPE;
    v_qtec lig_cde.qtec%TYPE;
    v_pu produit.pu%TYPE;
    v_total NUMBER;
    v_title VARCHAR2(70) := '********************************************************************';

    CURSOR c_commandes (v_codc NUMBER) IS
        SELECT c.numc, c.datec, c.codc, cl.nomc
        FROM commande c
        INNER JOIN client cl ON c.codc = cl.codc
        WHERE c.codc = v_codc;

    CURSOR c_details (v_numc NUMBER) IS
        SELECT l.refp, l.qtec, p.pu
        FROM lig_cde l
        INNER JOIN produit p ON l.refp = p.refp
        WHERE l.numc = v_numc;
BEGIN
    FOR rec IN c_commandes(100) LOOP
        v_numc := rec.numc;
        v_datec := rec.datec;
        v_codc := rec.codc;
        v_nomc := rec.nomc;

        DBMS_OUTPUT.PUT_LINE(v_title);
        DBMS_OUTPUT.PUT_LINE('|*   Commande n : ' || LPAD(v_numc, 5) || '  * Date : ' || TO_CHAR(v_datec, 'DD/MM/YYYY') || ' * Client : ' || LPAD(v_codc, 4) || '   ****|');
        DBMS_OUTPUT.PUT_LINE(v_title);
        DBMS_OUTPUT.PUT_LINE('******|**  Reference  **|** Qte Cdeee **|**   PU   **|** Total   **|');
        
        FOR rec_details IN c_details(v_numc) LOOP
            v_refp := rec_details.refp;
            v_qtec := rec_details.qtec;
            v_pu := rec_details.pu;
            v_total := v_qtec * v_pu;
            
            DBMS_OUTPUT.PUT_LINE('******|**'|| LPAD(v_refp, 10) || '   **|** ' || LPAD(v_qtec, 5) || '     **|*' || LPAD(TO_CHAR(v_pu, '9999.99'), 8) || ' **|*' || LPAD(TO_CHAR(v_total, '99999'), 8) || '   *|');
        END LOOP;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(v_title);
END;
/
