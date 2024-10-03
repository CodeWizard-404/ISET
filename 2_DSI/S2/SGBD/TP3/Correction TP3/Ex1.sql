set serveroutput on
declare
refprod produit.refp%type;
qte produit.qtes%type;
prix produit.pu%type;
begin
refprod:=&refprod;
select qtes,pu into qte,prix from produit where refp=refprod;
dbms_output.put_line('le prix est ' || prix);
dbms_output.put_line('la quantite est ' || qte);
if qte=0 then
	dbms_output.put_line('Produit en rupture de stock');
elsif qte<=5 then
	dbms_output.put_line('Produit necessite un approvisionnement');
	update produit set pu=pu*1.15 where refp=refprod;
elsif qte>50 then
	dbms_output.put_line('Produit en promotion');
	update produit set pu=pu*0.8 where refp=refprod;
end if;
commit;
end;
/

