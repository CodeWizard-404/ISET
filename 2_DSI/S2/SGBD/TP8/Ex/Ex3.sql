CREATE TABLE client_old AS SELECT * FROM client WHERE 1 = 2;
CREATE TABLE commande_old AS SELECT * FROM commande WHERE 1 = 2;

CREATE OR REPLACE TRIGGER archive_client
BEFORE DELETE ON client
FOR EACH ROW
BEGIN
  IF :OLD.cred <> 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Impossible de supprimer un client avec un credit non nul');
  ELSE
    INSERT INTO client_old VALUES(:OLD.codc, :OLD.nomc, :OLD.ville, :OLD.ca, :OLD.cred, :OLD.credmax);
    DELETE FROM commande WHERE codc = :OLD.codc;
  END IF;
END;
/