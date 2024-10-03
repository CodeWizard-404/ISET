CREATE OR REPLACE PROCEDURE Afficher_spectacle(id_salle IN salle.salleID%TYPE, annee IN NUMBER) IS
BEGIN
    FOR spectacle_rec IN (SELECT s.titre, s.dateSpectacle, s.heure, COUNT(v.billetID) AS nb_billets_vendus
                        FROM spectacle s
                        LEFT JOIN vente v ON s.spectacleID = v.spectacleID
                        WHERE s.salleID = id_salle
                        AND EXTRACT(YEAR FROM s.dateSpectacle) = annee
                        GROUP BY s.titre, s.dateSpectacle, s.heure)
    LOOP
        DBMS_OUTPUT.PUT_LINE('Titre: ' || spectacle_rec.titre);
        DBMS_OUTPUT.PUT_LINE('Date: ' || TO_CHAR(spectacle_rec.dateSpectacle, 'DD-MON-YYYY'));
        DBMS_OUTPUT.PUT_LINE('Heure: ' || TO_CHAR(spectacle_rec.heure, 'HH24:MI'));
        DBMS_OUTPUT.PUT_LINE('Nombre de billets vendus: ' || spectacle_rec.nb_billets_vendus);

        DBMS_OUTPUT.PUT_LINE('Chanteurs participants:');
        FOR chanteur_rec IN (SELECT c.nomchanteur
                            FROM chanteur c
                            JOIN participer p ON c.chanteurID = p.chanteurID
                            WHERE p.spectacleID = spectacle_rec.spectacleID)
        LOOP
            DBMS_OUTPUT.PUT_LINE('- ' || chanteur_rec.nomchanteur);
        END LOOP;

        DBMS_OUTPUT.PUT_LINE('-----------------------------------');
    END LOOP;
END;
/

