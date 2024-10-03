#include<stdio.h>
void main(){
    int v1,v2,v3,v4;
    printf("write v1: ");
    scanf("%d",&v1);
    printf("write v2: ");
    scanf("%d",&v2);
    printf("write v3: ");
    scanf("%d",&v3);
    v4=v1;
    v1=v2;
    v2=v3;
    v3=v4;
    printf("v1=%d\n",v1);
    printf("v2=%d\n",v2);
    printf("v3=%d\n",v3);
}