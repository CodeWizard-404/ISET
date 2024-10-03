#include <stdio.h>
void main(){
    int i,j,s,c;
    int t[100];
    printf("Enter table size: ");
    scanf("%d",&s);
    for (i=0;i<s;i++){
        printf("Enter @%d: ", i);
        scanf("%d",&t[i]);
    }
    for (i=0;i<s;i++){
        for (j=0;j<s;j++){
            if (t[j]>t[i]){
                c=t[i];
                t[i]=t[j];
                t[j]=c;
            }
        }
    }
    for(i=0;i<s;i++){
        printf("@%d: %d\n",i,t[i]);
    }
}

