#include <stdio.h>

void insertion(int *T, int x)
{
    int *p = T;

    while (*p < x && p < T + 10)
        p++;

    for (int *q = T + 9; q >= p; q--)
        *(q + 1) = *q;

    *p = x;
}

int main()
{
    int T[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int x;

    printf("\n -Tableau trie : |");
    int *p = T;
    while (p < T + 10)
    {
        printf(" %d |", *p);
        p++;
    }

    printf("\n\n *Enter X : ");
    scanf("%d", &x);

    insertion(T, x);

    printf("\n -Nouveau tableau trie : |");
    p = T;
    int m=1;
    while (p < T + 11)
    {
        if ((*p == x)&&(m==1))
        {
            printf(" \033[31m%d\033[0m |", *p);
            m=2;
        }
        else
        {
            printf(" %d |", *p);
            
        }p++;
    }
    printf("\n");

    return 0;
}
