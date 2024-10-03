#include<stdio.h>
void main(){
    int a,b,q,r;
    printf("write a: ");
    scanf("%d",&a);
    printf("write b: ");
    scanf("%d",&b);
    q=a/b;
    r=a%b;
    printf("quotion= %d\n",q);
    printf("rest= %d\n",r);

}