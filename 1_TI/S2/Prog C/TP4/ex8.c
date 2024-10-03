#include <stdio.h>

void remplir(int *T)
{
    int *p = T;
    printf("*Entrez 10 entiers :\n");
    for (p=T; p < T + 10; p++)
    {
        printf("T[%lld] : ", p - T + 1);
        scanf("%d", p);
    }
}

void findX(int *T, int X)
{
    int count = 0;
    int first = -1;
    int last = -1;
    int *p = T;

    for (p=T; p < T + 10; p++)
    {
        if (*p == X)
        {
            count++;
            if (first == -1)
            {
                first = p - T;
            }
            last = p - T;
        }
    }

    if (count > 0)
    {
        printf(" +Found \033[31m%d: %d\033[0m times\n", X, count);
        printf(" +First appearance at position \033[31m%d\033[0m\n", first);
        printf(" +Last appearance at position \033[31m%d\033[0m\n", last);
    }
    else
    {
        printf(" -Did not find \033[31m%d\033[0m \n", X);
    }
}

int main()
{
    int T[10];
    int X;
    int *p = T;

    remplir(T);

    printf("\n*Enter X: ");
    scanf("%d", &X);

    printf("T: |");
    for (p=T; p < T + 10; p++)
    {
        printf("%d|", *p);
    }

    printf("\n\n*Finding \033[31m%d\033[0m...\n", X);
    findX(T, X);

    return 0;
}
