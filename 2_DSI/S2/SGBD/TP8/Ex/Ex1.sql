CREATE OR REPLACE TRIGGER maj_quantite_stock
AFTER INSERT OR UPDATE ON Frs_Prod
FOR EACH ROW
BEGIN
    UPDATE Produit
    SET qtes = qtes + :new.qtef
    WHERE RefP = :new.refp;
END;
/
