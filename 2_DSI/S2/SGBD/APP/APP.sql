--1

declare
    v_numligne number;
    v_Datechargement date;
    v_Montantdisponible number;
    v_Etat varchar2(20);
    v_Dateepuisement date;
    v_idclient number;
begin
    v_numligne := &numligne; 

    select Datechargement, Montantdisponible, etat, dateepuisement, idclient
    into v_datechargement, v_montantdisponible, v_etat, v_dateepuisement, v_idclient
    from ligne
    where numligne = v_numligne;

    DBMS_OUTPUT.PUT_LINE('Datechargement: ' || TO_CHAR(v_datechargement, 'DD/MM/YYYY'));
    DBMS_OUTPUT.PUT_LINE('Montantdisponible: ' || v_montantdisponible);
    DBMS_OUTPUT.PUT_LINE('Etat: ' || v_etat);
    DBMS_OUTPUT.PUT_LINE('Dateepuisement: ' || TO_CHAR(v_dateepuisement, 'DD/MM/YYYY'));
    DBMS_OUTPUT.PUT_LINE('ID Client: ' || v_idclient);

end;
/




--2
declare
    v_idclient number(3);
    v_Nomclient varchar2(20);
    v_Ville varchar2(20);
    v_NbLigne number(10);
begin
    v_idclient := &idclient; 

    select Nomclient, Ville
    into v_Nomclient, v_Ville
    from client
    where idclient = v_idclient;

    select count(*)
    into v_NbLigne
    from ligne
    where idclient = v_idclient;

    DBMS_OUTPUT.PUT_LINE('Nom client : ' || v_Nomclient);
    DBMS_OUTPUT.PUT_LINE('Ville : ' || v_Ville);
    DBMS_OUTPUT.PUT_LINE('Nbr lignes : ' || v_NbLigne);

end;
/






--3

declare
    v_idclient number(3);
    v_Sold number;
    v_msj varchar(20);
begin
    v_idclient := &idclient; 

    select sum(Montantdisponible)
    into v_Sold
    from ligne
    where idclient = v_idclient;

    if v_Sold is null then
        v_msj := 'Client sans ligne';
    elsif v_Sold < 5 then
        v_msj := 'Mauvais client';
    elsif v_Sold >= 5 and v_Sold <= 20 then
        v_msj := 'Client moyen';
    else
        v_msj := 'Bon client';
    end if;

    DBMS_OUTPUT.PUT_LINE(v_msj);

end;
/


--4

declare
    v_numligne number(8) := 97555634;

begin
    update ligne
    set Montantdisponible = Montantdisponible + (Montantdisponible *0.05)
    where numligne = v_numligne;

commit;

end;
/



--5

declare
    v_numligne number(8);
    v_recharge number;


begin
    v_numligne := &numligne; 
    v_recharge := &recharge;

    update ligne
    set Montantdisponible = Montantdisponible + v_recharge,
        Datechargement = sysdate,
        dateepuisement = add_months(sysdate, 3)
    where numligne = v_numligne;

commit;

end;
/




--6

begin
    delete from ligne
    where etat ='bloque' and dateepuisement<= add_months(sysdate, -3);
commit;

end;
/