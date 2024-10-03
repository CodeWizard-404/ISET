#include<stdio.h>
void main(){
    int a;
    printf("write a: ");
    scanf("%d",&a);
    if (a<0){
        printf("%d est negative",a);
    }else{
        printf("%d est postive",a);
    }
}