DECLARE
    v_numVol vol.numVol%TYPE ;
    v_source vol.source%TYPE;
    v_destination vol.destination%TYPE;
    v_dateVol vol.dateVol%TYPE;
    v_marqueAvion avion.marque%TYPE;
    v_nbrePlaces avion.nbrePlaces%TYPE;
    v_nbPassager NUMBER;
    v_prixMoyen NUMBER;
BEGIN
    v_numVol := '&NumVol';

    SELECT source, destination, dateVol, marque, nbrePlaces
    INTO v_source, v_destination, v_dateVol, v_marqueAvion, v_nbrePlaces
    FROM vol v JOIN avion a ON v.codeAv = a.codeAv
    WHERE numVol = v_numVol;

    SELECT COUNT(*) INTO v_nbPassager FROM passager WHERE numVol = v_numVol;

    SELECT AVG(prixPaye) INTO v_prixMoyen FROM passager WHERE numVol = v_numVol;

    IF TO_CHAR(v_dateVol, 'MM') IN ('07', '08') THEN
        v_prixMoyen := v_prixMoyen * 1.10; 
    ELSE
        IF v_nbPassager < v_nbrePlaces * 0.5 THEN
            v_prixMoyen := v_prixMoyen * 0.80; 
        END IF;
    END IF;

    INSERT INTO Stat(NumVol, MarqueAvion, NbPassager, PrixMoyen)
    VALUES(v_numVol, v_marqueAvion, v_nbPassager, v_prixMoyen);

    DBMS_OUTPUT.PUT_LINE('Numéro de Vol: ' || v_numVol);
    DBMS_OUTPUT.PUT_LINE('Source: ' || v_source);
    DBMS_OUTPUT.PUT_LINE('Destination: ' || v_destination);
    DBMS_OUTPUT.PUT_LINE('Date du Vol: ' || TO_CHAR(v_dateVol, 'DD/MM/YYYY'));
    DBMS_OUTPUT.PUT_LINE('Marque de l avion: ' || v_marqueAvion);
    DBMS_OUTPUT.PUT_LINE('Nombre de Places: ' || v_nbrePlaces);
    DBMS_OUTPUT.PUT_LINE('Nombre de Passagers: ' || v_nbPassager);
    DBMS_OUTPUT.PUT_LINE('Prix Moyen Payé: ' || v_prixMoyen);

END;
/
