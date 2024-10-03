#include<stdio.h>
void main()
{
    int i,nb,n,s;
    printf("how many nb : ");
    scanf("%d",&nb);
    s=0;
    for(i=1;i<=nb;i++){
        printf("nb %d : ",i);
        scanf("%d",&n);
        if(n>0){
            s=s+n;
        }
    }
    printf("Somme= %d",s);  
}