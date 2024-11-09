a=[1 3 2;-5 3 1;-10 0 3;0 0 -2]
b=[1 -2 5;6 2 -1]
c=[10 -5;3 1]

%(1)

%a*b %le nb de colone de a<> ligne de b
%b*a

%(2)

m=b'
m(3,:)=[]

%(3)

d=eye(2,2)

%(4)

%det(a)
%det(b)
det(c)
det(d)

e=a*a'

%(5)

a(4,:)=[]
a(3,:)=[]
a(:,3)=[]

%(6)

b(3,:)=[2 0 5]

%(7)

inv(a)
inv(b)
inv(c)
inv(d)

%(8)

det(inv(a))
1/det(a)%det(inv(a))==1/det(a)

%(9)

a*c
a.*c

%(10)

k=c\a

%(11)

o=ones(3,4)
z=zeros(2,3)

%(12)

f=magic(4)

%(13)

sum(f)
sum(f')

%(14)

diag(f)
sum(diag(f))

%(15)

trace(f)%trace(f)=sum(diag(f))

%(16)

bt=tril(b)




