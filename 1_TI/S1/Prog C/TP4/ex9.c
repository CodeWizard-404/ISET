#include<stdio.h>
void main(){
    int i,j,s,c,p,z,x;
    int t[100];
    printf("Enter table size: ");
    scanf("%d",&s);
    for (i=0;i<s;i++){
        printf("Enter @%d: ", i);
        scanf("%d",&t[i]);
    }
    printf("Enter X to sup : ");
    scanf("%d",&x);
    for (i=0;i<s;i++){
        if(x=t[i]){
            p=i;
        }
    }
    s--;
    for(i=p-1;i<s;i++){
        t[i]=t[i+1];
    }
    for(i=0;i<s;i++){
        printf("@%d: %d\n",i,t[i]);
    }
}