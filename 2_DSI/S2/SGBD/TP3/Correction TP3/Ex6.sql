begin
update commande c 
set mntc=(select sum(qtec*pu) from lig_cde l,produit p 
where l.refp=p.refp and l.numc=c.numc);

commit;
end;
/
