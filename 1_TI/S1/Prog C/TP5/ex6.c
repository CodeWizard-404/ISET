#include <stdio.h>

int suitFibonacci(int n)
{
    int a, b, i, U;
    if ((n == 1) || (n == 2))
    {
        return n;
    }
    else
    {
        a = 1;
        b = 2;
        for (i = 3; i <= n; i++)
        {
            U = a + b;
            a = b;
            b = U;
        }
        return U;
    }
}

void main(){
    int n;
    printf("Entrez n : ");
    scanf("%d", &n);
    suitFibonacci(n);
    printf("U%d = %d\n",n, suitFibonacci(n));
}