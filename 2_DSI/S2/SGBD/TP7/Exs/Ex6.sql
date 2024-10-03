create table Reapp(
refp varchar2(6),
libp varchar2(20),
Q_reap number(4),
Mnt_reap number(10,3),
New_Stock number(4),
constraint pk_reap_ref primary key(refp));


CREATE OR REPLACE FUNCTION Qte_Com(
    RefProd IN VARCHAR2
) RETURN NUMBER
IS
    TotalQte NUMBER := 0;
BEGIN
    SELECT SUM(Qtec)
    INTO TotalQte
    FROM Lig_Cde
    WHERE Refp = RefProd;

    RETURN TotalQte;
END Qte_Com;
/

CREATE OR REPLACE FUNCTION Qte_Reap(
    RefProd IN VARCHAR2
) RETURN NUMBER
IS
    Q_tot_com NUMBER;
    Q_reap NUMBER := 0;
    Qtes_produit NUMBER;
    Seuil_produit NUMBER;
BEGIN
    Q_tot_com := Qte_Com(RefProd);

    SELECT Qtes, Seuil INTO Qtes_produit, Seuil_produit
    FROM Produit
    WHERE Refp = RefProd;

    IF Q_tot_com > (4 * (Qtes_produit - Seuil_produit)) THEN
        Q_reap := (Q_tot_com - Qtes_produit) * 1.4;
    ELSIF Q_tot_com > (3 * (Qtes_produit - Seuil_produit)) THEN
        Q_reap := (Q_tot_com - Qtes_produit) * 1.3;
    ELSIF Q_tot_com > (2 * (Qtes_produit - Seuil_produit)) THEN
        Q_reap := (Q_tot_com - Qtes_produit) * 1.2;
    ELSE
        Q_reap := Q_tot_com - Qtes_produit;
    END IF;

    RETURN Q_reap;
END Qte_Reap;
/


DECLARE
    v_Refp Produit.Refp%TYPE;
    v_Libp Produit.Libp%TYPE;
    v_Q_reap NUMBER;
    v_Mnt_reap NUMBER;
    v_New_Stock NUMBER;
BEGIN
    FOR prod IN (SELECT Refp, Libp, PU, Qtes, Seuil FROM Produit) LOOP
        v_Q_reap := Qte_Reap(prod.Refp);
        
        v_Mnt_reap := v_Q_reap * prod.PU;
        v_New_Stock := prod.Qtes + v_Q_reap;
        
        INSERT INTO Reapp (Refp, Libp, Q_reap, Mnt_reap, New_Stock)
        VALUES (prod.Refp, prod.Libp, v_Q_reap, v_Mnt_reap, v_New_Stock);
    END LOOP;
    COMMIT;
END;
/
