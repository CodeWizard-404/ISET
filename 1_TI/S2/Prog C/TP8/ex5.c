#include <stdio.h>
#include <stdlib.h>

struct Cellule
{
    int Val;
    struct Cellule *Suiv;
};

struct Pile
{
    struct Cellule *Sommet;
};

void initPile(struct Pile *P)
{
    P->Sommet = NULL;
}

int PileVide(struct Pile *P)
{
    return (P->Sommet == NULL);
}

void empiler(struct Pile *P, int x)
{
    struct Cellule *C = (struct Cellule *)malloc(sizeof(struct Cellule));
    C->Val = x;
    C->Suiv = P->Sommet;
    P->Sommet = C;
}

int depiler(struct Pile *P)
{
    if (PileVide(P))
    {
        printf("!! Pile est vide !!\n");
        return -1;
    }

    struct Cellule *tmp = P->Sommet;
    int x = tmp->Val;

    P->Sommet = P->Sommet->Suiv;
    free(tmp);

    return x;
}

void Saisir(struct Pile *P, int N)
{
    printf("Empiler %d Valeur :\n", N);
    for (int i = 0; i < N; i++)
    {
        int x;
        printf("P.^Val %d : ", i + 1);
        scanf("%d", &x);
        empiler(P, x);
    }
}

void Copie(struct Pile *P1, struct Pile *P2)
{
    struct Pile r;
    initPile(&r);
    struct Pile P3 = *P1;

    while (!PileVide(&P3))
    {
        empiler(&r, P3.Sommet->Val);
        depiler(&P3);
    }

    initPile(P2);

    while (!PileVide(&r))
    {
        empiler(P2, r.Sommet->Val);
        depiler(&r);
    }
}

void AfficherPile(struct Pile *P)
{
    struct Pile P2;
    initPile(&P2);
    struct Pile Tmp;
    initPile(&Tmp);

    Copie(P, &P2);

    while (!PileVide(&P2))
    {
        int e = depiler(&P2);
        empiler(&Tmp, e);
        printf("|%d|\n", e);
        printf(" --\n");
    }

    while (!PileVide(&Tmp))
    {
        int e = depiler(&Tmp);
        empiler(&P2, e);
    }
}

void Purger(struct Pile *P)
{
    if (PileVide(P))
        return;

    struct Pile PP;
    initPile(&PP);

    while (!PileVide(P))
    {
        int x = depiler(P);

        int Re = 0;
        struct Cellule *P0 = PP.Sommet;
        while (P0 != NULL)
        {
            if (P0->Val == x)
            {
                Re = 1;
                break;
            }
            P0 = P0->Suiv;
        }

        if (!Re)
            empiler(&PP, x);
    }

    while (!PileVide(&PP))
    {
        int x = depiler(&PP);
        empiler(P, x);
    }
}

void main()
{
    struct Pile P;
    initPile(&P);

    int N;
    printf("Taille de la Pile : ");
    scanf("%d", &N);

    Saisir(&P, N);

    printf("\nContenu de la Pile P :\n");
    AfficherPile(&P);

    Purger(&P);

    printf("\nPurge de la Pile :\n");
    AfficherPile(&P);
}
