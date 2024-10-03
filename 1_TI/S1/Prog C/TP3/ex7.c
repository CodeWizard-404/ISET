#include<stdio.h>
void main(){
    int u,c,i;
    for(i=10;i<=100;i++){
        u=i%10;
        c=i/10;
        if(u+c==11){
            printf("somme %d= 11\n",i);
        }
    }
}
