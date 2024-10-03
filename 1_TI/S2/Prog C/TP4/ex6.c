#include <stdio.h>

void remplir(float *T)
{
    printf("*Entrez 10 entiers :\n");
    for (float *p = T; p < T + 10; p++)
    {
        printf("T[%d] : ", (int)(p - T) + 1);
        scanf("%f", p);
    }
}

void tri(float *T)
{
    float temp;
    for (float *p1 = T; p1 < T + 9; p1++)
    {
        for (float *p2 = T; p2 < T + 9 - (p1 - T); p2++)
        {
            if (*p2 > *(p2 + 1))
            {
                temp = *p2;
                *p2 = *(p2 + 1);
                *(p2 + 1) = temp;
            }
        }
    }
}

int main()
{
    float T[10] ;

    remplir(T);

    printf("\n -Tableau non trie : |");
    for (float *p = T; p < T + 10; p++)
    {
        printf("%.1f|", *p);
    }

    tri(T);

    printf("\n -Tableau trie     : |");
    for (float *p = T; p < T + 10; p++)
    {
        printf("\033[31m%.1f\033[0m|", *p);
    }

    return 0;
}
