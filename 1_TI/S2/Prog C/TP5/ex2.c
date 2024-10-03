#include <stdio.h>

void Factorielle(int N, long *Fact) {
    int i;
    *Fact = 1;
    for(i = 2; i <= N; i++) {
        *Fact *= i;
    }
}

int main() {
    int N;
    long fact;
    printf(" *Entrez NB positif : ");
    scanf("%d", &N);
    Factorielle(N, &fact);
    printf(" -> %d! = %ld\n",N, fact);
    return 0;
}
