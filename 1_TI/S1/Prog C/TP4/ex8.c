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

    printf("Enter X : ");
    scanf("%d",&x);
    s++;
    for (i=0;i<s;i++){
        if(x<t[i]){
            p=i-1;
        }
    }
    for(i=s-1;i>=p-1;i--){
        t[i]=t[i-1];  
    }
    t[p-1]=x;
    for(i=0;i<s;i++){
        printf("@%d: %d\n",i,t[i]);
    }
}