#include <stdio.h>
#include <stdlib.h>

typedef struct Cellule {
    int valeur;
    struct Cellule *suivant;
} Cellule;

Cellule *Initialiser() {
    return NULL;
}

Cellule *InsérerTête(Cellule *L, int x) {
    Cellule *nouvelleCellule = (Cellule*)malloc(sizeof(Cellule));
    nouvelleCellule->valeur = x;
    nouvelleCellule->suivant = L;
    return nouvelleCellule;
}

Cellule *SupprimerTête(Cellule *L) {
    if (L == NULL) {
        return NULL;
    }
    Cellule *nouvelleTete = L->suivant;
    free(L);
    return nouvelleTete;
}

Cellule *TrouverMax(Cellule *L) {
    Cellule *max = L;
    Cellule *courant = L;
    while (courant != NULL) {
        if (courant->valeur > max->valeur) {
            max = courant;
        }
        courant = courant->suivant;
    }
    return max;
}

Cellule *TriCroissant(Cellule *L) {
    if (L == NULL) {
        return NULL;
    }
    Cellule *max = TrouverMax(L);
    Cellule *nouvelleTete = InsérerTête(NULL, max->valeur);
    if (max == L) {
        L = SupprimerTête(L);
    } else {
        Cellule *précédent = L;
        while (précédent->suivant != max) {
            précédent = précédent->suivant;
        }
        précédent->suivant = max->suivant;
        free(max);
    }
    nouvelleTete->suivant = TriCroissant(L);
    return nouvelleTete;
}


void Afficher(Cellule *L) {
    while (L != NULL) {
        printf("%d ",    L->valeur);
    L = L->suivant;
}
printf("\n");
}

int main() {
    Cellule *L = Initialiser();
    int x;
    printf("Entrez une liste d'entiers terminée par -00 :\n");
    scanf("%d", &x);
    while (x != -00) {
        L = InsérerTête(L, x);
        scanf("%d", &x);
    }
    printf("Liste initiale : ");
    Afficher(L);
    L = TriCroissant(L);
    printf("Liste triee : ");
    Afficher(L);
    return 0;
}
