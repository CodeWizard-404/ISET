#include <stdio.h>

void calcul(int *a, int *b, int *c, 
            int *sum, float *moy, 
            int *max, int *min) {
                
    // Calcul de la somme
    *sum = *a + *b + *c;
    
    // Calcul du maximum
    *max = *a;
    if (*b > *max) {
        *max = *b;
    }
    if (*c > *max) {
        *max = *c;
    }
    
    // Calcul du minimum
    *min = *a;
    if (*b < *min) {
        *min = *b;
    }
    if (*c < *min) {
        *min = *c;
    }
    
    // Calcul de la moyenne
    *moy = (float)(*sum) / 3;
}

void main() {
    int a, b, c, sum, max, min;
    float moy;
    
    printf("*Entrez trois entiers :\n");
    printf(" -Entier 1: ");
    scanf("%d",&a);
    printf(" -Entier 2: ");
    scanf("%d",&b);
    printf(" -Entier 3: ");
    scanf("%d",&c);
    
    calcul(&a, &b, &c, &sum, &moy, &max, &min);
    
    printf("\n +Somme : %d\n", sum);
    printf(" +Maximum : %d\n", max);
    printf(" +Minimum : %d\n", min);
    printf(" +Moyenne : %.2f\n", moy);
}
