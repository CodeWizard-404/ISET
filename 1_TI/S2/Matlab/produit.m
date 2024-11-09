function [c] = produit(A,B)

    for i=1:3
        for j=1:3
            c(i,j)=0;
            for k=1:3
                c(i,j)=c(i,j)+ A(i,k)*B(k,j);
            end            
        end
    end
end
