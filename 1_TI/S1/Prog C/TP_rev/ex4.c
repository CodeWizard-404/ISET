#include<stdio.h>
#include<conio.h>
void main(){
    char a;
    printf("write a: ");
    scanf("%c",&a);
    if(a>=65 && a<89)
        printf("%c", a+1);
    else if((a>=97) && (a<121))
        printf("%c", a+1);
}