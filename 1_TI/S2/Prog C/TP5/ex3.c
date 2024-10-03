#include <stdio.h>

void lire_N(int *N) {
    do {
        printf("*Entrer un entier N entre 1 et 20: ");
        scanf("%d", N);
    } while (*N <= 0 || *N > 20);
}

void remplir(int *tab, int N) {
    int *p = tab;
    while (p < tab + N) {
        printf("+ T[%lld]: ", p - tab);
        scanf("%d", p);
        p++;
    }
}

void inverser(int *tab, int N) {
    int *p_debut = tab;
    int *p_fin = tab + N - 1;
    while (p_debut < p_fin) {
        int temp = *p_debut;
        *p_debut = *p_fin;
        *p_fin = temp;
        p_debut++;
        p_fin--;
    }
}

int main() {
    int N;
    lire_N(&N);

    int tab[N];
    remplir(tab, N);

    printf("\n -Le tab avant l'inversion: ");
    int *p = tab;
    while (p < tab + N) {
        printf("|%d|", *p);
        p++;
    }
    printf("\n");

    inverser(tab, N);

    printf(" -Le tab apres l'inversion: ");
    p = tab;
    while (p < tab + N) {
        printf("|%d|", *p);
        p++;
    }
    printf("\n");

    return 0;
}
