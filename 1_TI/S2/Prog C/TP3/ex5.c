/*

int A[] = {12, 23, 34, 45, 56, 67, 78, 89, 90};
int *P;
P = A;

a) *P+2 = 

    14 (la valeur de A[0] + 2).

b) *(P+2) = 

    34 (la valeur de A[2]).

c) &P+1 = 

    @ de la zone mémoire juste après celle où est stocké le pointeur P.

d) &A[4]-3 = 

    @ de A[1] (@ de A[4] - 3 * sizeof(int)).

e) A+3 = 
    
    @ de A[3] (@ de A[0] + 3 * sizeof(int)).

f) &A[7]-P =
    
    le nombre d'éléments entre A[7] et l'emplacement pointé par P.

g) P+(*P-10) =
    
    @ de l'élément suivant P, en fonction de la valeur de P ( P + (A[0] - 10) * sizeof(int)).

h) (P+(P+8)-A[7]) = 
    
    valeur de l'élément pointé par un pointeur déterminé à partir de P et de la valeur de l'élément à 8 positions après P, - valeur de A[7].


*/