begin
update client set CA=(select sum(mntc) from commande where commande.codc=client.codc);
update client set CA=0 where CA is null;
update client set CredMax=CA*0.1;

commit;
end;
/
