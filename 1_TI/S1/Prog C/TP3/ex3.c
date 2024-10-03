#include<stdio.h>
void main()
{
    int i,f,n;
    printf("write n: ");
    scanf("%d",&n);
    f=1;
    for(i=1;i<=n;i++)
        f=f*i;
    printf("%d!= %d",n,f);
}