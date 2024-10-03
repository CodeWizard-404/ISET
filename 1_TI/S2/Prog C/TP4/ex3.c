#include <stdio.h>

int main() {
    int T[10];
    int *p = T; 

    printf("*Entrer 10 entiers :\n");
    for (p = T; p < T + 10; p++) {
        printf("T[%lld] : ", p - T + 1);
        scanf("%d", p);
    }
    printf("\n");

    printf("\n -Positifs : |");
    for (p = T; p < T + 10; p++) {
        if (*p >= 0) {
            printf("\033[31m+%d\033[0m |", *p);
        }
    }

    printf("\n -Negatifs : |");
    for (p = T; p < T + 10; p++) {
        if (*p < 0) {
            printf("\033[31m%d\033[0m |", *p);
        }
    }
    return 0;
}
