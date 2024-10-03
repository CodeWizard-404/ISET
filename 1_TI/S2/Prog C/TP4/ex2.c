#include <stdio.h>

void remplir(int* T) {
    printf("Entrez 6 entiers :\n");
    for (int* p = T; p < T + 6; p++) {
        printf("T[%lld] : ", p - T);
        scanf("%d", p);
    }
}

void minMax(int *T, int *min, int *max) {
    *min = *max = *T; 
    for (int* p = T + 1; p < T + 6; p++) {
        if (*p < *min) {
            *min = *p;
        }
        if (*p > *max) {
            *max = *p; 
        }
    }
}

int main() {
    int T[6] ;
    int min, max;

    remplir(T);

    minMax(T, &min, &max);

    printf("\n*Tab :{");
    for (int* p = T; p < T + 6; p++) {
        printf("%d,", *p);
    }
    printf("}\n");

    printf(" -MIN : \033[31m%d\033[0m\n", min);
    printf(" -MAX : \033[31m%d\033[0m\n", max);

    return 0;

}
