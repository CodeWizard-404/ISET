#include <stdio.h>

int TabEqual(int *T1, int *T2)
{
    int *p1 = T1;
    int *p2 = T2;
    while (p1 < T1 + 5 && *p1 == *p2)
    {
        p1++;
        p2++;
    }
    return (p1 == T1 + 5);
}

int main()
{
    int T1[5] = {1, 2, 3, 4, 5};
    int T2[5] = {1, 2, 3, 4, 5};
    int T3[5] = {5, 4, 3, 2, 1};

    printf(" T1: |1|2|3|4|5|\n T2: |1|2|3|4|5|\n T3: |5|4|3|2|1|\n");

    if (TabEqual(T1, T2))
    {
        printf("T1 and T2 are \033[31mequal\033[0m\n");
    }
    else
    {
        printf("T1 and T2 are \033[31mnot equal\033[0m\n");
    }

    if (TabEqual(T1, T3))
    {
        printf("T1 and T3 are \033[31mequal\033[0m\n");
    }
    else
    {
        printf("T1 and T3 are \033[31mnot equal\033[0m\n");
    }
    return 0;
}
