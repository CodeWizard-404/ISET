#include<stdio.h>
void main(){
    int a;
    printf("write week: ");
    scanf("%d",&a);
    switch (a)
    {
    case 1 : printf("lundi");
        break;
    case 2 : printf("Mardi");
        break;
    case 3 : printf("Mercredi");
        break;
    case 4 : printf("Jeudi");
        break;
    case 5 : printf("Vendredi");
        break;
    case 6 : printf("Samedii");
        break;
    case 7 : printf("Dimanche");
        break;
    
    default: printf("ERROR");
        break;
    }
}