#include <stdio.h>

int supprimer(int *T, int x)
{
    int *p = T,m;
    while (*p != x && p < T + 10)
    {
        p++;
    }
    if (*p == x)
    {
        m=(p-T);
        while (p < T + 9)
        {
            *p = *(p + 1);
            p++;
        }
    }
    return m;
}

int main()
{
    int T[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int x;

    printf("\n -Tab : |");
    int* p = T;
    while(p-T < 10) {
        printf("%d|", *p++);
    }

    printf("\n\n *Entrez X a supprimer : ");
    scanf("%d", &x);

    int m=supprimer(T, x);

    printf("\n -Nouveau tableau : |");
    p = T;
    while(p-T < 9) {
        if (((p-T) == m-1))
        {
            printf("%d\033[31m||\033[0m", *p++);
        }
        else
        {
            printf("%d|", *p++);
        }
    }
    printf("\n");

    return 0;
}
