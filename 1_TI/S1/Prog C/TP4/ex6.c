#include<stdio.h>
void main(){
    int i,s ;
    int t[100];
    printf("Enter table size: ");
    scanf("%d",&s);
    for(i=1;i<=s;i++){
        printf("Enter @%d: ",i);
        scanf("%d",&t[i]);
    }
    for(i=s;i>0;i--){
        printf("@%d: %d\n",i,t[i]);
    }
}