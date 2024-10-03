#include<stdio.h>
void main(){
    int n,u,d,c,s;
    do{
        printf("write the nb: ");
        scanf("%d",&n);
    }while((n>1000)&&(n<99));
    u=n%10;
    d=(n/10)%10;
    c=n/100;
    s=u*100+d*10+c;
    printf("%d",s);
}