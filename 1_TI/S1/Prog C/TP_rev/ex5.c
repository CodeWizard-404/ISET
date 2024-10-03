#include<stdio.h>
void main(){
    float r1,r2,a1,a2,a;
    printf("write R1: ");
    scanf("%f",&r1);
    printf("write R2: ");
    scanf("%f",&r2);
    a1=3.14*r1*r1;
    a2=3.14*r2*r2;
    if(a1<a2){
        a=a2-a1;
    }else{
        a=a1-a2;
    }
    printf("surface grise= %.2f",a);
}