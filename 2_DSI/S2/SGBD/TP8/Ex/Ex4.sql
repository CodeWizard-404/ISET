CREATE OR REPLACE TRIGGER maj_apres_lig_cde
AFTER INSERT OR UPDATE OR DELETE ON Lig_Cde
FOR EACH ROW
DECLARE
    v_montant_commande NUMBER;
BEGIN
    SELECT SUM(p.pu * l.qtec)
    INTO v_montant_commande
    FROM Produit p, Lig_Cde l
    WHERE p.refp = l.refp AND l.numc = :new.numc;
    
    UPDATE Commande
    SET mntc = v_montant_commande
    WHERE numc = (SELECT numc FROM Lig_Cde WHERE numc = :new.numc);
    
    UPDATE Produit
    SET qtes = qtes - :new.qtec
    WHERE RefP = :new.refp;
    
    UPDATE Client
    SET CA = (SELECT SUM(c.mntc)
                FROM Commande c
                WHERE c.codc = (SELECT codc FROM Commande WHERE numc = :new.numc))
    WHERE codc = (SELECT codc FROM Commande WHERE numc = :new.numc);
END;
/
