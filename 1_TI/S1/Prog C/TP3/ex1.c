#include<stdio.h>
void main ()
{
    int i,a,b,s;
    printf("write a: ");
    scanf("%d",&a);
    printf("write b: ");
    scanf("%d",&b);
    s=0;
    for(i=0;i<a;i++)
    s=s+b;
    printf("somme=%d",s);

}
