#include <stdio.h>

// Definition de la structure Date
struct Date
{
    int jour;
    int mois;
    int annee;
};

// Definition de la structure Prelevement
struct Prelevement
{
    struct Date date;
    int Tmax;
    int Tmin;
};

int main()
{
    // Declaration des variables p1 et p2 de type Prelevement et affectation des champs
    struct Prelevement p1 = {{5, 1, 2005}, 14, 8};
    struct Prelevement p2 = {{28, 4, 2005}, 28, 24};

    // Declaration du tableau Tab qui contiendra 12 prelevements
    struct Prelevement Tab[12];

    // Remplissage des dates des 12 prelevements
    for (int i = 0; i < 12; i++)
    {
        Tab[i].date.jour = 1;
        Tab[i].date.mois = i + 1;
        Tab[i].date.annee = 2004;
    }

    // Lecture des Tmax et Tmin des 12 prelevements
    for (int i = 0; i < 12; i++)
    {
        printf("\033[36m======================================================================================\033[0m\n");
        printf("*Prelevement %d :\n", i + 1);
        printf(" -Tmax : ");
        scanf("%d", &Tab[i].Tmax);
        printf(" -Tmin : ");
        scanf("%d", &Tab[i].Tmin);
    }

    // Recherche du prelevement correspondant à la temperature minimale de l'annee 2004
    int min = Tab[0].Tmin;
    int Imin = 0;
    for (int i = 1; i < 12; i++)
    {
        if (Tab[i].date.annee == 2004 && Tab[i].Tmin < min)
        {
            min = Tab[i].Tmin;
            Imin = i;
        }
    }

    // Affichage des champs du prelevement correspondant à la temperature minimale de l'annee 2004
    printf("\n\033[34m======================================================================================\033[0m");
    printf("\033[34m\n*Le prelevement correspondant a la temperature minimale de l'annee 2004 est :\033[0m\n\n");
    printf("Date : %d/%d/%d\n", Tab[Imin].date.jour, Tab[Imin].date.mois, Tab[Imin].date.annee);
    printf("Tmax : %d\n", Tab[Imin].Tmax);
    printf("Tmin : %d\n", Tab[Imin].Tmin);

    // Calcul et affichage de la temperature maximale moyenne
    int sommeTmax = 0;
    for (int i = 0; i < 12; i++)
    {
        sommeTmax += Tab[i].Tmax;
    }
    float Tmax_moyenne = sommeTmax / 12.0;
    printf("\n\033[34m======================================================================================\033[0m");
    printf("\033[34m\n*La temperature maximale moyenne est :\033[0m %.2f\n", Tmax_moyenne);

    return 0;
}