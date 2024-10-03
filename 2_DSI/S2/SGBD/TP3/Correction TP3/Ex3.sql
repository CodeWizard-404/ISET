set serveroutput on
declare
numCom commande.numc%type;
datecom date;
mnt commande.numc%type;
begin
numCom:=&numCom;
select datec,mntc into datecom,mnt from commande where numc=numCom;
if mnt is null then
	dbms_output.put_line('date de la commande : ' || datecom);
	dbms_output.put_line('Montant non calcule !!!');
	update commande set mntc=0 where numc=numCom;
else
	dbms_output.put_line('date de la commande : ' || datecom);
	dbms_output.put_line('Montant commande : ' || mnt);
end if;
end;
/

