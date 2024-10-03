#include <stdio.h>
#include <stdlib.h>

typedef struct cellule {
    int val;
    struct cellule* suiv;
} *liste;

liste Initialiser(liste L) {
    L = NULL;
    return L;
}

liste InsérerTête(liste L, int valeur) {
    liste p = (liste)malloc(sizeof(struct cellule));
    p->val = valeur;
    p->suiv = L;
    return p;
}

liste InsérerFin(liste L, int valeur) {
    liste p = (liste)malloc(sizeof(struct cellule));
    p->val = valeur;
    p->suiv = NULL;
    if (L == NULL) {
        return p;
    } else {
        liste q = L;
        while (q->suiv != NULL) {
            q = q->suiv;
        }
        q->suiv = p;
        return L;
    }
}

int Taille(liste L) {
    int taille = 0;
    while (L != NULL) {
        taille++;
        L = L->suiv;
    }
    return taille;
}

void Afficher(liste L) {
    while (L != NULL) {
        printf("%d ", L->val);
        L = L->suiv;
    }
    printf("\n");
}

void Scinder(liste L1, liste* L2) {
    int taille = Taille(L1);
    int taille1 = taille / 2;
    int taille2 = taille - taille1;
    liste q = L1;
    int i = 1;
    while (i < taille1) {
        q = q->suiv;
        i++;
    }
    if (taille % 2 == 1 && taille1 == taille2) {
        q = q->suiv;
        taille2++;
    }
    *L2 = q->suiv;
    q->suiv = NULL;
}



liste createList() {
    liste L1 = NULL;
    int n, valeur;
    printf("Entrez le nombre d'elements dans la liste : ");
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        printf("Elt %d : ", i+1);
        scanf("%d", &valeur);
        L1 = InsérerFin(L1, valeur); 
    }
    return L1;
}


int main() {
    liste L1 = createList();
    printf("Liste initiale : ");
    Afficher(L1);
    liste L2;
    Scinder(L1, &L2);
    printf("Premiere sous-liste : ");
    Afficher(L1);
    printf("Deuxieme sous-liste : ");
    Afficher(L2);
    return 0;
}
