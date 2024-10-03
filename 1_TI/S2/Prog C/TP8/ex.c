#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

struct Cellule
{
    int info;
    struct Cellule *suiv;
};

// Déclaration du type Pile
typedef struct Cellule *Pile;

// Déclaration des fonctions
void Init(Pile *P);
void Empiler(Pile *P, int e);
void Depiler(Pile *P, int *e);
int PileVide(Pile P);
void Copie(Pile *P1, Pile *P2);
void Afficher(Pile P);

// Programme principal
void main()
{
    Pile P = NULL;
    Pile P1 = NULL;
    int x, choix;

    do
    {
        system("cls");
        printf("\t 1 - Initialiser la pile\n");
        printf("\t 2 - Empiler un element\n");
        printf("\t 3 - Depiler un element\n");
        printf("\t 4 - Tester si la pile est vide ou non\n");
        printf("\t 5 - Afficher\n");
        printf("\t 6 - Copier\n");
        printf("\t 7 - Quitter\n\n");
        printf("\033[0;31mEntrer votre choix: \033[0m");
        scanf("%d", &choix);
        printf("\n\n");

        switch (choix)
        {
        case 1:
            Init(&P);
            printf("Pile initialisee\n");
            break;
        case 2:
            printf("Entrer Elt a empiler: ");
            scanf("%d", &x);
            Empiler(&P, x);
            printf("Elt \033[0;31m%d\033[0m Empiler.\n", x);
            break;
        case 3:
            if (!PileVide(P))
            {
                int VD;
                Depiler(&P, &VD);
                printf("Elt \033[0;31m%d\033[0m Depiler.\n", VD);
            }
            else
            {
                printf("Pile est vide.\n");
            }
            break;
        case 4:
            if (PileVide(P))
            {
                printf("Pile est vide.\n");
            }
            else
            {
                printf("Pile n'est pas vide.\n");
            }
            break;
        case 5:
            printf("Contenu de la pile:\n");
            Afficher(P);
            break;
        case 6:
            printf("Copier P1 dans P2:\n");
            Copie(P, P1);
            break;
        case 7:
            break;
        default:
            printf("Entrer un choix valide !!!!!\n");
            break;
        }

        getch();

    } while (choix != 7);
}

// Définition des fonctions
void Init(Pile *P)
{
    *P = NULL;
}

void Empiler(Pile *P, int e) {
    Pile q = (Pile)malloc(sizeof(struct Cellule));
    q->info = e;
    q->suiv = *P;
    *P = q;
}

void Depiler(Pile *P, int *e) {
    if (!PileVide(*P)) {
        Pile q = *P;
        *e = q->info;
        *P = q->suiv;
        free(q);
    }
}

int PileVide(Pile P) {
    return (P == NULL);
}

void Copie(Pile *P1, Pile *P2) {
    Pile r = NULL;
    Pile P3 = *P1;
    int e;
    while (!PileVide(P3)) {
        Empiler(&r, P3->info);
        Depiler(&P3, &e);
    }

    *P2 = NULL;

    while (!PileVide(r)) {
        Empiler(P2, r->info);
        Depiler(&r, &e);
    }
}


void Afficher(Pile P)
{

    Pile P2 = NULL;
    Copie(&P, &P2);
    while (!PileVide(P2))
    {
        int e;
        Depiler(&P2, &e);
        printf("|%d|\n", e);
        printf(" --\n");
    }
}
