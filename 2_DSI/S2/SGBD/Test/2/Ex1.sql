SET SERVEROUTPUT ON;

DECLARE
    v_nb_passagers NUMBER;
    v_ca NUMBER;
BEGIN
    INSERT INTO Stat (NumVol, Source, Destination, NbPassager, CA)
    SELECT c.numc AS NumVol, cl.ville AS Source, cl_dest.ville AS Destination, COUNT(l.qtec) AS NbPassager, SUM(l.qtec * p.pu) AS CA
    FROM commande c
    JOIN client cl ON c.codc = cl.codc
    JOIN lig_cde l ON c.numc = l.numc
    JOIN produit p ON l.refp = p.refp
    JOIN client cl_dest ON c.codc = cl_dest.codc
    GROUP BY c.numc, cl.ville, cl_dest.ville;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Calcul des statistiques des vols termine.');

END;
/
