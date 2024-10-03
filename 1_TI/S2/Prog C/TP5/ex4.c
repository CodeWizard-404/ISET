#include <stdio.h>

// Fonction pour saisir les entiers d'une matrice de taille N*M
void Saisie(int N, int M, int matrice[N][M]) {
    printf("Saisie des entiers de la matrice :\n");
    int *p = &matrice[0][0];
    for (int k = 0; k < N * M; k++, p++) {
        printf("matrice[%d][%d] = ", k / M, k % M);
        scanf("%d", p);
    }
}


// Fonction pour calculer la somme de 2 matrices de taille N*M
void Somme(int N, int M, int (*matrice1)[M], int (*matrice2)[M], int (*matrice_resultat)[M]) {
    int *p1 = (int*)matrice1; 
    int *p2 = (int*)matrice2; 
    int *p_resultat = (int*)matrice_resultat;

    for (int i = 0; i < N * M; i++) {
        *(p_resultat + i) = *(p1 + i) + *(p2 + i);
    }
}


void Affiche(int N, int M, int (*matrice)[M]) {
    printf(" -La matrice :\n");
    int *p = &matrice[0][0];

    for (int k = 0; k < N*M; k++) {
        printf("|%d", *p++);
        if ((k+1) % M == 0) {
            printf("|\n");
    
        }
    }
}




// Programme principal
int main() {
    int N, M;
    printf("Entrez le nombre de lignes N : ");
    scanf("%d", &N);
    printf("Entrez le nombre de colonnes M : ");
    scanf("%d", &M);
    printf("\n");

    // Saisie de la première matrice
    int A[N][M];
    Saisie(N, M, A);

    // Saisie de la deuxième matrice
    int B[N][M];
    Saisie(N, M, B);

    // Calcul de la somme des matrices
    int C[N][M];
    Somme(N, M, A, B, C);

    // Affichage de la matrice résultat
    Affiche(N, M, C);

    return 0;
}
