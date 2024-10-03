#include<stdio.h>
void main(){
    int t[100];
    int s,i;
    printf("Enter table size: ");
    scanf("%d",&s);
    for(i=0;i<s;i++){
        printf("Enter @%d: ",i);
        scanf("%d",&t[i]);
    }
    for(i=0;i<s;i++){
        printf("pairs :");
        if(t[i]%2==0){
            printf("%d\n",t[i]);
        }else{
            printf("none is pair");
        }
    }
    
}
