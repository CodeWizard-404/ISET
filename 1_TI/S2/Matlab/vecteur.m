function [nb]=vecteur(v)
n=size(v,2);
nb=0;
for i=1:n
    if isprime(v(i))
        nb=nb+1;
    end
end
end
