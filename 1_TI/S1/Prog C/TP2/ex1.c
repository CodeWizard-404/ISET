#include<stdio.h>
void main(){
    int a,b,c,max,min;
    printf("write a: ");
    scanf("%d",&a);
    printf("write b: ");
    scanf("%d",&b);
    printf("write c: ");
    scanf("%d",&c);
    max=0;
    min=0;
    if(a>max){
        max=a;
    }else{
        min=a;
    }
    if(b>max){
        max=b;
    }else{
        min=b;
    }
    if(c>max){
        max=c;
    }else{
        min=c;
    }
    printf("max= %d\nmin= %d",max,min);
}