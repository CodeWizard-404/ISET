#include<stdio.h>
void main(){
    int q,r,a,A,b;
    printf("write a: ");
    scanf("%d",&a);
    printf("write b: ");
    scanf("%d",&b);
    q=0;
    A=a;
    while(A>=b){
        A=A-b;
        q=q+1;
    }
    r=a-(b*q);
    printf("%d\n",q);
    printf("%d\n",r);
}