% 1
m=[2 3 5 0 1;4 2 3 -1 0;5 2 2 1 -1;-1 0 3 1 -2;1 0 0 4 1];

% 2
s=0;
for i=1:5
    for j=1:5
        if(i==j)
            s=s+m(i,j);
        end
    end
end
disp(s);

sum(diag(m))

% 3
m(3,:)=[];
disp(m);

% 4
m(:,4)=[];
m(:,4)=[];
disp(m);

% 5
ligne=size(m,2);
colone=size(m,1);
disp(x);
disp(y);

% 6
%det(m)
% impossible matrice n'est pas carre

% 7
m(:,4)=[1 0 1 2];
disp(m);

% 8
som=0;
for i=1:4
   som=som+m(i,3);
end
disp(som);