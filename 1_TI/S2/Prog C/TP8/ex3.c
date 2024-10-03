#include <stdio.h>
#include <stdlib.h>

struct Cellule {
    char info;
    struct Cellule* suiv;
};

typedef struct Cellule* Pile;

void Init(Pile* P) {
    *P = NULL;
}

void Empiler(Pile* P, char e) {
    struct Cellule* cellule = (struct Cellule*)malloc(sizeof(struct Cellule));
    cellule->info = e;
    cellule->suiv = *P;
    *P = cellule;
}

char Depiler(Pile* P) {
    if (*P != NULL) {
        struct Cellule* temp = *P;
        char e = temp->info;
        *P = (*P)->suiv;
        free(temp);
        return e;
    }
    return '\0';
}

int PileVide(Pile P) {
    return (P == NULL);
}

struct CelluleFile {
    char caractere;
    struct CelluleFile* suivant;
};

typedef struct CelluleFile* File;

void initFile(File* file) {
    *file = NULL;
}

int estVideFile(File file) {
    return (file == NULL);
}

void enfiler(File* file, char caractere) {
    struct CelluleFile* cellule = (struct CelluleFile*)malloc(sizeof(struct CelluleFile));
    cellule->caractere = caractere;
    cellule->suivant = NULL;

    if (*file == NULL) {
        *file = cellule;
    } else {
        struct CelluleFile* f1 = *file;
        while (f1->suivant != NULL) {
            f1 = f1->suivant;
        }
        f1->suivant = cellule;
    }
}

char defiler(File* file) {
    if (*file != NULL) {
        struct CelluleFile* temp = *file;
        char caractere = temp->caractere;
        *file = (*file)->suivant;
        free(temp);
        return caractere;
    }
    return '\0';
}

void LIRELIGNE(Pile* P) {
    char c;
    Init(P);

    while ((c = getchar()) != '$') {
        if (c == '#') {
            char temp;
            temp = Depiler(P);
        } else if (c != '%') {
            Empiler(P, c);
        }
    }
}

void CONVERTIRLIGNE(Pile* pile) {
    File file;
    initFile(&file);
    while (!PileVide(*pile)) {
        char caractere = Depiler(pile);
        enfiler(&file, caractere);
    }
    while (!estVideFile(file)) {
        char caractere = defiler(&file);
        Empiler(pile, caractere);
    }
}

void ECRIRELIGNE(Pile pile) {
    struct Cellule* f1 = pile;
    while (f1 != NULL) {
        printf("%c", f1->info);
        f1 = f1->suiv;
    }
    printf("\n");
}

int main() {
    Pile ligne;
    LIRELIGNE(&ligne);

    printf("Ligne initiale: ");
    ECRIRELIGNE(ligne);

    CONVERTIRLIGNE(&ligne);

    printf("Ligne convertie: ");
    ECRIRELIGNE(ligne);

    return 0;
}
