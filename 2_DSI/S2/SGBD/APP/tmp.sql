begin
    delete from ligne
    where etat ='bloque' and dateepuisement<= add_months(sysdate, -3);
commit;

end;
/