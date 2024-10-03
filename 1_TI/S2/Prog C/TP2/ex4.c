#include <stdio.h>
#include <string.h>

// Structure d'un etudiant
struct Etudiant
{
    char nom[50];
    float note_ds;
    float note_exam;
    float moyenne;
};

// Fonction pour saisir les informations des etudiants
void saisir_etudiants(struct Etudiant etudiants[], int n)
{
    printf("Saisie les notes de %d etudiants :\n", n);
    for (int i = 0; i < n; i++)
    {
        printf("\nEtudiant %d :\n", i + 1);
        printf("Nom :\t ");
        scanf("%s", etudiants[i].nom);
        printf("Note DS :\t ");
        scanf("%f", &etudiants[i].note_ds);
        printf("Note examen :\t ");
        scanf("%f", &etudiants[i].note_exam);
    }
}

// Fonction pour calculer la moyenne de chaque etudiant
void calculer_moyennes_etudiants(struct Etudiant etudiants[], int n)
{
    for (int i = 0; i < n; i++)
    {
        etudiants[i].moyenne = (etudiants[i].note_ds + etudiants[i].note_exam) / 2;
    }
}

// Fonction pour calculer la moyenne de la classe
float calculer_moyenne_classe(struct Etudiant etudiants[], int n)
{
    float somme = 0.0;
    for (int i = 0; i < n; i++)
    {
        somme += etudiants[i].moyenne;
    }
    return somme / n;
}

// Fonction pour afficher les resultats de la classe
void afficher_resultats_classe(struct Etudiant etudiants[], int n)
{
    printf("\nResultats de la classe :\n\n");
    printf("%-20s %-10s %-15s\n", "Nom:", "Moyenne;", "Observation:");
    for (int i = 0; i < n; i++)
    {
        char observation[20];
        if (etudiants[i].moyenne < 8.0)
        {
            strcpy(observation, "Faible");
        }
        else if (etudiants[i].moyenne < 10.0)
        {
            strcpy(observation, "Passable");
        }
        else if (etudiants[i].moyenne < 13.0)
        {
            strcpy(observation, "Bien");
        }
        else
        {
            strcpy(observation, "Tres bien");
        }
        printf("%-20s %-10.2f %-15s\n", etudiants[i].nom, etudiants[i].moyenne, observation);
    }
}

// Fonction pour afficher les resultats d'un etudiant en particulier
void afficher_resultats_etudiant(struct Etudiant etudiants[], int n)
{
    char nom[50];
    int test = 0;
    do
    {

        printf("\nNom de l'etudiant : ");
        scanf("%s", nom);
        for (int i = 0; i < n; i++)
        {
            if (strcmp(etudiants[i].nom, nom) == 0)
            {
                test = 1;
                printf("\nResultats de %s :\n\n", nom);
                printf("DS : \t%.2f\n", etudiants[i].note_exam);
                printf("Examen : \t%.2f\n", etudiants[i].note_ds);
                printf("Moyenne : \t%.2f\n", etudiants[i].moyenne);
                if (etudiants[i].moyenne < 10.0)
                {
                    printf("Observation : \tFaible\n");
                }
                else if (etudiants[i].moyenne < 12.0)
                {
                    printf("Observation : \tPassable\n");
                }
                else if (etudiants[i].moyenne < 15.0)
                {
                    printf("Observation : \tBien\n");
                }
                else
                {
                    printf("Observation : \tTres bien\n");
                }
            }
        }
        if (test == 0)
        {
            printf("\nEtudiant introuvable.\n");
        }
    } while (test == 0);
}
// Fonction main
int main()
{
    struct Etudiant etudiants[30];
    int n;
    int choix;
    printf("\n");
    printf("\033[33mMenu :\n");
    printf("1 - Saisir la liste des etudiants - DS - Examen\n");
    printf("2 - Calculer moyenne\n");
    printf("3 - Calculer la moyenne de la classe\n");
    printf("4 - Afficher Resultat d'un Etudiant\n");
    printf("5 - Resultat de la classe.\n");
    printf("6 - Quitter\033[0m\n");
    printf("\033[36m======================================================================================\033[0m\n");
    do
    {

        printf("\n\033[31mDonnez votre choix => \033[0m");
        scanf("%d", &choix);

        switch (choix)
        {
        case 1:
            printf("\033[36m======================================================================================\033[0m\n");
            printf("\033[34mNombre d'etudiants : \033[0m");
            scanf("%d", &n);
            printf("\033[36m======================================================================================\033[0m\n");
            saisir_etudiants(etudiants, n);
            printf("\033[36m======================================================================================\033[0m\n");
            break;
        case 2:
            calculer_moyennes_etudiants(etudiants, n);
            printf("\033[36m======================================================================================\033[0m\n");
            printf("\033[34mMoyennes calculees pour tous les etudiants.\033[0m\n");
            printf("\033[36m======================================================================================\033[0m\n");
            break;
        case 3:
            printf("\033[36m======================================================================================\033[0m\n");
            printf("\033[34mMoyenne de la classe : \033[0m%.2f\n", calculer_moyenne_classe(etudiants, n));
            printf("\033[36m======================================================================================\033[0m\n");
            break;
        case 4:
            printf("\033[36m======================================================================================\033[0m\n");
            afficher_resultats_etudiant(etudiants, n);
            printf("\033[36m======================================================================================\033[0m\n");
            break;
        case 5:
            printf("\033[36m======================================================================================\033[0m\n");
            afficher_resultats_classe(etudiants, n);
            printf("\033[36m======================================================================================\033[0m\n");
            break;
        case 6:
            printf("\n\n\033[32m======================================================================================\033[0m\n\n");
            printf("\t\t\t\033[1;32m*Thank You for using my Program*\n");
            printf("\t\t\t================================\033[0m\n\n\n");
            break;
        default:
            printf("\033[31m\n\tERROR.\033[0m\n");
            break;
        }
    } while (choix != 6);
    return 0;
}