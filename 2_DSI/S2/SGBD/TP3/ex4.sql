DECLARE
BEGIN
    UPDATE client
    SET nomc = INITCAP(nomc),
        ville = UPPER(ville);

    COMMIT;
END;
