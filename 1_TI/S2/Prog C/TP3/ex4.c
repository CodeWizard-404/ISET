

/*
int A = 1; int B = 2; int C = 3;

A = 1
B = 2
C = 3

int *P1, *P2;

P1 non initialisé
P2 non initialisé

P1 = &A; P2 = &C; *P1 = (*P2)++;

P1 pointe vers A
P2 pointe vers C
A = 4 (*P2 initiale de 3 et incrémenté après)

P1 = P2; P2 = &B; *P1 = *P2;

P1 pointe vers B
P2 pointe vers B
B = 2 (valeur copiée dans *P1)

++*P2; *P1 *= *P2; P1 = &A;

B = 3 (incrémenté)
*P1 (pointe vers B) est multiplié par la valeur de B (3) donc = 9
P1 pointe vers A


Le contenu final  :

A = 1
B = 3
C = 4
*P1 = 9 (pointe vers l'emplacement de B)
*P2 = 3 (pointe vers l'emplacement de B)
*/

