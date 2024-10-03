#include<stdio.h>
void main(){
    int t[100];
    int s,i,j,x,nbx,pdx,ppx;
    printf("Enter table size: ");
    scanf("%d",&s);
    printf("");
    for(i=0;i<s;i++){
        printf("Enter @%d: ",i);
        scanf("%d",&t[i]);
    }
    printf("Enter the X:");
    scanf("%d",&x);
    nbx=0;
    for(i=0;i<s;i++){
        if(x==t[i]){
            nbx=nbx+1;
            pdx=i;
        }
    }
    j=1;
    ppx=0;
    do{
        ppx=j;
        j++;
    }while((j!=x)&&(j!=s));
    printf("NB of apperences of X : %d\n",nbx);
    printf("1st apperence of X : %d\n",ppx);
    printf("last apperence of X : %d\n",pdx);

    
}