#include <stdio.h>

void remplir(int *tab, int n)
{
    printf("Entrez %d entiers :\n", n);
    for (int *p = tab; p < tab + n; p++)
    {
        printf("A[%lld] : ", p - tab);
        scanf("%d", p);
    }
}

void afficher(int *tab, int n, int c)
{
    printf("Tab : |");
    for (int *p = tab; p < tab + n; p++)
    {
        if (((p - tab) == 4) && (c == 4))
        {
            printf("\033[31m%d\033[0m|", *p);
        }
        else if (((p - tab) == 7) && (c == 6))
        {
            printf("\033[31m%d\033[0m|", *p);
        }
        else
        {
            printf("%d|", *p);
        }
    }
    printf("\n");
}

void incrementer(int *p)
{
    (*p)++;
}

int main()
{
    int A[10];
    int *p = &A[4]; // pointeur vers l'élément 5 du tableau
    int *q = &A[6]; // pointeur vers l'élément 7 du tableau

    int c = 0;
    remplir(A, 10);
    afficher(A, 10, c);
    printf("\n");

    c = 4;
    incrementer(p); // incrémenter la valeur pointée par p
    printf("Apres l'incrementation de l'element 5 : \n");
    afficher(A, 10, c);
    printf("\n");

    c = 6;
    q++;            // incrémenter le pointeur q
    incrementer(q); // incrémenter la valeur pointée par q
    printf("Apres l'incrementation de l'element 7 : \n");
    afficher(A, 10, c);

    return 0;
}
