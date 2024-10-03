#include<stdio.h>
void main(){
    int a,b,c,max,min;
    printf("write a: ");
    scanf("%d",&a);
    if (a%2==0){
        printf("%d est pair",a);
    }else{
        printf("%d est impair",a);
    }
}