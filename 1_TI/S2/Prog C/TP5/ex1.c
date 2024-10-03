#include <stdio.h>

void Moy(int N, float *Moy) {
    int n,i=0;
    float s = 0;

    for(i = 0; i < N; i++) {
        printf(" +[%d] : ",i++);
        scanf("%d", &n);
        s += n;
    }

    *Moy = s / (float)N;
}

int main() {
    int N;
    float moy;

    printf("*Entrez le NB des Entier: ");
    scanf("%d", &N);

    Moy(N, &moy);

    printf("\n -La moyenne est : %.2f\n", moy);

    return 0;
}
