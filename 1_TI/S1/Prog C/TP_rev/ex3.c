#include<stdio.h>
void main(){
    float a,b,c;
    printf("write a: ");
    scanf("%f",&a);
    printf("write b: ");
    scanf("%f",&b);
    printf("write c: ");
    scanf("%f",&c);
    printf("%.2f",(a+b+c)/3);
}