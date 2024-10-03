#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <unistd.h>

struct cellule
{
    int info;
    struct cellule *suiv;
};

typedef struct cellule *Liste;

void AjoutTete(Liste *L, int e);
void AjoutQueue(Liste *L, int e);
void Creer(Liste *L);
void Affiche(Liste L);
Liste AccessPos(Liste L, int k);
void AjoutPos(Liste *L, int e, int k);
int Occurence(Liste L, int e);
void SuppTete(Liste *L);
void SuppQueue(Liste *L);
void SuppPos(Liste *L, int k);
void SuppVal(Liste *L, int x);

int main()
{
    Liste L;
    int x, nb, choix, val, pos;

    do
    {
        printf("\n===============================\n");
        printf("01. \033[0;31mCreer\033[0m \tla liste\n");
        printf("02. \033[0;31mAfficher\033[0m \tla liste\n");
        printf("03. \033[0;34mAjouter\033[0m \tune Tete\n");
        printf("04. \033[0;34mAjouter\033[0m \tune Queue\n");
        printf("05. \033[0;34mAjouter\033[0m \ta une Position\n");
        printf("06. \033[0;32mNombre\033[0m \td'occurrences\n");
        printf("07. \033[0;33mSupprimer\033[0m \tla Tete\n");
        printf("08. \033[0;33mSupprimer\033[0m \tle Queue\n");
        printf("09. \033[0;33mSupprimer\033[0m \ta une position\n");
        printf("10. \033[0;33mSupprimer\033[0m \tun valeur\n");
        printf("11. \033[0;31mQuitter\033[0m\n");
        printf("===============================\n");
        printf("Entrer votre choix : ");
        scanf("%d", &choix);

        switch (choix)
        {
        case 1:
            printf("Donner les elements de la liste :\n");
            Creer(&L);
            break;

        case 2:

            printf("Les elements de la liste sont :\n");
            Affiche(L);
            sleep(5);

            break;
        case 3:
            printf("donner un entier : ");
            scanf("%d", &x);
            AjoutTete(&L, x);
            break;
        case 4:
            printf("donner un entier : ");
            scanf("%d", &x);
            AjoutQueue(&L, x);
            break;
        case 5:
            printf("donner un entier : ");
            scanf("%d", &x);
            printf("donner une position : ");
            scanf("%d", &pos);
            AjoutPos(&L, x, pos);
            break;
        case 6:
            printf("donner un entier : ");
            scanf("%d", &x);
            nb = Occurence(L, x);
            printf("Le nombre d'occurences est %d \n", nb);
            sleep(5);
            break;
        case 7:
            SuppTete(&L);
            break;
        case 8:
            SuppQueue(&L);
            break;
        case 9:
            printf("donner une position : ");
            scanf("%d", &pos);
            SuppPos(&L, pos);
            break;
        case 10:
            printf("donner une valeur : ");
            scanf("%d", &val);
            SuppVal(&L, val);
            break;
        case 11:
            break;
        default:
            printf("Choix non valide !!!! \n");
            sleep(5);
        }
        printf("\033[2J");
        printf("\033[H");

    } while (choix != 11);
    getch();
}

void AjoutTete(Liste *L, int e)
{
    Liste p;
    p = malloc(sizeof(struct cellule));
    p->info = e;
    p->suiv = *L;
    *L = p;
}

void AjoutQueue(Liste *L, int e)
{
    Liste p, q;
    if (*L == 0)
    {
        AjoutTete(L, e);
    }
    else
    {
        p = *L;
        while (p->suiv)
            p = p->suiv;

        q = malloc(sizeof(struct cellule));
        q->info = e;
        q->suiv = 0;
        p->suiv = q;
    }
}

void Creer(Liste *L)
{
    int x, choix;
    do
    {
        printf("Donner un element : ");
        scanf("%d", &x);
        AjoutQueue(L, x);
        printf("Voulez vous ajouter un element  (0/1) : ");
        scanf("%d", &choix);
    } while (choix);
}

void Affiche(Liste L)
{
    Liste p = L;
    if (p == 0)
    {
        printf("La liste est vide.\n");
        return;
    }
    else
    {
        printf("\n Les elements de la liste sont : \n\n \t");
        while (p)
        {
            printf("%d ==> ", p->info);
            p = p->suiv;
        }
        printf("*Fin*\n \n");
    }
}



Liste AccessPos(Liste L, int k)
{
    Liste p = L;
    int i = 1;
    while ((p != NULL) && (i < k))
    {
        p = p->suiv;
        i++;
    }
    if (p == NULL)
    {
        printf("Erreur: Position invalide!\n");
        return NULL;
    }
    else
    {
        return p;
    }
}

void AjoutPos(Liste *L, int e, int k)
{
    Liste p, q;

    if (k == 1)
    {
        AjoutTete(L, e);
    }
    else
    {
        p = AccessPos(*L, k - 1);
        if (p == NULL)
        {
            printf("Impossible d'ajouter a la position %d.\nErreur: Position invalide!\n", k);
        }
        else
        {
            q = malloc(sizeof(struct cellule));
            q->info = e;
            q->suiv = p->suiv;
            p->suiv = q;
        }
    }
}

int Occurence(Liste L, int e)
{
    int nb = 0;
    Liste p = L;
    while (p != NULL)
    {
        if (p->info == e)
        {
            nb++;
        }
        p = p->suiv;
    }
    return nb;
}

void SuppTete(Liste *L)
{
    Liste p = *L;
    if (p != 0)
    {
        *L = p->suiv;
        free(p);
    }
}

void SuppQueue(Liste *L)
{
    Liste p = *L, q = NULL;

    if (p == NULL)
    {
        printf("La liste est vide\n");
        return;
    }

    if (p->suiv == NULL)
    {
        free(p);
        *L = NULL;
        return;
    }

    while (p->suiv != NULL)
    {
        q = p;
        p = p->suiv;
    }

    free(p);
    q->suiv = NULL;
}

void SuppPos(Liste *L, int k)
{
    if (*L == NULL)
    {
        printf("Liste vide.\n");
        return;
    }

    if (k == 1)
    {
        SuppTete(L);
        return;
    }

    Liste p = AccessPos(*L, k - 1);

    if (p == NULL || p->suiv == NULL)
    {
        printf("Position invalide.\n");
        return;
    }

    Liste q = p->suiv;
    p->suiv = q->suiv;
    free(q);
}
void SuppVal(Liste *L, int x)
{
    Liste p = *L, q = 0;
    while (p && p->info != x)
    {
        q = p;
        p = p->suiv;
    }
    if (p)
    {
        if (q)
            q->suiv = p->suiv;
        else
            *L = p->suiv;
        free(p);
    }
}
