#include <stdio.h>
#include <stdlib.h>

struct Cellule
{
    char info;
    struct Cellule *suiv;
};

// Declaration du type Pile
typedef struct Cellule *Pile;

// Declaration des fonctions
void Init(Pile *P);
void Empiler(Pile *P, char e);
void Depiler(Pile *P, char *e);
int PileVide(Pile P);
void Copie(Pile *P1, Pile *P2);
void Afficher(Pile P);
char Sommet(Pile P);
void Parite_pile(Pile *P);
void Trier_pile(Pile *P);
void Saisie(Pile *P);
int Anagramme(Pile P1, Pile P2);

int main()
{
    Pile P1, P2;
    Init(&P1);
    Init(&P2);

    printf("Saisie de la premiere suite de caracteres:\n");
    Saisie(&P1);
    printf("Saisie de la deuxieme suite de caracteres:\n");
    Saisie(&P2);

    if (Anagramme(P1, P2))
        printf("Les deux suites de caracteres sont des anagrammes.\n");
    else
        printf("Les deux suites de caracteres ne sont pas des anagrammes.\n");

    return 0;
}

void Init(Pile *P)
{
    *P = NULL;
}

void Empiler(Pile *P, char e)
{
    struct Cellule *nouveau = malloc(sizeof(struct Cellule));
    if (nouveau == NULL)
    {
        printf("Erreur : impossible d'allouer de la memoire.\n");
        exit(EXIT_FAILURE);
    }

    nouveau->info = e;
    nouveau->suiv = *P;
    *P = nouveau;
}

void Depiler(Pile *P, char *e)
{
    if (PileVide(*P))
    {
        printf("Erreur : la pile est vide.\n");
        exit(EXIT_FAILURE);
    }

    struct Cellule *temp = *P;
    *e = temp->info;
    *P = temp->suiv;
    free(temp);
}

int PileVide(Pile P)
{
    return P == NULL;
}

void Copie(Pile *P1, Pile *P2)
{
    Init(P2);
    Pile temp = NULL;
    while (!PileVide(*P1))
    {
        char e;
        Depiler(P1, &e);
        Empiler(&temp, e);
    }
    while (!PileVide(temp))
    {
        char e;
        Depiler(&temp, &e);
        Empiler(P1, e);
        Empiler(P2, e);
    }
}

void Afficher(Pile P)
{
    if (PileVide(P))
    {
        printf("La pile est vide.\n");
        return;
    }

    printf("Contenu de la pile :\n");
    while (!PileVide(P))
    {
        char e;
        Depiler(&P, &e);
        printf("%c ", e);
    }
    printf("\n");
}

char Sommet(Pile P)
{
    if (PileVide(P))
    {
        printf("Erreur : la pile est vide.\n");
        exit(EXIT_FAILURE);
    }

    return P->info;
}

void Parite_pile(Pile *P)
{
    Pile temp = NULL;
    char sommet;

    while (!PileVide(*P))
    {
        Depiler(P, &sommet);
        Empiler(&temp, sommet);
    }

    while (!PileVide(temp))
    {
        Depiler(&temp, &sommet);
        if (sommet % 2 == 0)
            Empiler(P, sommet);
    }
}

void Trier_pile(Pile *P)
{
    Pile temp = NULL;

    while (!PileVide(*P))
    {
        char e = Sommet(*P);
        Depiler(P, &e);

        while (!PileVide(temp) && Sommet(temp) < e)
        {
            char temp_e = Sommet(temp);
            Depiler(&temp, &temp_e);
            Empiler(P, temp_e);
        }

        Empiler(&temp, e);
    }

    while (!PileVide(temp))
    {
        char e = Sommet(temp);
        Depiler(&temp, &e);
        Empiler(P, e);
    }
}

void Saisie(Pile *P)
{
    Init(P);
    char ch;
    scanf(" %c", &ch);

    while (ch != '#')
    {
        Empiler(P, ch);
        scanf(" %c", &ch);
    }
}

int Anagramme(Pile P1, Pile P2)
{
    if (PileVide(P1) || PileVide(P2))
        return 0;

    Pile temp1, temp2;
    Copie(&P1, &temp1);
    Copie(&P2, &temp2);

    Trier_pile(&temp1);
    Trier_pile(&temp2);

    while (!PileVide(temp1) && !PileVide(temp2))
    {
        if (Sommet(temp1) != Sommet(temp2))
            return 0;

        char e;
        Depiler(&temp1, &e);
        Depiler(&temp2, &e);
    }

    return PileVide(temp1) && PileVide(temp2);
}
