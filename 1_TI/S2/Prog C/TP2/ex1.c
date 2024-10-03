#include <stdio.h>
#include <string.h>

struct Ordinateur
{
    char num_serie[20];
    char type_processeur[20];
    float vitesse_processeur;
    int taille_memoire;
};

int main()
{
    struct Ordinateur ordinateur1, ordinateur2;

    // saisie des caracteristiques de l'ordinateur 1
    printf("\n\033[36m======================================================================================\033[0m\n");
    printf("\033[34m*Saisir les caracteristiques de l'ordinateur 1 :\033[0m\n");
    printf(" -Numero de serie : ");
    scanf("%s", ordinateur1.num_serie);
    printf(" -Type du processeur : ");
    scanf("%s", ordinateur1.type_processeur);
    printf(" -Vitesse du processeur (en GHz) : ");
    scanf("%f", &ordinateur1.vitesse_processeur);
    printf(" -Taille de la memoire (en Go) : ");
    scanf("%d", &ordinateur1.taille_memoire);

    // saisie des caracteristiques de l'ordinateur 2
    printf("\n\033[36m======================================================================================\033[0m\n");
    printf("\033[34m*Saisir les caracteristiques de l'ordinateur 2 :\033[0m\n");
    printf(" -Numero de serie : ");
    scanf("%s", ordinateur2.num_serie);
    printf(" -Type du processeur : ");
    scanf("%s", ordinateur2.type_processeur);
    printf(" -Vitesse du processeur (en GHz) : ");
    scanf("%f", &ordinateur2.vitesse_processeur);
    printf(" -Taille de la memoire (en Go) : ");
    scanf("%d", &ordinateur2.taille_memoire);

    // comparaison des vitesses de processeur
    if (ordinateur1.vitesse_processeur > ordinateur2.vitesse_processeur)
    {
        printf("\n\033[36m======================================================================================\033[0m\n");
        printf("\033[34m*L'ordinateur 1 est plus rapide que l'ordinateur 2 :\033[0m\n");
        printf(" -Numero de serie : %s\n", ordinateur1.num_serie);
        printf(" -Type du processeur : %s\n", ordinateur1.type_processeur);
        printf(" -Vitesse du processeur : %.2f GHz\n", ordinateur1.vitesse_processeur);
        printf(" -Taille de la memoire : %d Go\n", ordinateur1.taille_memoire);
    }
    else if (ordinateur2.vitesse_processeur > ordinateur1.vitesse_processeur)
    {
        printf("\n\033[36m======================================================================================\033[0m\n");
        printf("\033[34m*L'ordinateur 2 est plus rapide que l'ordinateur 1 :\033[0m\n");
        printf("Numero de serie : %s\n", ordinateur2.num_serie);
        printf("Type du processeur : %s\n", ordinateur2.type_processeur);
        printf("Vitesse du processeur : %.2f GHz\n", ordinateur2.vitesse_processeur);
        printf("Taille de la memoire : %d Go\n", ordinateur2.taille_memoire);
    }
    else
    {
        printf("\n\033[36m======================================================================================\033[0m\n");
        printf("\033[34mLes deux ordinateurs ont la même vitesse de processeur :\033[0m %.2f GHz\n",
               ordinateur1.vitesse_processeur);
    }

    return 0;
}
