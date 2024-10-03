DECLARE
    v_codePassager passager.codePass%TYPE;
    v_prixPaye passager.prixPaye%TYPE;
    v_typePassager passager.typePass%TYPE;
    v_nomPassager passager.nomPass%TYPE;
    v_prenomPassager passager.prenomPass%TYPE;
    v_numVol passager.numVol%TYPE;
BEGIN
    v_codePassager :='&CodePassager';

    SELECT prixPaye, typePass, nomPass, prenomPass, numVol
    INTO v_prixPaye, v_typePassager, v_nomPassager, v_prenomPassager, v_numVol
    FROM passager
    WHERE codePass = v_codePassager;

    IF v_prixPaye IS NULL THEN
        v_prixPaye := 0;
    END IF;

    DBMS_OUTPUT.PUT_LINE('Code Passager: ' || v_codePassager);
    DBMS_OUTPUT.PUT_LINE('Type de Passager: ' || v_typePassager);
    DBMS_OUTPUT.PUT_LINE('Nom: ' || v_nomPassager);
    DBMS_OUTPUT.PUT_LINE('Prenom: ' || v_prenomPassager);
    DBMS_OUTPUT.PUT_LINE('Prix Paye: ' || v_prixPaye);
    DBMS_OUTPUT.PUT_LINE('Num Vol: ' || v_numVol);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Aucune information trouvée pour le code passager ' || v_codePassager);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Une erreur est survenue.');
END;
/
