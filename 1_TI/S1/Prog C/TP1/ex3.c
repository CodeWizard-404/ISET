#include<stdio.h>
void main(){
    int a,b,c,d;
    printf("write a: ");
    scanf("%d",&a);
    printf("write b: ");
    scanf("%d",&b);
    printf("write c: ");
    scanf("%d",&c);
    d=a;
    a=b;
    b=c;
    c=d;
    printf("a=%d\n",a);
    printf("b=%d\n",b);
    printf("c=%d\n",c);
}