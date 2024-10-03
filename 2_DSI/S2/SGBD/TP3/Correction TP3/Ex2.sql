set serveroutput on
declare
refprod frs_prod.refp%type;
prix frs_prod.puf%type;
begin
refprod:=&refprod;
select avg(puf) into prix from frs_prod where refp=refprod;
if prix is not null then
	dbms_output.put_line('le prix moyen d''achat du produit : ' || refprod ||' est ' || prix);
else
	dbms_output.put_line('Reference produit inexistante !!!');
end if;
end;
/
