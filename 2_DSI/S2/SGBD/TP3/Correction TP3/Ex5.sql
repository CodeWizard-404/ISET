create table Cat_Cli(
codc number(4),
nomc varchar2(20),
ca number(10,3),
cred number(10,3),
credmax number(10,3),
Categorie varchar2(20),
Etat_Cred varchar2(20),
constraint pk2_codc primary key(codc));

set serveroutput on

declare
cl client%rowtype;
code client.codc%type;
begin
code:=&code;
select * into cl from client where codc=code;

delete from Cat_Cli where codc=code;
insert into Cat_cli(codc,nomc,ca,cred,credmax) values(cl.codc,cl.nomc,cl.ca,cl.cred,cl.credmax);

if cl.ca>10000 then
	update Cat_cli set categorie='Client fidele' where codc=code;
elsif cl.ca>=5000 then
	update Cat_cli set categorie='Bon Client' where codc=code;
else
	update Cat_cli set categorie='Client passager' where codc=code;
end if;

if cl.cred>cl.credMax then
	update Cat_cli set Etat_Cred='Client douteux' where codc=code;
elsif cl.cred>=cl.credMax/2 then
	update Cat_cli set Etat_Cred='Client doit regler' where codc=code;
else
	update Cat_cli set Etat_Cred='Client solvable' where codc=code;
end if;

commit;
end;
/
