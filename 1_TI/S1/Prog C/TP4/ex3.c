#include<stdio.h>
void main(){
    int t[100];
    int s,i,so;
    printf("Enter table size: ");
    scanf("%d",&s);
    so=0;
    for(i=0;i<s;i++){
        printf("Enter @%d: ",i);
        scanf("%d",&t[i]);
        so=so+t[i];
    }
    printf("somme : %d",so);
}