CREATE TABLE Cat_Cli (
    Codc NUMBER(4),
    Nomc VARCHAR2(20),
    CA NUMBER(10,3),
    Cred NUMBER(10,3),
    CredMax NUMBER(10,3),
    Categorie VARCHAR2(20),
    Etat_Cred VARCHAR2(20)
);


CREATE OR REPLACE PROCEDURE Cat_Etat(
    code IN Client.Codc%TYPE,
    Categorie OUT VARCHAR2,
    EtatCred OUT VARCHAR2
)
AS
    CA_client NUMBER;
    Cred_client NUMBER;
    CredMax_client NUMBER;
BEGIN
    SELECT CA, Cred, CredMax INTO CA_client, Cred_client, CredMax_client
    FROM Client
    WHERE Codc = code;

    IF CA_client > 10000 THEN
        Categorie := 'Client fidele';
    ELSIF CA_client BETWEEN 5000 AND 10000 THEN
        Categorie := 'Bon Client';
    ELSE
        Categorie := 'Client passager';
    END IF;

    IF Cred_client > CredMax_client THEN
        EtatCred := 'Client douteux';
    ELSIF Cred_client BETWEEN CredMax_client * 0.5 AND CredMax_client THEN
        EtatCred := 'Client doit regler';
    ELSE
        EtatCred := 'Client solvable';
    END IF;

END Cat_Etat;
/


DECLARE
    v_Codc Client.Codc%TYPE;
    v_Nomc Client.Nomc%TYPE;
    v_CA Client.CA%TYPE;
    v_Cred Client.Cred%TYPE;
    v_CredMax Client.CredMax%TYPE;
    v_Categorie VARCHAR2(20);
    v_Etat_Cred VARCHAR2(20);
BEGIN
    FOR client IN (SELECT Codc, Nomc, CA, Cred, CredMax FROM Client) LOOP
        Cat_Etat(client.Codc, v_Categorie, v_Etat_Cred);
        
        INSERT INTO Cat_Cli (Codc, Nomc, CA, Cred, CredMax, Categorie, Etat_Cred)
        VALUES (client.Codc, client.Nomc, client.CA, client.Cred, client.CredMax, v_Categorie, v_Etat_Cred);
    END LOOP;
    COMMIT;
END;
/
