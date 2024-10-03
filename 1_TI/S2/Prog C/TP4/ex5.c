#include <stdio.h>

void remplir(int *T)
{
    printf("*Entrez 6 entiers :\n");
    for (int *p = T; p < T + 6; p++)
    {
        printf("T[%lld] : ", p - T + 1);
        scanf("%d", p);
    }
}

void inverse(int *T)
{
    int *p1 = T;
    int *p2 = T + 5 ;

    while (p1 < p2)
    {
        int temp = *p1;
        *p1 = *p2;
        *p2 = temp;

        p1++;
        p2--;
    }
}

int main()
{
    int T[6];

    remplir(T);
    printf("\n");

    printf("\n -Tab original : |");
    for (int *p = T; p < T + 6; p++)
    {
        printf("%d |", *p);
    }

    inverse(T);

    printf("\n -Tab inverse  : |");
    for (int *p = T; p < T + 6; p++)
    {
        printf("\033[31m%d\033[0m |", *p);
    }

    return 0;
}
