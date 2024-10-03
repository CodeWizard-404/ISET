begin
update client set nomc=initcap(nomc),ville=upper(ville);
commit;
end;
/
