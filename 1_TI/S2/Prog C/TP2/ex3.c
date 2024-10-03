#include <stdio.h>
#include <string.h>

struct chanson {
    char titre[50];
    int duree;
};

struct disque {
    int annee;
    char titre[50];
    struct chanson chans[20];
    int nb_chans;
};

int main() {
    struct disque disques[10];
    int nb_disques = 0;

    // Ajouter des disques au tableau
    while (nb_disques < 2) {
        struct disque disque;

        printf("Entrez l'annee du disque : ");
        scanf("%d", &disque.annee);

        printf("Entrez le titre du disque : ");
        scanf("%s", disque.titre);

        printf("Entrez le nombre de chansons sur le disque : ");
        scanf("%d", &disque.nb_chans);

        printf("Entrez les informations sur chaque chanson :\n");
        for (int i = 0; i < disque.nb_chans; i++) {
            printf("Chanson %d :\n", i + 1);
            printf("\tTitre : ");
            scanf("%s", disque.chans[i].titre);
            printf("\tDuree : ");
            scanf("%d", &disque.chans[i].duree);
        }

        disques[nb_disques] = disque;
        nb_disques++;

        printf("Disque ajoute avec succes !\n");
        printf("\n");
    }

    // Afficher les disques dans le tableau
    printf("Voici les disques dans le tableau :\n");
    for (int i = 0; i < nb_disques; i++) {
        printf("Disque %d :\n", i + 1);
        printf("\tAnnee : %d\n", disques[i].annee);
        printf("\tTitre : %s\n", disques[i].titre);
        printf("\tNombre de chansons : %d\n", disques[i].nb_chans);
        printf("\tChansons :\n");
        for (int j = 0; j < disques[i].nb_chans; j++) {
            printf("\t\tTitre : %s\n", disques[i].chans[j].titre);
            printf("\t\tDuree : %d\n", disques[i].chans[j].duree);
        }
        printf("\n");
    }

    // Rechercher une chanson dans le tableau
    char titre_chanson[50];
    printf("Entrez le titre de la chanson à rechercher : ");
    scanf("%s", titre_chanson);

    int chanson_trouvee = 0;
    for (int i = 0; i < nb_disques; i++) {
        for (int j = 0; j < disques[i].nb_chans; j++) {
            if (strcmp(disques[i].chans[j].titre, titre_chanson) == 0) {
                printf("Chanson trouvee :\n");
                printf("\tDisque : %s\n", disques[i].titre);
                printf("\tAnnee : %d\n", disques[i].annee);
                printf("\tDuree : %d\n", disques[i].chans[j].duree);
                chanson_trouvee = 1;
                break;
            }
        }
        if (chanson_trouvee) { break; } }
if (!chanson_trouvee) {
    printf("La chanson n'a pas ete trouvee.\n");
}

return 0;
}


