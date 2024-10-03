#include<stdio.h>
void main(){
    int n,p;
    do{
        n=1;
        if((n>=0)&&(n%3==0)){
            printf("%d",n);
            p=p+1;
        }
        n=n+1;
    }while(p<10);
}