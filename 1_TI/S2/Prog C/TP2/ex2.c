#include <stdio.h>

// Structure pour representer un nombre complexe
struct complexe
{
    float re; // partie reelle
    float im; // partie imaginaire
};

// Fonction pour saisir un nombre complexe
struct complexe saisirComplexe()
{
    struct complexe cplx;
    printf(" -Entrez la partie reelle: ");
    scanf("%f", &cplx.re);
    printf(" -Entrez la partie imaginaire: ");
    scanf("%f", &cplx.im);
    return cplx;
}

// Fonction pour afficher un nombre complexe
void afficherComplexe(struct complexe cplx)
{
    printf("%.2f + %.2fi\n", cplx.re, cplx.im);
}

// Fonction pour ajouter deux nombres complexes et retourner le resultat
struct complexe additionnerComplexes(struct complexe cplx1, struct complexe cplx2)
{
    struct complexe resultat;
    resultat.re = cplx1.re + cplx2.re;
    resultat.im = cplx1.im + cplx2.im;
    return resultat;
}

int main()
{
    int n;
    printf("\033[34m*Entrez le nombre de nombres complexes :\033[0m ");
    scanf("%d", &n);


    // Allouer de l'espace pour le tableau de complexes
    struct complexe tabcomplexes[n];

    // Saisir les nombres complexes
    
    for (int i = 0; i < n; i++)
    {
        printf("\n\033[36m======================================================================================\033[0m\n");
        printf("+Entrez le nombre complexe %d:\n", i + 1);
        tabcomplexes[i] = saisirComplexe();
    }

    // Calculer la somme des nombres complexes
    struct complexe somme = {0, 0}; // Initialiser la somme à 0+0i
    for (int i = 0; i < n; i++)
    {
        somme = additionnerComplexes(somme, tabcomplexes[i]);
    }

    // Afficher la somme
    printf("\n\033[36m======================================================================================\033[0m\n");
    printf("\033[34m*La somme des nombres complexes est: \033[0m");
    afficherComplexe(somme);

    return 0;
}



