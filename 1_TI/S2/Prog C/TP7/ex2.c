#include <stdio.h>
#include <stdlib.h>

typedef struct Cellule Cellule;
struct Cellule {
    int valeur;
    Cellule* suivant;
};

void Initialiser(Cellule** liste) {
    *liste = NULL;
}

void InsérerTête(Cellule** liste, int valeur) {
    Cellule* nouvelleCellule = (Cellule*) malloc(sizeof(Cellule));
    nouvelleCellule->valeur = valeur;
    nouvelleCellule->suivant = *liste;
    *liste = nouvelleCellule;
}

void InsérerQueue(Cellule** liste, int valeur) {
    Cellule* nouvelleCellule = (Cellule*) malloc(sizeof(Cellule));
    nouvelleCellule->valeur = valeur;
    nouvelleCellule->suivant = NULL;
    if (*liste == NULL) {
        *liste = nouvelleCellule;
    } else {
        Cellule* derniereCellule = *liste;
        while (derniereCellule->suivant != NULL) {
            derniereCellule = derniereCellule->suivant;
        }
        derniereCellule->suivant = nouvelleCellule;
    }
}

void Afficher(Cellule* liste) {
    while (liste != NULL) {
        printf("%d -> ", liste->valeur);
        liste = liste->suivant;
    }
    printf("null\n");
}



Cellule* COMPRESSER(Cellule* L) {
    Cellule* Lcomp = NULL;
    if (L == NULL) {
        return Lcomp;
    }
    int valeur = L->valeur;
    InsérerTête(&Lcomp, valeur);
    int compteur = 1;
    L = L->suivant;
    while (L != NULL) {
        if (L->valeur == valeur) {
            compteur++;
        } else {
            InsérerQueue(&Lcomp, compteur);
            valeur = L->valeur;
            compteur = 1;
        }
        L = L->suivant;
    }
    InsérerQueue(&Lcomp, compteur);
    
    return Lcomp;
}






Cellule* DECOMPRESSER(Cellule* Lcomp) {
    Cellule* Ldécompressée = NULL;
    if (Lcomp == NULL) {
        return Ldécompressée;
    }
    int valeur = Lcomp->valeur;
    Lcomp = Lcomp->suivant;
    while (Lcomp != NULL) {
        int compteur = Lcomp->valeur;
        for (int i = 0; i < compteur; i++) {
            InsérerQueue(&Ldécompressée, valeur);
        }
        Lcomp = Lcomp->suivant;
        if (Lcomp != NULL) {
            valeur = !valeur;
        }
    }
    return Ldécompressée;
}








int main() {
    Cellule* L = NULL;
    Cellule* Lcomp = NULL;
    int n;
    printf("Entrez une suite binaire (0 et 1 uniquement) : ");
    while (scanf("%1d", &n) == 1) {
        InsérerQueue(&L, n);
    }
    printf("La liste L : ");
    Afficher(L);
    Lcomp = COMPRESSER(L);
    printf("La liste compressee Lcomp : ");
    Afficher(Lcomp);
    L = DECOMPRESSER(Lcomp);
    printf("La liste décompressee L : ");
    Afficher(L);
    return 0;
}

