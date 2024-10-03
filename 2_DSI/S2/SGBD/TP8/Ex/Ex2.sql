CREATE OR REPLACE TRIGGER verif_quantite_stock
BEFORE UPDATE OR DELETE ON Produit
FOR EACH ROW
BEGIN
    IF DELETING THEN
        IF :old.qtes != 0 THEN
            RAISE_APPLICATION_ERROR(-20001, 'Impossible de supprimer un produit avec une quantite en stock non nulle.');
        END IF;
    ELSE
        IF :new.qtes < 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'La quantite en stock ne peut pas être négative.');
        END IF;
    END IF;
END;
/
