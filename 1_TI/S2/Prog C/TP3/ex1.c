#include<stdio.h>
void main(){

int x;
int *p = &x;

*p = 10; // initialisation de x via le pointeur p

int Y = *p + 1; // Y = 11
printf("Y= %d",Y);
*p = *p + 2; // x = 12, *p = 12
printf("\n*p= %d",*p);
*p += 2; // x = 14, *p = 14
printf("\n*p= %d",*p);
++*p; // x = 15, *p = 15
printf("\n*p= %d",*p);
(*p)++; // x = 16, *p = 16
printf("\n*p= %d",*p);


}
