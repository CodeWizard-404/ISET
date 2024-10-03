#include <stdio.h>
#include <stdlib.h>

struct Cellule {
    int Val;
    struct Cellule* Suiv;
};

struct File {
    struct Cellule* tete;
    struct Cellule* queue;
};

void initFile(struct File* F) {
    F->tete = NULL;
    F->queue = NULL;
}

int fileVide(struct File* F) {
    return (F->tete == NULL);
}

void enfiler(struct File* F, int x) {
    struct Cellule* C = (struct Cellule*)malloc(sizeof(struct Cellule));
    C->Val = x;
    C->Suiv = NULL;

    if (fileVide(F)) {
        F->tete = C;
        F->queue = C;
    } else {
        F->queue->Suiv = C;
        F->queue = C;
    }
}

int defiler(struct File* F) {
    if (fileVide(F)) {
        printf("!! File est vide !!\n");
        return -1;
    }

    struct Cellule* tmp = F->tete;
    int x = tmp->Val;

    F->tete = F->tete->Suiv;
    free(tmp);

    return x;
}

void Saisir(struct File* F, int N) {
    printf("Enfiler %d Valeur :\n", N);
    for (int i = 0; i < N; i++) {
        int x;
        printf("F.^Val %d : ", i + 1);
        scanf("%d", &x);
        enfiler(F, x);
    }
}

void Copie(struct File* F1, struct File* F2) {
    struct File tmp;
    initFile(&tmp);

    while (!fileVide(F1)) {
        int x = defiler(F1);
        enfiler(&tmp, x);
    }

    initFile(F2);

    while (!fileVide(&tmp)) {
        int x = defiler(&tmp);
        enfiler(F2, x);
    }
}

void AfficherFile(struct File* F) {
    struct File tmp;
    initFile(&tmp);

    Copie(F, &tmp);

    while (!fileVide(&tmp)) {
        int x = defiler(&tmp);
        enfiler(F, x);
        printf("|%d", x);
    }
    printf("|\n");
}

void Purger(struct File* F) {
    if (fileVide(F))
        return;

    struct File tmp;
    initFile(&tmp);

    while (!fileVide(F)) {
        int x = defiler(F);

        int Re = 0;
        struct Cellule* P0 = tmp.tete;
        while (P0 != NULL) {
            if (P0->Val == x) {
                Re = 1;
                break;
            }
            P0 = P0->Suiv;
        }

        if (!Re)
            enfiler(&tmp, x);
    }

    while (!fileVide(&tmp)) {
        int x = defiler(&tmp);
        enfiler(F, x);
    }
}

int main() {
    struct File F;
    initFile(&F);

    int N;
    printf("Taille de la File : ");
    scanf("%d", &N);

    Saisir(&F, N);

    printf("\nContenu de la File F :\n");
    AfficherFile(&F);

    Purger(&F);

    printf("\nPurge de la File :\n");
    AfficherFile(&F);

    return 0;
}
