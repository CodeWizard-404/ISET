#include<stdio.h>

void main(){
    int n,i,j,k=0;
    printf("write n: ");
    scanf("%d",&n);
    for(i=1;i<=n;i++){
        for (j=1;j<=n-i;j++){
            printf(" ");
        }
        for(k=1;k<=(2*i-1);k++) {
            printf("*");
        }
    printf("\n");
    }
}