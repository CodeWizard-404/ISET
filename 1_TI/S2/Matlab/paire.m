function [v]=paire(a)
n=size(a,1);
m=size(a,2);
for i=1:n
    for j=1:m
        if (mod(a(i,j),2)==0)
            disp(a(i,j))
        end
    end
end
end