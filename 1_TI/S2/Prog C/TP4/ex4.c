#include <stdio.h>

void remplir(int* T) {
    printf("*Entrez 6 entiers :\n");
    for (int* p = T; p < T + 6; p++) {
        printf("T[%lld] : ", p - T);
        scanf("%d", p);
    }
}

int recherche(int* T, int val) {
    for (int* p = T; p < T + 6; p++) {
        if (*p == val) {
            return p - T;
        }
    }
    return -1;
}

int main() {
    int T[6];
    int val;

    remplir(T);

    printf("\n*Entrez val a rechercher : ");
    scanf("%d", &val);

    int pos = recherche(T, val);

    if (pos != -1) {
        printf(" +Val %d trouvee a la pos \033[31m%d\033[0m \n", val, pos);
    } else {
        printf(" \033[31m-Val %d n'existe pas\033[0m\n", val);
    }

    return 0;
}
