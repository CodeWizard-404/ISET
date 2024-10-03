#include <stdio.h>

void permuter(int *a, int *b, int *c)
{
    int tmp = *a;
    *a = *c;
    *c = *b;
    *b = tmp;
}

void main()
{

    int a, b, c;

    printf("*Entrez trois entiers :\n");
    printf(" -Entier 1: ");
    scanf("%d", &a);
    printf(" -Entier 2: ");
    scanf("%d", &b);
    printf(" -Entier 3: ");
    scanf("%d", &c);
    printf("\n +Avant permutation : a = %d, b = %d, c = %d\n", a, b, c);
    permuter(&a, &b, &c);
    printf(" +Apres permutation : a = %d, b = %d, c = %d\n", a, b, c);

}
