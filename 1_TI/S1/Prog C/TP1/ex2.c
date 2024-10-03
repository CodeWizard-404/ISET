#include<stdio.h>
void main(){
    int a,b;
    printf("write a: ");
    scanf("%d",&a);
    printf("write b: ");
    scanf("%d",&b);
    printf("somme= %d\n",a+b);
    if(a>b){
        printf("difference= %d\n",a-b);}
        else if (a<b){
            printf("difference= %d\n",b-a);
        }
    printf("produit= %d\n",a*b);
}